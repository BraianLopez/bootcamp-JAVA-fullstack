public class StringManipulatorTest{

    public static void main(String[]args){

        //Ejercicio1
        StringManipulator manipulator = new StringManipulator();
        String  newString = manipulator.trimAndConcat("    Cura     ","     Cocos    ");
        System.out.println(newString); 

        //Actividad 2
        // StringManipulator manipulator1 = new StringManipulator();
        char letter = 'n';
        int a = manipulator.getIndexOrNull("Coding", letter);
        int b = manipulator.getIndexOrNull("Hola Mundo", letter);
        int c = manipulator.getIndexOrNull("Saludar", letter);
        System.out.println(a); // 4
        System.out.println(b); // 7
        System.out.println(c); // -1

String word = "Hola";
String subString = "la";
String notSubString = "mundo";
int a1 = manipulator.getIndexOrNull(word, subString);
int b1 = manipulator.getIndexOrNull(word, notSubString);
System.out.println(a1); // 2
System.out.println(b1); // -1

String carp="Aguante River Plate";
String word1 = manipulator.concatSubstring(carp, 0, 8, "Cura Cocos");
System.out.println(carp);// Aguante River Plate
System.out.println(word1); // Aguante Cura Cocos
    }
}