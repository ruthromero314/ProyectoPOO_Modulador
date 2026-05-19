/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import moduladore.Modulador;
import senales.Senal;

/**
 *
 * @author alumnos
 */
public class Simulador {
    public double[] ejecutar(Modulador mod,Senal portadora,Senal moduladora){
        portadora.generar();
        moduladora.generar();
        return mod.modular(portadora.getValores(), moduladora.getValores(), portadora.getTiempo());
    }
}
