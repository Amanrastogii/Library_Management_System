package model;

import java.time.LocalDate;

public class Loan {

    private Book book;
    private Patron patron;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Loan(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.issueDate = LocalDate.now();
    }

    public void markReturned() {
        this.returnDate = LocalDate.now();
        book.returnBook();  // change book availability
    }

    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }
}