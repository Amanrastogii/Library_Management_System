package service;

import exception.BookAlreadyBorrowedException;
import exception.BookNotFoundException;
import model.Book;
import model.Loan;
import model.Patron;
import repository.BookRepository;

import java.util.logging.Logger;

public class LendingService {

    private static final Logger logger =
            Logger.getLogger(LendingService.class.getName());

    private BookRepository bookRepository;

    // Constructor Injection
    public LendingService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // ------------------------------
    // Checkout Book
    // ------------------------------
    public Loan checkout(String isbn, Patron patron) {

        Book book = bookRepository.findByIsbn(isbn);

        if (book == null) {
            logger.severe("Book with ISBN " + isbn + " not found.");
            throw new BookNotFoundException("Book not found with ISBN: " + isbn);
        }

        try {
            book.borrowBook();
        } catch (BookAlreadyBorrowedException e) {
            logger.warning("Attempt to borrow already borrowed book: " + isbn);
            throw e;
        }

        Loan loan = new Loan(book, patron);
        patron.addLoan(loan);

        logger.info("Book issued successfully for ISBN: " + isbn);

        return loan;
    }

    // ------------------------------
    // Return Book
    // ------------------------------
    public void returnBook(String isbn) {

        Book book = bookRepository.findByIsbn(isbn);

        if (book == null) {
            logger.severe("Attempt to return non-existing book: " + isbn);
            throw new BookNotFoundException("Book not found with ISBN: " + isbn);
        }

        book.returnBook();

        logger.info("Book returned successfully for ISBN: " + isbn);
    }
}