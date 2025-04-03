package exception;

public class CopieDoesNotExistException extends Exception{
    public CopieDoesNotExistException(){
        super("Copy does not exist in copy list!");
    }
}
