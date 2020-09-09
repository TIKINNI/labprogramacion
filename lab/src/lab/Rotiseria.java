/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.Scanner;

/**
 *
 * @author larav
 */
public class Rotiseria {
    public static void main(String[] args){
        ComidaFactory fabrica = new ComidaFactory();
        Scanner sc = new Scanner(System.in);
        Comida pedido = null;
        char eleccion='-';
        int op1=0, op2=0;
        boolean valido = false;
        String especialidad="";
        double pB = 0;
        
        
        System.out.println("====// R O T I S E R I A   A S O B I \\====");
        while(!valido){
            
            System.out.println("Realice su pedido");
            System.out.println(" 'e' para Empanadas");
            System.out.println(" 'p' para Pizza");
            System.out.println(" 'h' para Helado");
            eleccion = sc.next().charAt(0);
            switch(eleccion){
                case 'e': System.out.println("Escoja el relleno");
                          System.out.println(" 1 para Carne");
                          System.out.println(" 2 para Jamon y Queso");
                          System.out.println(" 3 para Pollo");
                          op1 = sc.nextInt();

                          System.out.println("Escoja la cantidad");
                          System.out.println(" 1 para media docena");
                          System.out.println(" 2 para docena");
                          op2 = sc.nextInt();
                          
                          if(!(op1 > 3 || op1 <1 || op2 <1 || op2 >2)){
                              valido = true;
                          }
                          break;
                case 'p': System.out.println("Escoja el tipo");
                          System.out.println(" 1 para Especial");
                          System.out.println(" 2 para Napolitana");
                          System.out.println(" 3 para Palmitos");
                          op1 = sc.nextInt();

                          System.out.println("Escoja el tamaño");
                          System.out.println(" 1 para chica");
                          System.out.println(" 2 para familiar");
                          op2 = sc.nextInt();
                          
                          if(!(op1 > 3 || op1 <1 || op2 <1 || op2 >2)){
                              valido = true;
                          }
                          break;    

                case 'h': System.out.println("Escoja el sabor");
                          System.out.println(" 1 para Chocolate");
                          System.out.println(" 2 para Vainilla");
                          System.out.println(" 3 para Menta Granizada");
                          op1 = sc.nextInt();

                          System.out.println("Escoja el peso");
                          System.out.println(" 1 para medio kilo");
                          System.out.println(" 2 para kilo");
                          System.out.println(" 3 para kilo y medio");
                          System.out.println(" 4 para dos kilos");
                          op2 = sc.nextInt();
                          
                          if(!(op1 > 3 || op1 <1 || op2 <1 || op2 >4)){
                              valido = true;
                          }
                          break;
                default:  valido = false;
            }
            
            if(!valido){
                System.out.println("Algo salio mal, por favor reintente");
            }
            
        } //Fin while
        
        //String especialidad, double pB,
        switch(eleccion){
            case 'e':     
                          switch(op1){
                              case 1: especialidad = "carne"; pB = 30; break;
                              case 2: especialidad = "jamon y queso"; pB = 25; break;
                              case 3: especialidad = "pollo"; pB = 20; break;
                          }
                          break;
                case 'p': 
                          switch(op1){
                              case 1: especialidad = "especial"; pB = 360; break;
                              case 2: especialidad = "napolitana"; pB = 270; break;
                              case 3: especialidad = "palmitos"; pB = 340; break;
                          }
                          break;    

                case 'h': 
                           switch(op1){
                              case 1: especialidad = "chocolate"; pB = 20; break;
                              case 2: especialidad = "vainilla"; pB = 15; break;
                              case 3: especialidad = "menta granizada"; pB = 5; break;
                          }                                             
                          break; 
        }
        
        pedido = fabrica.pedir(eleccion, especialidad, pB, op2);
        
        pedido.calcularPrecio();
        pedido.preparar();
    }
    
}
