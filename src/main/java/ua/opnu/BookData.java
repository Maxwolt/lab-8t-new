package ua.opnu;

import java.util.Locale;

public class BookData implements Comparable<BookData> {

    private final String title;
    private final String author;
    private final int reviews;
    private final double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        return reviews == 0 ? 0.0 : total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        int byRating = Double.compare(other.getRating(), this.getRating());
        if (byRating != 0) {
            return byRating;
        }
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "BookData{title='%s', author='%s', rating=%.2f}",
                title, author, getRating());
    }
}
