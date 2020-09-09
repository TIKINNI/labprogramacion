/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author larav
 */
public abstract class Comida {
    protected String especialidad;
    protected double precioBase;
    
    public abstract void calcularPrecio();
    
    public abstract void preparar();
}
