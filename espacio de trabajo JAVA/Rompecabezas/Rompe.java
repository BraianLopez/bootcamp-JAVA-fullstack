import java.util.ArrayList;
public class Rompe{
public ArrayList<Integer> sumaTodos(ArrayList<Integer> elementos){
    int suma=0;
    //for(int iterador=0;i<elementos.size();iterador++);
    for (int iterador : elementos){
        System.out.println("QUE ES ITERADOR "+ iterador);
        suma+= iterador();

        if(iterador >10){
            numerosMayores.add(iterador);
        }
    }
    System.out.println(suma);
    return numerosMayores;
}
}