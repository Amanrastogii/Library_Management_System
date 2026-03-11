package repository;

import model.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findByIsbn(String isbn);

    void delete(String isbn);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findAvailableBooks();

    List<Book> findBorrowedBooks();

    void removeBook(String isbn);

    void updateBook(Book book);
}