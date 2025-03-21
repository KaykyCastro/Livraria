package collection;

import exception.BookNotExistException;
import exception.UserNotExistException;
import interfaces.RentalsCollection;
import model.Book;
import model.Rent;
import model.User;

import java.util.List;

public class ListRentals implements RentalsCollection {

    private List<Rent> rents;


    @Override
    public Book getBook(String code) throws BookNotExistException {
        return null;
    }

    @Override
    public User getUser(String cpf) throws UserNotExistException {
        return null;
    }

    @Override
    public double generateFine() {
        return 0;
    }
}
