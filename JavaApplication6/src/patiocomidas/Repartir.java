/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patiocomidas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author n1ko7
 */
class Repartir implements Runnable {

    Fabrica cocina;
    
    public Repartir(Fabrica co) {
        cocina = co;
    }

    @Override
    public void run() {
        
        switch((int)(Math.random()*2)){
            case 0: System.out.println("El repartidor "+Thread.currentThread().getId()+" esta llevando: "+cocina.crearPizza().toString()); break;
            case 1: System.out.println("El repartidor "+Thread.currentThread().getId()+" esta llevando: "+cocina.crearHamburguesa().toString()); break;
        }
        try {
            Thread.sleep((long)(Math.random() * 3000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Repartir.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("repartidor "+Thread.currentThread().getId()+" entregó pedido. Volviendo a la sucursal..");
        try {
            Thread.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Repartir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
