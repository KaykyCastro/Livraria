package exception;

public class UnableDeleteBookException extends Exception{
    public UnableDeleteBookException(){
        super("Could not delete book! Please try again;");
    }
}
