/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduladore;

/**
 * Modulador en Frecuencia (FM). Implementa la fórmula:
 * señal_FM = cos(2*PI*fc*t + k * ∫moduladora dt),
 * donde k es la sensibilidad del modulador.
 * 
 * @author Ruth Romero
 */
public class ModuladorFM extends Modulador {
    private double k;
    /**
    * Constructor del modulador FM.
    * 
    * @param k Constante de sensibilidad (desviación de frecuencia).
    */
    public ModuladorFM(double k) {
        this.k=k;
    }
    /**
    * Aplica modulación en frecuencia. Primero calcula la integral acumulativa
    * de la señal moduladora y luego genera la salida cosenoidal.
    * 
    * @param portadora   Señal portadora (solo se usa la amplitud implícitamente).
    * @param moduladora  Señal moduladora.
    * @param tiempo      Instantes de tiempo para calcular la fase.
    * @return            Señal modulada en FM.
    */
    @Override
    public double[] modular(double[] portadora, double[] moduladora, double[] tiempo) {
        int N = Math.min(portadora.length, moduladora.length);
        double[] salida = new double[N];
        double[] integral = new double[N];

        integral[0] = moduladora[0];

        for (int i = 1; i < N; i++) {
            integral[i] = integral[i - 1] + moduladora[i];
        }
        for (int i = 0; i < N; i++) {
            salida[i] = Math.cos(2 * Math.PI * tiempo[i] + k * integral[i]);
        }
        return salida;
    }

}
