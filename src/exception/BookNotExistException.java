package exception;

public class BookNotExistException extends Exception{

    public BookNotExistException (){
        super("The book not exist! Please try again or create copie;");
    }

}
