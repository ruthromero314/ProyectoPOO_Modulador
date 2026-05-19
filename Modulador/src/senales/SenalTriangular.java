/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 *
 * @author Alumnos
 */
public class SenalTriangular extends Senal{
    private double A;
    private double f;

    public SenalTriangular(double A, double f) {
        this.A = A;
        this.f = f;
    }

    @Override
    public void generar() {
        for (int i = 0; i < N; i++) {
            // Aplicamos la fórmula basada en el arco seno
            valores[i] = (2 * A / Math.PI) * Math.asin(Math.sin(2 * Math.PI * f * tiempo[i]));
        }
    }
}
