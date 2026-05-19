/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 *
 * @author Ruth Romero
 */
public class SenalSenoidal extends Senal {

    private double A;
    private double f;

    public SenalSenoidal(double A, double f) {
        this.A = A;
        this.f = f;
    }

    @Override
    public void generar() {
        for (int i = 0; i < N; i++) {
            valores[i] = A * Math.sin(2 * Math.PI * f * tiempo[i]);
        }
    }
}
