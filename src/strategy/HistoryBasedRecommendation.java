package strategy;

import model.Book;
import model.Patron;
import model.Loan;

import java.util.ArrayList;
import java.util.List;

public class HistoryBasedRecommendation implements RecommendationStrategy {

    @Override
    public List<Book> recommend(Patron patron, List<Book> books) {

        List<Book> recommendations = new ArrayList<>();

        for (Loan loan : patron.getBorrowingHistory()) {
            recommendations.add(loan.getBook());
        }

        return recommendations;
    }
}