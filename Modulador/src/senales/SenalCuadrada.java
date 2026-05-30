/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 * Señal cuadrada o de onda cuadrada. Alterna entre +A y -A según el signo
 * de la función seno subyacente.
 * 
 * @author Ruth Romero
 */
public class SenalCuadrada extends Senal{
    private double A;
    private double f;
    /**
    * Constructor de la señal cuadrada.
    * 
    * @param A Amplitud (valor pico a pico).
    * @param f Frecuencia fundamental en Hz.
    */
    public SenalCuadrada(double A, double f) {
        this.A = A;
        this.f = f;
    }
    /**
    * Genera la onda cuadrada. Para cada instante, calcula el seno y asigna
    * {@code +A} si es >= 0, o {@code -A} si es negativo.
    */
    @Override
    public void generar() {
        for (int i = 0; i < N; i++) {
            double arg=Math.sin(2 * Math.PI * f * tiempo[i]);
            if(arg>=0){
                valores[i] = A;
            }else valores[i] = -A;
        }
    }
}
