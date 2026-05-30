/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 * Clase abstracta que representa una señal genérica en el dominio del tiempo.
 * Proporciona los vectores de tiempo y valores, así como el método abstracto
 * {@link #generar()} que deben implementar las subclases concretas.
 * 
 * @author Ruth Romero
 * @version 1.0
 */
public abstract class Senal {

    protected double[] tiempo;
    protected double[] valores;
    protected int N = 500;
    /**
    * Constructor por defecto. Inicializa los vectores de tiempo y valores
    * con 500 muestras. El tiempo se discretiza con un paso de 0.01 segundos.
    */
    public Senal() {
        tiempo = new double[N];
        valores = new double[N];
        for (int i = 0; i < N; i++) {
            tiempo[i] = i * 0.01;
        }
    }
    /**
    * Método abstracto que debe implementar cada tipo de señal para calcular
    * sus valores de amplitud en cada instante de tiempo.
    */
    public abstract void generar();
    /**
    * Devuelve el arreglo con los valores de la señal generados.
    * 
    * @return arreglo de double con las muestras de la señal.
    */
    public double[] getValores() {
        return valores;
    }
    /**
    * Devuelve el arreglo con los instantes de tiempo discretos.
    * 
    * @return arreglo de double con los tiempos (0, 0.01, 0.02, ..., 4.99).
    */
    public double[] getTiempo() {
        return tiempo;
    }
    
}
