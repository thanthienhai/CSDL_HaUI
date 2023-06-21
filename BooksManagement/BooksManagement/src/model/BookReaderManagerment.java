package model;

import java.io.Serializable;

public class BookReaderManagerment implements Serializable {
    private Reader reader;
    private Book books;
    private int numOfBorrow; // so luong muon
    private String state; // trang thai khi muon
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public int getNumOfBorrow() {
        return numOfBorrow;
    }

    public void setNumOfBorrow(int numOfBorrow) {
        this.numOfBorrow = numOfBorrow;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BookReaderManagerment() {
    }

    public BookReaderManagerment(Reader reader, Book books, int numOfBorrow, String state) {
        this.reader = reader;
        this.books = books;
        this.numOfBorrow = numOfBorrow;
        this.state = state;
    }
}
