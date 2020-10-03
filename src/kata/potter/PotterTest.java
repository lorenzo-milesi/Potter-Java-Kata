package kata.potter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PotterTest {
    private Potter _potter;

    @BeforeEach
    public void setUp() {
        this._potter = new Potter();
    }

    @Test
    public void noBookCosts0() {
        assertEquals(0, this._potter.cost());
    }

    @Test
    public void oneBookCosts8() {
        this._potter.addBook(0);
        assertEquals(8, this._potter.cost());
    }

    @Test
    public void twoSameBooksCost16() {
        this._potter.addBook(0, 2);
        assertEquals(16, this._potter.cost());
    }

    @Test
    public void twoDifferentBooksHave5PercentDiscount() {
        this._potter.addBook(0).addBook(1);
        assertEquals(0.95 * 16, this._potter.cost());
    }

    @Test
    public void threeDifferentBooksHave10PercentDiscount() {
        this._potter.addBook(0).addBook(1).addBook(2);
        assertEquals(0.9 * 3 * 8, this._potter.cost());
    }

    @Test
    public void fourDifferentBooksHave20PercentDiscount() {
        this._potter.addBook(0).addBook(1).addBook(2).addBook(3);
        assertEquals(0.80 * 4 * 8, this._potter.cost());
    }

    @Test
    public void fiveDifferentBooksHave25PercentDiscount() {
        this._potter.addBook(0).addBook(1).addBook(2).addBook(3).addBook(4);
        assertEquals(0.75 * 5 * 8, this._potter.cost());
    }

    @Test
    public void discountTwoSameOneDifferent() {
        this._potter.addBook(0, 2).addBook(1);
        assertEquals(8 + (16 * 0.95), this._potter.cost());
    }
}