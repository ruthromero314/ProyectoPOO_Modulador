/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduladore;

/**
 * Modulador en Amplitud (AM). Implementa la fórmula:
 * señal_AM = (1 + m * moduladora) * portadora,
 * donde m es el índice de modulación.
 * 
 * @author Ruth Romero
 */
public class ModuladorAM extends Modulador {

    private double m;
    /**
    * Constructor del modulador AM.
    * 
    * @param m Índice de modulación (entre 0 y 1 normalmente).
    */
    public ModuladorAM(double m) {
        this.m = m;
    }
    /**
    * Aplica modulación en amplitud a las señales proporcionadas.
    * 
    * @param portadora   Señal portadora (generalmente senoidal de alta frecuencia).
    * @param moduladora  Señal moduladora (información).
    * @param tiempo      No utilizado en AM, se incluye por compatibilidad.
    * @return            Señal modulada en AM.
    */
    @Override
    public double[] modular(double[] portadora, double[] moduladora, double[] tiempo) {
        int N = Math.min(portadora.length, moduladora.length);
        double[] salida = new double[N];

        for (int i = 0; i < salida.length; i++) {
            salida[i] = (1 + m * moduladora[i]) * portadora[i];

        }
        return salida;
    }

}
