package collection;

import exception.BookNotExistException;
import exception.CodeAlreadyExistsException;
import exception.CopieDoesNotExistException;
import interfaces.BookCollection;
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
    public void addBookInCopie(String code, String name) throws CodeAlreadyExistsException, CopieDoesNotExistException {
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
        throw new CopieDoesNotExistException();
    }

    @Override
    public void addNewListCopies(String idCopie, Book firstCopie){
        ListCopies newCopies = new ListCopies(idCopie,firstCopie);
        this.books.add(newCopies);
    }

    @Override
    public Book getBook(String code) throws BookNotExistException {
        for(ListCopies copies : this.books){
            for(Book book : copies.getAllBooks()){
                if(book.getCode().equals(code)){
                    return book;
                }
            }
        } throw new BookNotExistException();
    }

    @Override
    public void removeBook(String code) throws BookNotExistException {
       for(ListCopies copies : books){
           if(copies.getQuantityOfCopies() != 1) {
               copies.removeBookInCopies(code);
           } else {
               books.remove(copies);
           }
       }
    }


    @Override
    public List<ListCopies> getAllBook() {
        return books;
    }
}
