package model;

import enums.Status;

public class Book {
    private String name;
    private String code;
    private String author;
    private Category category;
    private Status status;

    public Book(String name, String code, String author, Category category) {
        this.name = name;
        this.code = code;
        this.author = author;
        this.category = category;
        this.status = Status.AVAILABLE;
    }

    public Book(String code, Book book){
        this.name = book.getName();
        this.code = code;
        this.author = book.getAuthor();
        this.category = book.getCategory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
