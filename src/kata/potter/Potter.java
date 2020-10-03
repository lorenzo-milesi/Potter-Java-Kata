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
        double value = this._books.stream().mapToDouble(bookQty -> 8 * bookQty).sum();
        if (Arrays.stream(this.binaryDecomposition()).sum() == 2) {
            return value * 0.95;
        }
        if (Arrays.stream(this.binaryDecomposition()).sum() == 3) {
            return value * 0.9;
        }
        return value;
    }

    public Potter addBook(int book) {
        return this.addBook(book, 1);
    }

    public Potter addBook(int book, int qty) {
        Integer originalQty = this._books.get(book);
        this._books.set(book, originalQty + qty);
        return this;
    }

    public ArrayList<Integer> showCart() {
        return this._books;
    }

    /**
     * Cart binary decomposition.
     * The aim is to get a binary representation of distinct books examples :
     * [ 1, 1, 0, 0, 0 ] means that I bought 2 different books (the first and the second) no matter how many of each I bought.
     *
     * @return int[] : an array of int (only 0 or 1).
     */
    private int[] binaryDecomposition() {
        int[] binaryDecomposition = new int[]{0, 0, 0, 0, 0};
        for (int i = 0; i < 5; i++) {
            if (this._books.get(i) > 0) {
                binaryDecomposition[i] = 1;
            }
        }
        return binaryDecomposition;
    }
}
