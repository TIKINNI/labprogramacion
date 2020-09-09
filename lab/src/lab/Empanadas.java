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
public class Empanadas extends Comida{
    
    private int cantidad;
    
    public Empanadas(String nombre, double precio, int cant){
        this.especialidad = nombre;
        this.precioBase = precio;
        this.cantidad = cant;
    }

    @Override
    public void calcularPrecio() {
        double precioFinal = cantidad * this.precioBase;
        System.out.println("El precio por "+cantidad+" empanadas de "+this.especialidad+" es de $"+precioFinal);
    }

    @Override
    public void preparar() {
        double tiempo = Math.random() * (25 - 15 + 1) + 15;
        System.out.println("Se estan cocinando las empanadas de "+this.especialidad+" por favor espere "+round(tiempo)+" minutos...");
    }
    
}
