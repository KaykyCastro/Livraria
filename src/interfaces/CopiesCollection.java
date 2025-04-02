package interfaces;

import exception.BookNotExistException;
import exception.CodeAlreadyExistsException;
import model.Book;

public interface CopiesCollection {
    public Book getBookInCopies(String code) throws BookNotExistException;
    public void addBookInCopies(String code) throws CodeAlreadyExistsException;
    public void removeBookInCopies(String code) throws BookNotExistException;
}
