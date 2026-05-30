/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduladore;

/**
 * Clase abstracta que define la interfaz común para cualquier modulador.
 * 
 * @author Ruth Romero
 */
public abstract class Modulador {
    /**
    * Aplica la técnica de modulación correspondiente a la implementación concreta.
    * 
    * @param portadora   Arreglo con los valores de la señal portadora.
    * @param moduladora  Arreglo con los valores de la señal moduladora.
    * @param tiempo      Arreglo con los instantes de tiempo (para cálculos de FM).
    * @return            Arreglo con la señal modulada resultante.
    */
    public abstract double[] modular(double[] portadora,double[] moduladora,double[] tiempo);
}
