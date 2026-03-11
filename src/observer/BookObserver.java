package observer;

import model.Book;

public interface BookObserver {

    void update(Book book);
}