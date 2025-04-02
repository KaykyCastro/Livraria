package collection;

import exception.BookNotExistException;
import exception.UnableDeleteBookException;
import interfaces.CopiesCollection;
import model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListCopies implements CopiesCollection {
    List<Book> books;

    public ListCopies(Book firstCopie){
        this.books = new ArrayList<Book>();
        this.books.add(firstCopie);
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

    public void addBookInCopies(String code){
        //Need fix addBookInCopies method, this way are not good, why i can get the data
        //in firstCopie

        if(!this.books.isEmpty()) {
            if (this.books.get(0) != null) {
                Book original = this.books.get(0);
                Book copie = new Book(original.getName(), code, original.getAuthor(), original.getCategory());
                this.books.add(copie);
            }
        }
    }

    public void addBookInCopies(Book book){
        this.books.add(book);
    }

    public void removeBookInCopies(String code)throws BookNotExistException, UnableDeleteBookException {
      //Fix this
        Book bookForDelete = getBookInCopies(code);
        if (this.books.remove(bookForDelete)){
            System.out.println("Removed successfully!");
        } else {
            throw new UnableDeleteBookException();
        }
    }
}
