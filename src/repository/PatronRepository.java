package repository;

import model.Patron;

import java.util.List;

     public interface PatronRepository {

        void save(Patron patron);

        Patron findById(String id);

        void update(Patron patron);

        List<Patron> findAll();
     }

