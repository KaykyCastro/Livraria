package collection;

import exception.BookNotExistException;
import exception.CodeAlreadyExistsException;
import interfaces.BookCollection;
import interfaces.RentalsCollection;
import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListBook implements BookCollection {

    private List<ListCopies> books;

    public ListBook(){
        this.books = new ArrayList<ListCopies>();
    }

    @Override
    public void addBook(String code, String name) throws CodeAlreadyExistsException {
        //Need fix addBook method, implement scanner if book not exist in copies
        for(ListCopies copies : books){
            Book firstCopie = copies.getFirstCopie();
            String codeFirstCopie = copies.getFirstCopie().getCode();
            String nameFirstCopie = copies.getFirstCopie().getName();
                if(!Objects.equals(codeFirstCopie, code)) {
                    if (nameFirstCopie.equals(name)) {
                        Book bookToAdd = new Book(code, firstCopie);
                        copies.addBookInCopies(bookToAdd);
                    }
                } else {
                    throw new CodeAlreadyExistsException(code);
                }
        }
    }

    @Override
    public Book getBook(String code) throws BookNotExistException {
        for(ListCopies copies : this.books){
            for(Book book : copies.books){
                if(book.getCode().equals(code)){
                    return book;
                }
            }
        } throw new BookNotExistException();
    }

    @Override
    public void removeBooke(String code) throws BookNotExistException {
        //Need fix the remove method
       Book bookToRemove = getBook(code);
       this.books.remove(bookToRemove);
    }


    @Override
    public List<ListCopies> getAllBook() {
        return books;
    }
}
