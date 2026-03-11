package service;
import model.Patron;
import java.util.*;


public class ReservationService {

    private Map<String, Queue<Patron>> reservations = new HashMap<>();

    public void reserveBook(String isbn, Patron patron) {

        reservations
                .computeIfAbsent(isbn, k -> new LinkedList<>())
                .offer(patron);

        System.out.println(patron.getName() + " reserved book with ISBN: " + isbn);
    }


    public void notifyNext(String isbn) {

        Queue<Patron> queue = reservations.get(isbn);

        if (queue != null && !queue.isEmpty()) {

            Patron nextPatron = queue.poll();

            System.out.println(
                    "Notification: Book available for " + nextPatron.getName()
            );
        }
    }
}
