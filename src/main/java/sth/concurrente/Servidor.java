package sth.concurrente;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Servidor {
    private int cantidadHilos;
    private ExecutorService hilos;
    
    public Servidor(int cant){
        this.cantidadHilos = cant;
        this.hilos = Executors.newFixedThreadPool(cant);
    }
    public Future buscarEnServidor(int uid){
        return this.hilos.submit(() -> {
            return consulta(uid);
        });
    }
    private String consulta(int uid){
       int r = (int) Math.floor(Math.random()*7500);
       System.out.println("Buscando... " + uid + "tiempo restante: "+r+"ms");
       try {
           Thread.sleep(r);
       } catch (InterruptedException e) {
       }
       return "Su numero es: "+uid;
    }
    public static void main(String[] args) throws Exception {
        Servidor elServer = new Servidor(3);
        ExecutorService PCs= Executors.newFixedThreadPool(10);
        final int[] usuarios = {1, 2, 3, 4, 5, 6, 7, 8};
        Future<String>[] futuros = new Future[usuarios.length];
        for(int i=0; i<usuarios.length; i++){
            PCs.execute(() -> {
                int r = (int) Math.floor(Math.random()*8);
                Future f = elServer.buscarEnServidor(r);
                try {
                    System.out.println(f.get());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            //futuros[i] = elServer.buscarEnServidor(usuarios[i]);
        }
    }
}
