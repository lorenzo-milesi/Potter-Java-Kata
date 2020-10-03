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
        this._potter.addBook(1);
        assertEquals(8, this._potter.cost());
    }

}