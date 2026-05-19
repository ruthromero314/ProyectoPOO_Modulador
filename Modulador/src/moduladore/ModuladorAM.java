/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduladore;

/**
 *
 * @author Ruth Romero
 */
public class ModuladorAM extends Modulador {

    private double m;

    public ModuladorAM(double m) {
        this.m = m;
    }

    @Override
    public double[] modular(double[] portadora, double[] moduladora, double[] tiempo) {
        int N = Math.min(portadora.length, moduladora.length);
        double[] salida = new double[N];

        for (int i = 0; i < salida.length; i++) {
            salida[i] = (1 + m * moduladora[i]) * portadora[i];

        }
        return salida;
    }

}
