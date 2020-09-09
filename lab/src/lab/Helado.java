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
public class Helado extends Comida{
    
    private double peso;
     //en gramos
    
    public Helado(String nombre, double precio, double peso){
        this.especialidad = nombre;
        this.precioBase = precio;
        this.peso = peso;
    }

    @Override
    public void calcularPrecio() {
        int criterio = 0;
        if(peso % 1000 != 0){
            //El kilo y medio sale 240
            //No es kilo redondo
            //80 pesos cada 500 gr
            criterio = (int) peso / 500 * 80;
        }else{
            criterio = (int) peso / 1000 * 135;
        }
        double precioFinal = this.precioBase + criterio;
        
        System.out.println("El precio por "+(this.peso/1000)+" kilo de helado de "+this.especialidad+" es de $"+precioFinal);
    }

    @Override
    public void preparar() {
        double tiempo = Math.random() * (5 - 2 + 1) + 2;
        System.out.println("Se esta preparando el helado de "+this.especialidad+" por favor espere "+round(tiempo)+" minutos...");
    }
    
}
