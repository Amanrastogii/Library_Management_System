package model;

import java.util.ArrayList;
import java.util.List;
import observer.BookObserver;



public class Patron implements BookObserver {

    private String patronId;
    private String name;
    private List<Loan> borrowingHistory;

    public Patron(String patronId, String name) {
        this.patronId = patronId;
        this.name = name;
        this.borrowingHistory = new ArrayList<>();
    }

    public void addLoan(Loan loan) {
        borrowingHistory.add(loan);
    }

    public String getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public List<Loan> getBorrowingHistory() {
        return borrowingHistory;
    }

    @Override
    public void update(Book book) {
        System.out.println("Notification: Book '"
                + book.getTitle() + "' is now available.");
    }








}


