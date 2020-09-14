package sth.concurrente;

/*


import java.util.List;
import java.util.concurrent.Callable;
*/
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example {

   public static void main(String[] args) throws Exception {
       ExecutorService executor = Executors.newFixedThreadPool(10);
       //ExecutorService executor = Executors.newSingleThreadExecutor();
       Collection<Callable<String>> callables = new ArrayList<>();
       callables.add(() -> buscarEnElServer("primer tarea"));
       callables.add(() -> buscarEnElServer("segunda tarea"));
       
       /*executor.execute(() -> buscarEnElServer("primera tarea"));
       executor.execute(() -> buscarEnElServer("segunda tarea"));
       executor.execute(() -> buscarEnElServer("tercera tarea"));*/
       //submit();
       //String result = executor.invokeAny(callables);
       List<Future<String>> result = executor.invokeAll(callables);
       //System.out.println(result);

       for (Future f : result) {
           System.out.println("termino? :  " + f.isDone() + " resultado : " + f.get());
       }
       /*
       ExecutorService executor = Executors.newFixedThreadPool(10);
       int[] ids = new int[8];
       Collection<Future> results = new ArrayList<>();
       for(int i=0; i<ids.length; i++){
           ids[i] = i;
       }
       for(int i=0; i<ids.length; i++){
           results.add(executor.submit(() -> {
            return buscarEnElServer(1);
        }));
       }
       for (Future f : results) {
           System.out.println("f.isDone :  " + f.isDone() + " f.get : " + f.get());
       }*/
       /*
       Future future = executor.submit(() -> {
            return buscarEnElServer(1);
       });*/

       //System.out.println(future.get());
       /*
       Collection<Callable<String>> callables = new ArrayList<>();
       callables.add(() -> doLongWork("hi! 1"));
       callables.add(() -> doLongWork("hi! 2"));

       List<Future<String>> result = executor.invokeAll(callables);

       for (Future f : result) {
           System.out.println("f.isDone :  " + f.isDone() + " f.get : " + f.get());
       }*/

   }
   private static String buscarEnElServer(String msg) {
       int r = (int) Math.floor(Math.random()*7500);
       System.out.println("Buscando... " + msg + "tiempo restante: "+r+"ms");
       try {
           
           Thread.sleep(r);
       } catch (InterruptedException e) {
       }
       return "volvio " + msg;
   }
   /*
   private static String buscarEnElServer(int id){
       String[] usuarios = {
           "TIKINNI",
           "niconii",
           "lariiacu",
           "normalestandar",
           "rgarcia",
           "tortelinni",
           "androideDelValle",
           "laAmenazaFantasma"
       };
       int r = (int) Math.floor(Math.random()*7500);
       try {
           Thread.sleep(r);
       } catch (InterruptedException e) {
       }
       return usuarios[id];
   }
/*
   private static String doLongWork(String msg) {
       System.out.println("Running " + msg);
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return "finish " + msg;
   }
*/
}