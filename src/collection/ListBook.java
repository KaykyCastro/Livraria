package collection;

import exception.BookNotExistException;
import interfaces.BookCollection;
import model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBook implements BookCollection {

    private List<Book> books;

    public ListBook(){
        this.books = new ArrayList<Book>();
    }

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public Book getBook(String code) throws BookNotExistException {
        for(Book book : this.books){
            if(book.getCode().equals(code)){
                return book;
            }
        } throw new BookNotExistException();
    }

    @Override
    public void removeBooke(String code) throws BookNotExistException {
       Book bookToRemove = getBook(code);
       this.books.remove(bookToRemove);
    }


    @Override
    public List<Book> getAllBook() {
        return books;
    }
}
