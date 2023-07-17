
import java.util.Random;
public class TestExcepciones{
public class OutOfGasException extends Exception{}
public class UnreliableFriend {
    public boolean Excepciones() throws OutOfGasException{
        Random r = new Random();
        boolean hasGas = r.nextBoolean();
        if (hasGas){
            return true;
        }
        throw new OutOfGasException();
    }
}
}
