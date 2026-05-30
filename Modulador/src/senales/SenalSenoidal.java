/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 * Señal senoidal pura. Calcula sus valores según la fórmula:
 * valores[i] = A * sin(2 * PI * f * tiempo[i]).
 * 
 * @author Ruth Romero
 */
public class SenalSenoidal extends Senal {

    private double A;
    private double f;
    /**
    * Constructor de la señal senoidal.
    * 
    * @param A Amplitud máxima de la señal (voltios).
    * @param f Frecuencia fundamental en Hertz (Hz).
    */
    public SenalSenoidal(double A, double f) {
        this.A = A;
        this.f = f;
    }
    /**
    * Genera los valores de la señal senoidal para cada instante de tiempo.
    * El resultado se almacena en el arreglo {@code valores} heredado de {@link Senal}.
    */
    @Override
    public void generar() {
        for (int i = 0; i < N; i++) {
            valores[i] = A * Math.sin(2 * Math.PI * f * tiempo[i]);
        }
    }
}
