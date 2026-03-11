package model;
import exception.BookAlreadyBorrowedException;
import observer.BookObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class Book {

    private String title;
    private  String author;
    private String isbn;
    private int publicationYear;
    private boolean available;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (!available) {
            throw new BookAlreadyBorrowedException("Book is already borrowed.");
        }
        this.available = false;
    }
    public void returnBook() {
        this.available = true;
        notifyObservers();
    }


    private Queue<BookObserver> reservationQueue = new LinkedList<>();
    public void addObserver(BookObserver observer) {
        reservationQueue.offer(observer);
    }


    private void notifyObservers() {
        if (!reservationQueue.isEmpty()) {
            BookObserver nextObserver = reservationQueue.poll(); // removes first
            nextObserver.update(this);
        }
    }





}