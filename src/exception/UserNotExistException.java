package exception;

public class UserNotExistException extends Exception{
    public UserNotExistException(){
        super("User does not exist in the database!");
    }
}
