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
    public void noBooksShouldCost0() {
        assertEquals(0, this._potter.cost());
    }

}