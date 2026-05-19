/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 *
 * @author Ruth Romero
 */
public abstract class Senal {

    protected double[] tiempo;
    protected double[] valores;
    protected int N = 500;

    public Senal() {
        tiempo = new double[N];
        valores = new double[N];
        for (int i = 0; i < N; i++) {
            tiempo[i] = i * 0.01;
        }
    }

    public abstract void generar();

    public double[] getValores() {
        return valores;
    }

    public double[] getTiempo() {
        return tiempo;
    }
    
}
