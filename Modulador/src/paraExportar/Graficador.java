/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paraExportar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 *
 * @author Ruth Romero
 */
public class Graficador {
    
    private double[] senalModuladora;
    private double[] senalPortadora;
    private double[] senalAM;
    private double[] senalFM;
    
    private double amplitudMod, frecuenciaMod, frecuenciaPort, indiceMod;
    private String tipoModuladora;
    private boolean usandoArchivo;
    private String nombreArchivoModuladora;
    
    private static final Color COLOR_MODULADORA = Color.decode("#F04770");
    private static final Color COLOR_PORTADORA = Color.decode("#F78C6A");
    private static final Color COLOR_AM = Color.decode("#FFD167");
    private static final Color COLOR_FM = Color.decode("#06D7A0");
    private static final Color COLOR_FONDO = Color.decode("#1A3D67");
    
    public void setDatosSenales(double[] moduladora, double[] portadora, double[] am, double[] fm) {
        this.senalModuladora = moduladora;
        this.senalPortadora = portadora;
        this.senalAM = am;
        this.senalFM = fm;
    }
    
    public void setParametrosModuladora(double amplitud, double frecuencia, String tipo, boolean desdeArchivo, String nombreArchivo) {
        this.amplitudMod = amplitud;
        this.frecuenciaMod = frecuencia;
        this.tipoModuladora = tipo;
        this.usandoArchivo = desdeArchivo;
        this.nombreArchivoModuladora = nombreArchivo;
    }
    
    public void setParametrosPortadora(double frecuenciaPortadora) {
        this.frecuenciaPort = frecuenciaPortadora;
    }
    
    public void setIndiceModulacion(double indice) {
        this.indiceMod = indice;
    }
    
    /**
     * Dibuja las señales en el Graphics proporcionado (para pantalla o imagen)
     * @param g
     * @param ancho
     * @param alto
     */
    public void dibujar(Graphics g, int ancho, int alto) {
        g.setColor(COLOR_FONDO);// Fondo
        g.fillRect(0, 0, ancho, alto);
        
        int separacion = 100;
        int startY = 40;
        
        g.setColor(Color.WHITE);// Títulos
        g.drawString("Moduladora", 20, 10);
        g.drawString("Portadora", 20, 10 + separacion);
        g.drawString("AM", 20, 10 + separacion * 2);
        g.drawString("FM", 20, 10 + separacion * 3);
        
        dibujarUna(g, senalModuladora, startY, COLOR_MODULADORA, ancho);// Dibujar cada señal
        dibujarUna(g, senalPortadora, startY + separacion, COLOR_PORTADORA, ancho);
        dibujarUna(g, senalAM, startY + separacion * 2, COLOR_AM, ancho);
        dibujarUna(g, senalFM, startY + separacion * 3, COLOR_FM, ancho);
    }
    
    private void dibujarUna(Graphics g, double[] datos, int offsetY, Color color, int ancho) {
        if (datos == null) return;
        
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, offsetY, ancho, offsetY);
        
        g.setColor(color);
        int escalaY = 20;
        int prevX = 0;
        int prevY = offsetY;
        
        for (int i = 0; i < datos.length; i++) {
            int x = i * ancho / datos.length;
            int y = offsetY - (int)(datos[i] * escalaY);
            g.drawLine(prevX, prevY, x, y);
            prevX = x;
            prevY = y;
        }
    }
    
    /**
     * Exporta el gráfico completo (señales + información técnica) a un archivo PNG
     */
    public void exportarPNG(java.awt.Component panelReferencia) {
        if (senalAM == null && senalFM == null) {
            JOptionPane.showMessageDialog(panelReferencia,
                "Primero debe generar una modulación.",
                "No hay gráfico", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        fc.setDialogTitle("Guardar gráfico como PNG");
        fc.setSelectedFile(new File("grafico_senales.png"));
        
        if (fc.showSaveDialog(panelReferencia) == javax.swing.JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".png")) {
                archivo = new File(archivo.getAbsolutePath() + ".png");
            }
            
            int w = 1025;  // Ancho fijo o se puede pasar como parámetro
            int h = 400;   // Alto de las señales
            int infoHeight = 80;
            BufferedImage img = new BufferedImage(w, h + infoHeight, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            
            
            dibujar(g, w, h);// Dibujar señales
            dibujarInfoTecnica(g, w, h, infoHeight);// Dibujar información técnica debajo
            g.dispose();
            
            try {
                ImageIO.write(img, "png", archivo);
                JOptionPane.showMessageDialog(panelReferencia,
                    "Gráfico guardado:\n" + archivo.getAbsolutePath(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(panelReferencia,
                    "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void dibujarInfoTecnica(Graphics g, int anchoTotal, int altoGrafico, int altoInfo) {
        int yInfo = altoGrafico;
        g.setColor(Color.WHITE);
        g.fillRect(0, yInfo, anchoTotal, altoInfo);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospaced", Font.PLAIN, 11));
        
        String infoModuladora;
        if (usandoArchivo && nombreArchivoModuladora != null) {
            infoModuladora = String.format("Señal moduladora: desde archivo '%s' (%d muestras)",
                nombreArchivoModuladora, senalModuladora != null ? senalModuladora.length : 0);
        } else {
            infoModuladora = String.format(java.util.Locale.US,
                "Señal moduladora: %s, A=%.2f, fm=%.2f Hz",
                tipoModuladora, amplitudMod, frecuenciaMod);
        }
        String infoPortadora = String.format(java.util.Locale.US,
            "Portadora: senoidal, A=1.00, fc=%.2f Hz", frecuenciaPort);
        String infoAM = String.format(java.util.Locale.US,
            "Modulación AM: índice m=%.3f", indiceMod);
        String infoFM = String.format(java.util.Locale.US,
            "Modulación FM: sensibilidad k=%.3f", indiceMod);
        
        int lineY = yInfo + 15;
        g.drawString(infoModuladora, 10, lineY); lineY += 15;
        g.drawString(infoPortadora, 10, lineY); lineY += 15;
        g.drawString(infoAM, 10, lineY); lineY += 15;
        g.drawString(infoFM, 10, lineY);
        
        String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        g.drawString("Exportado: " + fecha, anchoTotal - 220, yInfo + altoInfo - 10);
    }
}