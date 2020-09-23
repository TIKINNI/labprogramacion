/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronFactoryMethod;

/**
 *
 * @author larav
 */
public class FabricaMemesConcreto {
    
    static Meme crearMeme(char c){
        Meme retorno;
        switch(c){
            case 'p': retorno = new MemeParejas(); break;
            case 'c': retorno = new MemeCotidiano(); break;
            default: retorno = null; break;
        }
        return retorno;
    }
    
    static boolean verificar(char c){
        boolean retorno = true;
        if(c != 'p' && c!= 'c'){
            retorno = false;
        }
        return retorno;
    }
}
