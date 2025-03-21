package exception;

public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(){
        super("There is already a user with the same CPF already registered!");
    }

}
