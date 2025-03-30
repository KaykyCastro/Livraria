package interfaces;

import exception.BookNotExistException;
import exception.RentNotExistException;
import exception.UserNotExistException;
import model.Book;
import model.Rent;
import model.User;

public interface RentalsCollection {
    public Book getBook(String code) throws BookNotExistException;
    public User getUser(String cpf) throws UserNotExistException;
    public void setRent(Rent rent);
    public Rent getRent(String cpf, String code) throws RentNotExistException;
    public void removeRent(String cpf, String code) throws RentNotExistException;
    public double getFine(String cpf, String code) throws RentNotExistException;
}
