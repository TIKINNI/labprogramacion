/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronFactoryMethod;

import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;




/**
 *
 * @author larav
 */
public class MemeParejas extends Meme {

    public MemeParejas(){
        try {
            
            directorioPlantillas = "C:\\Users\\larav\\Pictures\\MemeGenerator\\Plantillas\\Parejas";
            directorioSources = "C:\\Users\\larav\\Pictures\\MemeGenerator\\Sources";

            Random r = new Random();
            //Obtengo mis plantillas
            List<String> plantillas = new ArrayList<>();
            //Obtengo mis reacciones
            List<String> reacciones = new ArrayList<>();
            //Obtengo los directorios manipulables 
            DirectoryStream<Path> dirPlantillas = Files.newDirectoryStream(Paths.get(this.directorioPlantillas));
            DirectoryStream<Path> dirReacciones = Files.newDirectoryStream(Paths.get(this.directorioSources));
            for (Path path : dirPlantillas) {
                //Para archivo dentro del directorio agrego el String de su direccion
                //En este caso plantillas
                plantillas.add(path.toString());
            }
            for (Path path : dirReacciones) {
                //IDEM pero con reacciones
                reacciones.add(path.toString());
            }
            
            //Con Plantillas y Reacciones tengo listados los archivos que puedo usar y sus direcciones

            //Genero un numero al azar entre 0 y <cantidadDeArchivosDisponibles>
            int plantillaRandom = r.nextInt(plantillas.size());
            int sourceRandom = r.nextInt(reacciones.size());
            
            // cargo las imagenes con el path y elnombre+extension del archivo
            BufferedImage plantilla = ImageIO.read(new File(plantillas.get(plantillaRandom)));;
            BufferedImage source = ImageIO.read(new File(reacciones.get(sourceRandom)));

            // me guardo las dimensiones de la plantilla
            int w =  plantilla.getWidth();
            int h = plantilla.getHeight();
            
            ancho = w;
            alto = h;

            //creo un "canvas" con el ancho y el alto de la plantilla
            BufferedImage resultado = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            
            //A continuacion se creara el meme aleatorio
            
            //Obtenemos las propiedades que creamos en combined para poder manipularlas a la hora de mezclar las fotos
            Graphics g = resultado.getGraphics();
            //Primero dibujo la plantilla, ubicado en x=0, y=0
            g.drawImage(plantilla, 0, 0, null);
            
            //Despues dibujo la imagen reaccion con: imagen, x, y, ancho, alto
            
            /*El nombre de la foto de la plantilla tiene las propiedades que ocupara la imagen reaccion
            *(su tamanio y posicion para encajar con la plantilla)
            *entonces debo extraer y manipular los datos del nombre
            */
            
            //SACO LOS DATOS DE ORIGEN Y TAMANIO QUE NECESITA LA PLANTILLA
            //Hago un arreglo de strings separadas por "#"
            String[] arreglo = plantillas.get(plantillaRandom).split("#");
            
            int x = Integer.parseInt(arreglo[1]);
            int y = Integer.parseInt(arreglo[2]);
            int anchoReaccion = Integer.parseInt(arreglo[3]);
            int altoReaccion = Integer.parseInt(arreglo[4]);
            
            //Dibujo la imagen reaccion con las propiedades necesarias
            g.drawImage(source, x, y, anchoReaccion, altoReaccion, null);
            
            imagenResultante = resultado;
            
        } catch (IOException ex) {
            Logger.getLogger(MemeParejas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public BufferedImage getImagenResultante() {
       return imagenResultante;
    }

    @Override
    public int getAncho() {
        return ancho;
    }

    @Override
    public int getAlto() {
        return alto;
    }
    
   
}
