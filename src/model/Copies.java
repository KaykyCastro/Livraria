package model;

import exception.BookNotExistException;
import exception.UnableDeleteBookException;

import java.util.ArrayList;
import java.util.List;

public class Copies {
    List<Book> books;

    public Copies(Book firstCopie){
        this.books = new ArrayList<Book>();
        this.books.add(firstCopie);
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

    public void addBookInCopies(String code){
        if(!this.books.isEmpty()) {
            if (this.books.get(0) != null) {
                Book original = this.books.get(0);
                Book copie = new Book(original.getName(), code, original.getAuthor(), original.getCategory());
                this.books.add(copie);
            }
        }
    }

    public void removeBookInCopies(String code)throws BookNotExistException, UnableDeleteBookException {
            Book bookForDelete = getBookInCopies(code);
            if (this.books.remove(bookForDelete)){
                System.out.println("Removed successfully!");
            } else {
                throw new UnableDeleteBookException();
            }
        }

}
