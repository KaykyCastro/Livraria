package interfaces;

import exception.BookNotExistException;
import model.Book;

import java.util.List;

public interface BookCollection {
    public void addBook(Book book);
    public Book getBook(String code) throws BookNotExistException;
    public void removeBooke(String code) throws BookNotExistException;
    public List<Book> getAllBook();
}
