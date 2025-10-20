import org.junit.Test;

import static org.junit.Assert.*;

public class codingbatTest {

    @Test
    public void firstHalf() {
        assertEquals("Woo", new codingbat().firstHalf("WooHoo"));
        assertEquals("Mad", new codingbat().firstHalf("MadMax"));
        assertEquals("", new codingbat().firstHalf(""));
        assertEquals("AB", new codingbat().firstHalf("ABCD"));
    }

    @Test
    public void sleepIn() {
        assertTrue(new codingbat().sleepIn(false, false));
        assertFalse(new codingbat().sleepIn(true, false));
        assertTrue(new codingbat().sleepIn(false, true));
        assertTrue(new codingbat().sleepIn(true, true));


    }
}