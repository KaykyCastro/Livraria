package interfaces;

import collection.ListCopies;
import exception.BookNotExistException;
import exception.CodeAlreadyExistsException;
import model.Book;

import java.util.List;

public interface BookCollection {
    public void addBook(String code, String name) throws CodeAlreadyExistsException;
    public Book getBook(String code) throws BookNotExistException;
    public void removeBooke(String code) throws BookNotExistException;
    public List<ListCopies> getAllBook();
}
