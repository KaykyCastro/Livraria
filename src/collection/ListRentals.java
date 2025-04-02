package collection;

import exception.BookNotExistException;
import exception.RentNotExistException;
import exception.UserNotExistException;
import interfaces.RentalsCollection;
import model.Book;
import model.Rent;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class ListRentals implements RentalsCollection {

    private List<Rent> rents;

    public ListRentals(){
        this.rents = new ArrayList<Rent>();
    }

    @Override
    public Book getBook(String code) throws BookNotExistException {
        for(Rent rent : this.rents){
            Book rentedBook = rent.getRentBook();
            if(rentedBook.getCode().equals(code)){
                return rentedBook;
            }
        }
        throw new BookNotExistException();
    }

    @Override
    public User getUser(String cpf) throws UserNotExistException {
        for(Rent rent : this.rents){
            User userInRent = rent.getRentUser();
            if(userInRent.getCpf().equals(cpf)){
                return userInRent;
            }
        }
        throw new UserNotExistException();
    }

    @Override
    public void setRent(Rent rent) {
        this.rents.add(rent);
    }

    @Override
    public Rent getRent(String cpf, String code) throws RentNotExistException {

            for (Rent rent : this.rents){
                String rentUserCpf = rent.getRentUser().getCpf();
                String rentBookCode = rent.getRentBook().getCode();
                if(rentUserCpf.equals(cpf) && rentBookCode.equals(rentBookCode)){
                    return rent;
                };
            }
            throw new RentNotExistException();
    }

    @Override
    public void removeRent(String cpf, String code) throws RentNotExistException {
        try{
            Rent rentForRemove = this.getRent(cpf, code);
            rents.remove(rentForRemove);
        } catch (RentNotExistException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public double getFine(String cpf, String code) throws RentNotExistException {
        try {
            Rent rentForGetFine = this.getRent(cpf, code);
            return rentForGetFine.getFine();
        } catch (RentNotExistException e){
            System.out.printf(e.getMessage());
        }
        throw new RentNotExistException();
    }
}
