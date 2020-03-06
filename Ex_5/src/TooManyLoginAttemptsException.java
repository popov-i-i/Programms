import java.lang.reflect.Executable;

public class TooManyLoginAttemptsException extends Exception {
    public TooManyLoginAttemptsException(){
        super("Слишком много запросов");
    }
}
