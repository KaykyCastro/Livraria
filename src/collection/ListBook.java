package collection;

import exception.BookNotExistException;
import interfaces.BookCollection;
import interfaces.RentalsCollection;
import model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBook implements BookCollection {

    private List<ListCopies> books;

    public ListBook(){
        this.books = new ArrayList<ListCopies>();
    }

    @Override
    public void addBook(ListCopies book) {
        //Need fix addBook method
        this.books.add(book);
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
