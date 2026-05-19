/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package senales;

/**
 *
 * @author Alumnos
 */
public class SenalCuadrada extends Senal{
    private double A;
    private double f;

    public SenalCuadrada(double A, double f) {
        this.A = A;
        this.f = f;
    }

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
