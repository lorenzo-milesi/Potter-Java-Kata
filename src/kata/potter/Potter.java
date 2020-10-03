package kata.potter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Potter {
    private final ArrayList<Integer> _books = new ArrayList<>(Arrays.asList(new Integer[5]));

    public Potter() {
        Collections.fill(this._books, 0);
    }

    public double cost() {
        return this._books.stream().filter(book -> book > 0).mapToDouble(book -> 8).sum();
    }

    public Potter addBook(int book) {
        return this.addBook(book, 1);
    }

    public Potter addBook(int book, int qty) {
        Integer originalQty = this._books.get(book);
        this._books.set(book, originalQty + qty);
        return this;
    }
}
