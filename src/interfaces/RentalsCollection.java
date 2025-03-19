package interfaces;

import exception.BookNotExistException;
import exception.UserNotExistException;
import model.Book;
import model.User;

public interface RentalsCollection {
    public Book getBook(String code)throws BookNotExistException;
    public User getUser(String cpf)throws UserNotExistException;
    public double generateFine();
}
