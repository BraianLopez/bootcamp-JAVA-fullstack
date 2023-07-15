public class StringManipulator{

    public String trimAndConcat(String str1, String str2){
        String s1= str1.trim();
        String s2=str2.trim();
        String s3=s1.concat(s2);
        return(s3);
    }
    public int getIndexOrNull(String cadena, char letter){
        int indexOfLetter = cadena.indexOf(letter);
        return indexOfLetter;
    }
    public int getIndexOrNull( String cad1, String cad2){
        int indexCad2 = cad1.indexOf(cad2);
        return indexCad2;
    }
    public String concatSubstring( String c1, int i1, int i2, String c2){
        String cadenaNueva = c1.substring(i1,i2);
        String cadNueva = cadenaNueva.concat(c2);
        return cadNueva;
    }
}