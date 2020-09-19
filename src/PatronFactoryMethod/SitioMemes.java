/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronFactoryMethod;

import java.awt.image.BufferedImage;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author larav
 */
public class SitioMemes {
    
    public static void showMeme(BufferedImage imagen){
        //Creo una ventana
        JFrame frame = new JFrame();
        //Agrego a la ventana un elemento con imagen
        frame.add(new JLabel(new ImageIcon(imagen)));
        //visualizo el frame y le doy un tamanio
        frame.setVisible(true);
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
        MemeGenerator creador = new MemeCotidianoGenerator();
        Meme meme1 = creador.crearMeme();
        showMeme(meme1.getImagenResultante());
    }
}
