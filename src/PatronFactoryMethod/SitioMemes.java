/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronFactoryMethod;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;



/**
 *
 * @author larav
 */
public class SitioMemes {
    
    //Metodos de ejemplo para el dominio.
    
    public static void verMeme(Meme meme){
        //Creo una ventana
        JFrame frame = new JFrame();
        //Agrego a la ventana un elemento con imagen
        frame.add(new JLabel(new ImageIcon(meme.getImagenResultante())));
        //visualizo el frame y le doy un tamanio
        frame.setVisible(true);
        frame.setSize(1000, 750);
    }
    
    public static void descargarMeme(Meme meme){
        try {
            ImageIO.write(meme.getImagenResultante(), "PNG", new File("C:\\Users\\larav\\Pictures\\MemeGenerator\\Descargas", "descarga.png"));
        } catch (IOException ex) {
            Logger.getLogger(SitioMemes.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Meme descargado.");
    }
    
    public static void puntuarMeme(Meme meme){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese la puntuacion");
        int p = sc.nextInt();
        meme.setPuntuacion(p);        
    }
    
    public static void main(String[] args){

        char tipoMeme = ' ';
        int eleccion, eleccion2, eleccion3, gestion=0, i=0;
        double promedio;
        Meme[] tanda = new Meme[0];
        boolean seguir;

        Scanner sc = new Scanner(System.in);
        
        System.out.println(ConsoleColors.RED+"Configurando Sistema...");
        seguir = true;
        while(seguir){
            System.out.println(ConsoleColors.RED+"ELIJA LA TEMATICA DE LOS MEMES");
            System.out.println("c. Memes Cotidianos");
            System.out.println("p. Memes de Parejas");
            tipoMeme = sc.next().charAt(0);
            if(!FabricaMemesConcreto.verificar(tipoMeme)){
                System.out.println("Opcion incorrecta. Reintente");
            }else{
                seguir = false;
            }
        }
        
        while(true){
            System.out.println("===MEME MANAGER 1.0===");
            System.out.println("Elija una opcion");
            System.out.println("1. Ver meme (muestra)");
            System.out.println("2. Descargar meme (muestra)");
            System.out.println("3. Gestionar tanda");
            eleccion = sc.nextInt();
            
            
            switch(eleccion){
                case 1: System.out.println(ConsoleColors.BLUE+ "Viendo meme aleatorio.");
                        verMeme(FabricaMemesConcreto.crearMeme(tipoMeme));
                        break;
                case 2:
                        System.out.println(ConsoleColors.BLUE+"Descargando meme aleatorio.");
                        descargarMeme(FabricaMemesConcreto.crearMeme(tipoMeme));
                        break;
                case 3:
                        System.out.println("En este modulo usted podra administrar una cantidad deseada de memes");
                        seguir = true;
                        while(seguir){
                            System.out.println("0. Crear tanda");
                            System.out.println("1. Ver meme");
                            System.out.println("2. Descargar meme");
                            System.out.println("3. Puntuar meme");
                            System.out.println("4. Ver puntuacion de meme");
                            System.out.println("5. Ver promedio de puntuacion");
                            System.out.println("6. SALIR");
                            eleccion2 = sc.nextInt();
                            switch(eleccion2){
                                case 0: 
                                    System.out.println("Ingrese la cantidad de memes que desea administrar");
                                    gestion = sc.nextInt();
                                    tanda = new Meme[gestion];
                                    i = 0;
                                    while (i != tanda.length) {
                                        tanda[i] = FabricaMemesConcreto.crearMeme(tipoMeme);
                                        i++;
                                    }
                                    System.out.println(ConsoleColors.BLUE+"TANDA DE: "+gestion+" MEMES CREADA.");
                                    break;
                                case 1:
                                   if(tanda.length == 0){
                                       System.out.println(ConsoleColors.RED+"No existe tanda");
                                   }else{
                                       System.out.println("Ingrese el nro. que desea examinar (Su tanda actual es de "+gestion+")");
                                       eleccion3 = sc.nextInt();
                                       if(eleccion3 >= tanda.length || eleccion3 < 0){
                                           System.out.println(ConsoleColors.RED+"nro. inaccesible.");
                                       }else{
                                           verMeme(tanda[eleccion3]);
                                           System.out.println(ConsoleColors.BLUE+"Viendo meme.");
                                       }
                                   }
                                   break;
                                case 2:
                                    if (tanda.length == 0) {
                                        System.out.println(ConsoleColors.RED+"No existe tanda");
                                    } else {
                                        System.out.println("Ingrese el nro. que desea descargar (Su tanda actual es de " + gestion + ")");
                                        eleccion3 = sc.nextInt();
                                        if (eleccion3 >= tanda.length || eleccion3 < 0) {
                                            System.out.println(ConsoleColors.RED+"nro. inaccesible.");
                                        } else {
                                            descargarMeme(tanda[eleccion3]);
                                            System.out.println(ConsoleColors.BLUE+"Meme descargado");
                                        }
                                    }
                                    break;
                                case 3:
                                    if (tanda.length == 0) {
                                        System.out.println(ConsoleColors.RED+"No existe tanda");
                                    } else {
                                        System.out.println("Ingrese el nro. que desea puntuar (Su tanda actual es de " + gestion + ")");
                                        eleccion3 = sc.nextInt();
                                        if (eleccion3 >= tanda.length || eleccion3 < 0) {
                                            System.out.println(ConsoleColors.RED+"nro. inaccesible.");
                                        } else {
                                            puntuarMeme(tanda[eleccion3]);
                                            System.out.println(ConsoleColors.BLUE+"Meme puntuado");
                                        }
                                    }
                                    break;
                                case 4:
                                    if (tanda.length == 0) {
                                        System.out.println(ConsoleColors.RED+"No existe tanda");
                                    } else {
                                        System.out.println("Ingrese el nro. cuya puntuacion desea ver (Su tanda actual es de " + gestion + ")");
                                        eleccion3 = sc.nextInt();
                                        if (eleccion3 >= tanda.length || eleccion3 < 0) {
                                            System.out.println(ConsoleColors.RED+"nro. inaccesible.");
                                        } else {
                                            System.out.println(ConsoleColors.BLUE+"Puntuacion del meme en "+eleccion+" es: "+tanda[eleccion3].getPuntuacion());
                                        }
                                    }
                                    break;
                                case 5:
                                    if (tanda.length == 0) {
                                        System.out.println(ConsoleColors.RED+"No existe tanda");
                                    } else {
                                        i = 0;
                                        promedio = 0;
                                        while(i!=tanda.length){
                                            promedio += tanda[i].getPuntuacion();
                                            i++;
                                        }
                                        System.out.println(ConsoleColors.BLUE+"El promedio de la puntuacion de los memes de esta tanda es de: "+promedio/gestion);
                                    }
                                    break;
                                case 6: seguir = false;
                                        break;
                                default: System.out.println(ConsoleColors.RED+"Opcion erronea");
                                         break;
                            }                  
                        }
                        break;
                                   
                default: System.out.println(ConsoleColors.RED+"Opcion erronea");
                         break;
            }
        }
        
    }
}
