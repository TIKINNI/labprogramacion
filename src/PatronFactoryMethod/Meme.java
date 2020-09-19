/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronFactoryMethod;

import java.awt.image.BufferedImage;

/**
 *
 * @author larav
 */
public abstract class Meme {
    
    //Variables
    String directorioPlantillas;
    String directorioSources;
    BufferedImage imagenResultante;
    int ancho;
    int alto;
    
    
    //Metodos  
    public abstract BufferedImage getImagenResultante();      
    
    public abstract int getAncho();
    
    public abstract int getAlto();
    
}
