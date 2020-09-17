/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patiocomidas;

/**
 *
 * @author n1ko7
 */
public class FabricaVegana implements Fabrica {

    @Override
    public Pizza crearPizza() {
        return new PizzaConPapa();
    }

    @Override
    public Hamburguesa crearHamburguesa() {
        return new HamburguesaSoja();
    }
    
}
