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
public class ComidaFactory {
    
    public Comida pedir(char tipo, String especialidad, double pB, int opcion){
        Comida pedidoNuevo = null;
        switch(tipo){
            case 'e':   
                        switch(opcion){
                            //1 -> Media docena
                            //2 -> Docena
                            case 1: pedidoNuevo = new Empanadas(especialidad, pB, 6);break;
                            case 2: pedidoNuevo = new Empanadas(especialidad, pB, 12);break;
                        }
                        break;
            case 'p':
                        switch(opcion){
                            //1 -> chica
                            //2 -> familiar
                            case 1: pedidoNuevo = new Pizza(especialidad, pB, 'c');break;
                            case 2: pedidoNuevo = new Pizza(especialidad, pB, 'f');break;
                        }
                        break;
            case 'h':
                        switch(opcion){
                            //1 -> 500 gr
                            //2 -> 1000 gr
                            //3 -> 1500 gr
                            //4 -> 2000 gr
                            case 1: pedidoNuevo = new Helado(especialidad, pB, 500);break;
                            case 2: pedidoNuevo = new Helado(especialidad, pB, 1000);break;
                            case 3: pedidoNuevo = new Helado(especialidad, pB, 1500);break;
                            case 4: pedidoNuevo = new Helado(especialidad, pB, 2000);break;
                        }
                        break;
        }
        return pedidoNuevo;
    }
    
}
