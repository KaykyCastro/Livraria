package collection;

import exception.BookNotExistException;
import interfaces.CopiesCollection;
import model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListCopies implements CopiesCollection {
    private String idCopie;
    private List<Book> books;
    private int quantityOfCopies;

    public ListCopies(String idCopie, Book firstCopie){
        this.idCopie = idCopie;
        this.books = new ArrayList<Book>();
        this.books.add(firstCopie);
        this.quantityOfCopies = 1;
    }

    @Override
    public Book getFirstCopie() {
        return books.getFirst();
    }

    public Book getBookInCopies(String code) throws BookNotExistException {
        if(!this.books.isEmpty()){
            for (Book book : this.books){
                if(book.getCode().equals(code)){
                    return book;
                }
            }
        }
        throw new BookNotExistException();
    }

    @Override
    public int getQuantityOfCopies(){
        return quantityOfCopies;
    };

    @Override
    public List<Book> getAllBooks(){
        return books;
    };

    public void addBookInCopies(String code){
        if(!this.books.isEmpty()) {
            if (this.books.getFirst() != null) {
                Book original = this.books.getFirst();
                Book copie = new Book(original.getName(), code, original.getAuthor(), original.getCategory());
                this.books.add(copie);
                this.quantityOfCopies += 1;
            }
        }
    }

    public void addBookInCopies(Book book){
        this.books.add(book);
    }

    public void removeBookInCopies(String code)throws BookNotExistException{
        Book bookForDelete = getBookInCopies(code);
        this.books.remove(bookForDelete);
    }
}
