package exception;

public class CodeAlreadyExistsException extends Exception {
    public CodeAlreadyExistsException(String code){
        super("The code " + "'" + code + "'" + "Already exists, try other!");
    }
}
