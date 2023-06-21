package model;

import java.io.Serializable;

public class Book implements Serializable {
    public static int id = 100000;
    private int bookID;
    private String bookName;
    private String author;
    private String specialization;
    private int publishYear;
    private int quantity;

    public Book(int bookID) {
        this.bookID = bookID;
    }

    public Book() {
       // setBookID();
    }

    public Book(String bookName, String author,
                String specialization, int publishYear, int quantity) {
        setBookID();// id tu tang
        this.bookName = bookName;
        this.author = author;
        this.specialization = specialization;
        this.publishYear = publishYear;
        this.quantity = quantity;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID() {
        this.bookID = id++;
    }

    public void setBookID(int id){
        bookID = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[bookID= " + bookID + ", bookName= " + bookName
                + ", specialization= " + specialization + ", author= " + author
                + ", publishYear= " + publishYear + ", quantity= " + quantity + "]";
    }
}
