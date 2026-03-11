package repository;

import model.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {

    private Map<String, Book> books = new HashMap<>();

    @Override
    public void save(Book book) {
        books.put(book.getIsbn(), book);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return books.get(isbn);
    }

    @Override
    public void delete(String isbn) {
        books.remove(isbn);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return books.values()
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.values()
                .stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    @Override
    public List<Book> findAvailableBooks() {
        return books.values()
                .stream()
                .filter(Book::isAvailable)
                .toList();
    }

    @Override
    public List<Book> findBorrowedBooks() {
        return books.values()
                .stream()
                .filter(book -> !book.isAvailable())
                .toList();
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void updateBook(Book book) {
        books.put(book.getIsbn(), book);
    }
}