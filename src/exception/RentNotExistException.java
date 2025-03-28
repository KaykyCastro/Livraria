package exception;

public class RentNotExistException extends Exception{
    public RentNotExistException(){
        super("The rental you are looking for does not exist!");
    }
}
