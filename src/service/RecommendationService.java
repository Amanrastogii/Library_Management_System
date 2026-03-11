package service;

import model.Book;
import model.Patron;
import strategy.RecommendationStrategy;

import java.util.List;

public class RecommendationService {

    private RecommendationStrategy strategy;

    public RecommendationService(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> recommend(Patron patron, List<Book> books) {
        return strategy.recommend(patron, books);
    }
}