/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package paraExportar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Ruth Romero
 */
public class ExportadorDatos {
    
    public static void exportar(String titulo, double[] datos, java.awt.Component padre) {
        if (datos == null) {
            JOptionPane.showMessageDialog(padre,
                "No hay datos para exportar. Primero genere una modulación.",
                "Sin datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle(titulo);
        fc.setSelectedFile(new File("senal.dat"));
        
        if (fc.showSaveDialog(padre) == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            try (PrintWriter pw = new PrintWriter(archivo)) {
                for (double v : datos) {
                    pw.printf(java.util.Locale.US, "%.6f%n", v);
                }
                JOptionPane.showMessageDialog(padre,
                    "Archivo guardado:\n" + archivo.getAbsolutePath(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(padre,
                    "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}