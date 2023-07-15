import java.util.ArrayList;
import java.util.Random;

public class TestRompe{
    public static void main(String[]args){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(5);
        numeros.add(4);
        numeros.add(3);
        numeros.add(2);
        numeros.add(1);

        Rompe ejercicio1 = new Rompe();
        System.out.println(ejercicio1.sumaTodos(numeros));
    }
}