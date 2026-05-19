/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduladore;

/**
 *
 * @author Alumnos
 */
public class ModuladorFM extends Modulador {
    private double k;

    public ModuladorFM(double k) {
        this.k=k;
    }
    
    @Override
    public double[] modular(double[] portadora, double[] moduladora, double[] tiempo) {
        int N = Math.min(portadora.length, moduladora.length);
        double[] salida = new double[N];
        double[] integral = new double[N];

        integral[0] = moduladora[0];

        for (int i = 1; i < N; i++) {
            integral[i] = integral[i - 1] + moduladora[i];
        }
        for (int i = 0; i < N; i++) {
            salida[i] = Math.cos(2 * Math.PI * tiempo[i] + k * integral[i]);
        }
        return salida;
    }

}
