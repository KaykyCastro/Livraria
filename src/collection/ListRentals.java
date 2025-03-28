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
    //Need create Override Methods;
}
