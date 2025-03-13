package model;

import exception.BookNotExistException;
import exception.UnableDeleteBookException;

import java.util.ArrayList;
import java.util.List;

public class Copies {
    List<Book> books;

    public Copies(Book firstCopie){
        this.books = new ArrayList<Book>();
        books.add(firstCopie);
    }

    public Book getBookInCopies(int code) throws BookNotExistException {
        if(!books.isEmpty()){
            for (Book book : books){
                if(book.getCode() == code){
                    return book;
                }
            }
        }
        throw new BookNotExistException();
    }

    public void addBookInCopies(int code){
        if(!books.isEmpty()) {
            if (books.get(0) != null) {
                Book original = books.get(0);
                Book copie = new Book(original.getName(), code, original.getAuthor(), original.getCategory());
                books.add(copie);
            }
        }
    }

    public void removeBookInCopies(int code)throws BookNotExistException, UnableDeleteBookException {
            Book bookForDelete = getBookInCopies(code);
            if (books.remove(bookForDelete)){
                System.out.println("Removed successfully!");
            } else {
                throw new UnableDeleteBookException();
            }
        }

}
