package kata.potter;

import utils.lists.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Potter {
    private final ArrayList<Integer> _books = new ArrayList<>(Arrays.asList(new Integer[5]));

    public Potter() {
        Collections.fill(this._books, 0);
    }

    public double cost() {

        ArrayList<ArrayList<Integer>> decompositions = this.decompositions();

        double total = 0;
        for (ArrayList<Integer> decomposition : decompositions) {
            total += decompositionCost(decomposition);
        }

        return total;
    }

    /**
     * Decomposing array of distinct books quantities into multiple arrays of unit distinct books using binary decomposition :
     * [ 2, 1, 2, 0, 0 ] would give :
     * [ 1, 1, 1, 0, 0 ] , [ 1, 0, 1, 0, 0 ]
     *
     * @return Array of Arrays of book quantities.
     */
    private ArrayList<ArrayList<Integer>> decompositions() {
        ArrayList<Integer> remainingBooks = this._books;
        ArrayList<ArrayList<Integer>> decompositions = new ArrayList<>();
        while (remainingBooks.stream().mapToInt(b -> b).sum() > 0) {
            ArrayList<Integer> binaryDecomposition = this.binaryDecomposition(remainingBooks);
            try {
                remainingBooks = Operation.substract(remainingBooks, binaryDecomposition);
            } catch (Exception e) {
                e.printStackTrace();
            }
            decompositions.add(binaryDecomposition);
        }
        return decompositions;
    }

    /**
     * Calculates the value of one binary decomposition (how many distinct books to calculate price with discount).
     *
     * @param decomposition one binary decomposition.
     * @return The cost of the binary decomposition.
     */
    private double decompositionCost(ArrayList<Integer> decomposition) {
        double value = decomposition.stream().mapToDouble(bookQty -> 8 * bookQty).sum();
        int distinctBooks = decomposition.stream().mapToInt(b -> b).sum();
        double discountRate = switch (distinctBooks) {
            case 2 -> 0.95;
            case 3 -> 0.9;
            case 4 -> 0.8;
            case 5 -> 0.75;
            default -> 1;
        };
        return value * discountRate;
    }

    public Potter addBook(int book) {
        return this.addBook(book, 1);
    }

    public Potter addBook(int book, int qty) {
        Integer originalQty = this._books.get(book);
        this._books.set(book, originalQty + qty);
        return this;
    }

    /**
     * Cart binary decomposition.
     * The aim is to get a binary representation of distinct books examples :
     * [ 1, 1, 0, 0, 0 ] means that I bought 2 different books (the first and the second) no matter how many of each I bought.
     *
     * @return ArrayList<Integer>: an array of Integers (only 0 or 1).
     */
    private ArrayList<Integer> binaryDecomposition(ArrayList<Integer> books) {
        ArrayList<Integer> binaryDecomposition = new ArrayList<>(Arrays.asList(new Integer[5]));
        Collections.fill(binaryDecomposition, 0);
        for (int i = 0; i < 5; i++) {
            if (books.get(i) > 0) {
                binaryDecomposition.set(i, 1);
            }
        }
        return binaryDecomposition;
    }
}
