package interfaces;

import collection.ListCopies;
import exception.BookNotExistException;
import exception.CodeAlreadyExistsException;
import exception.CopieDoesNotExistException;
import model.Book;

import java.util.List;

public interface BookCollection {
    public void addBookInCopie(String code, String name) throws CodeAlreadyExistsException, CopieDoesNotExistException;
    public void addNewListCopies(String idCopie,Book firstCopie);
    public Book getBook(String code) throws BookNotExistException;
    public void removeBook(String code) throws BookNotExistException;
    public List<ListCopies> getAllBook();
}
