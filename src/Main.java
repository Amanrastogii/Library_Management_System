import model.Book;
import model.Patron;
import repository.BookRepository;
import repository.InMemoryBookRepository;
import service.LendingService;
import service.ReservationService;
import service.RecommendationService;
import strategy.RecommendationStrategy;
import strategy.HistoryBasedRecommendation;

import exception.BookAlreadyBorrowedException;
import exception.BookNotFoundException;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ------------------------------
        // Create Repositories
        // ------------------------------
        BookRepository bookRepository = new InMemoryBookRepository();

        // ------------------------------
        // Create Services
        // ------------------------------
        LendingService lendingService = new LendingService(bookRepository);
        ReservationService reservationService = new ReservationService();

        // Strategy Pattern
        RecommendationStrategy strategy = new HistoryBasedRecommendation();
        RecommendationService recommendationService =
                new RecommendationService(strategy);

        // ------------------------------
        // Create Books
        // ------------------------------
        Book b1 = new Book("Clean Code", "Robert Martin", "111", 2008);
        Book b2 = new Book("Effective Java", "Joshua Bloch", "222", 2018);

        bookRepository.save(b1);
        bookRepository.save(b2);

        // ------------------------------
        // Create Patrons
        // ------------------------------
        Patron aman = new Patron("P1", "Aman");
        Patron priya = new Patron("P2", "Priya");

        // ------------------------------
        // Lending Process
        // ------------------------------
        try {

            lendingService.checkout("111", aman);

            // Attempt second checkout (will throw exception)
            lendingService.checkout("111", priya);

        } catch (BookAlreadyBorrowedException e) {
            System.out.println(e.getMessage());
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ------------------------------
        // Reservation System
        // ------------------------------
        reservationService.reserveBook("111", priya);

        // ------------------------------
        // Inventory Management
        // ------------------------------
        System.out.println("\nBorrowed Books:");

        List<Book> borrowed = bookRepository.findBorrowedBooks();

        for (Book book : borrowed) {
            System.out.println(book.getTitle());
        }

        System.out.println("\nAvailable Books:");

        List<Book> available = bookRepository.findAvailableBooks();

        for (Book book : available) {
            System.out.println(book.getTitle());
        }

        // ------------------------------
        // Recommendation System
        // ------------------------------
        System.out.println("\nRecommended Books:");

        List<Book> recommended =
                recommendationService.recommend(
                        aman,
                        bookRepository.findAvailableBooks()
                );

        for (Book book : recommended) {
            System.out.println("Recommended: " + book.getTitle());
        }

        // ------------------------------
        // Return Book
        // ------------------------------
        lendingService.returnBook("111");

        // Notify next patron in reservation queue
        reservationService.notifyNext("111");

    }
}