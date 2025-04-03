package interfaces;

import collection.ListCopies;
import exception.BookNotExistException;
import exception.CodeAlreadyExistsException;
import model.Book;

import java.util.List;

public interface CopiesCollection {
    public Book getFirstCopie();
    public Book getBookInCopies(String code) throws BookNotExistException;
    public int getQuantityOfCopies();
    public List<Book> getAllBooks();
    public void addBookInCopies(String code) throws CodeAlreadyExistsException;
    public void removeBookInCopies(String code) throws BookNotExistException;
}
