/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 * Señal triangular con forma de diente de sierra simétrico.
 * Se genera mediante la fórmula basada en la función arco seno del seno.
 * 
 * @author Ruth Romero
 */
public class SenalTriangular extends Senal{
    private double A;
    private double f;
    /**
    * Constructor de la señal triangular.
    * 
    * @param A Amplitud máxima.
    * @param f Frecuencia fundamental en Hz.
    */
    public SenalTriangular(double A, double f) {
        this.A = A;
        this.f = f;
    }
    /**
    * Genera la señal triangular usando la expresión:
    * valores[i] = (2*A/PI) * arcsin(sin(2*PI*f*tiempo[i])).
    */
    @Override
    public void generar() {
        for (int i = 0; i < N; i++) {
            // Aplicamos la fórmula basada en el arco seno
            valores[i] = (2 * A / Math.PI) * Math.asin(Math.sin(2 * Math.PI * f * tiempo[i]));
        }
    }
}
