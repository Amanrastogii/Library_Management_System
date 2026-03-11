package repository;

import model.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPatronRepository implements PatronRepository {

    private Map<String, Patron> patrons = new HashMap<>();

    public void save(Patron patron) {
        patrons.put(patron.getPatronId(), patron);
    }

    public Patron findById(String id) {
        return patrons.get(id);
    }

    public void update(Patron patron) {
        patrons.put(patron.getPatronId(), patron);
    }

    public List<Patron> findAll() {
        return new ArrayList<>(patrons.values());
    }
}