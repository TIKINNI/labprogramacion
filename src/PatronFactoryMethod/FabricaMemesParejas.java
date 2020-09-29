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
public class FabricaMemesParejas implements FabricaMemes{

    @Override
    public Meme crearMeme() {
       return new MemeParejas();
    }
    
}
