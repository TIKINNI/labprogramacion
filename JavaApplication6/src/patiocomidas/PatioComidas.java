/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patiocomidas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author n1ko7
 */
public class PatioComidas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Fabrica comeSano = new FabricaVegana();
        Fabrica comeRico = new FabricaOmnivora();
        
        ExecutorService patio = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 20; i++) {
            switch((int)(Math.random()*2 )){
                case 0: patio.execute(new Repartidor(comeSano));break;
                case 1: patio.execute(new Repartidor(comeRico));break;
            }
            
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PatioComidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Se cierra el patio de Comidas.");
        //patio.shutdownNow();
        patio.shutdown();
        //L: Cambiado por que shutdownNow cortaba los sleeps y tiraba error
    }
    
}
