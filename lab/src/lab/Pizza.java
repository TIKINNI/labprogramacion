/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import static java.lang.Math.round;

/**
 *
 * @author larav
 */
public class Pizza extends Comida{
    
     private char tamanio;
     //f -> familiar, c -> chica
    
    public Pizza(String nombre, double precio, char tamanio){
        this.especialidad = nombre;
        this.precioBase = precio;
        this.tamanio = tamanio;
    }

    @Override
    public void calcularPrecio() {
        int criterio = 0;
        String nombreLargo = "";
        switch(this.tamanio){
            case 'f': criterio = 60; nombreLargo = "familiar"; break;
            case 'c': criterio = 10; nombreLargo = "chica"; break;
        }
        double precioFinal = this.precioBase + criterio;
        
        System.out.println("El precio por una pizza "+nombreLargo+" de "+this.especialidad+" es de $"+precioFinal);
    }

    @Override
    public void preparar() {
        double tiempo = Math.random() * (30 - 10 + 1) + 10;
        System.out.println("Se esta preparando la pizza de "+this.especialidad+" por favor espere "+round(tiempo)+" minutos...");
    }
    
}
