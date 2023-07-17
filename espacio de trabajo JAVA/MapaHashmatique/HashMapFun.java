import java.util.HashMap;
import java.util.Set;
public class HashMapFun {
    public static void main(String[] args) {
         //creacion y asignacion de claves y valores a un HashMap
        HashMap<String, String> trackList = new HashMap<String,String>();
        trackList.put("Fuego", "Esta vez es en serio, no estoy mintiendo, algo se prende fuego");
        trackList.put("No tengo ganas", "No tengo ganas de seguir, pero tampoco tengo ganas de parar");
        trackList.put("Niña de tilcara", "Buenos dias ninia de tilcara");
        trackList.put("El rey", "Si hoy el dia nublado te amanecio maniana el sol podra brillar");
       String cancion = trackList.get("El rey");
       System.out.println(cancion);
        // Muestra la lista de titulos y canciones iterando el hashmap
        Set<String> canciones = trackList.keySet();
         for(String key : canciones) {
             System.out.println(key);
             System.out.println(trackList.get(key));    
         }
    }
}

