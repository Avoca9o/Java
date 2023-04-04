import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.example.PopcornCooker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestChunk {
    private PopcornCooker pc;

    @BeforeEach
    public void init() {
        pc = new PopcornCooker(4);
    }

    @Test
    public void testOneRequest() {
        assertEquals(pc.makePopcorn("sw"), "Sweet popcorn");
    }

    @Test
    public void testManyRequests() {
        assertEquals(pc.makePopcorn("sw"), "Sweet popcorn");
        assertEquals(pc.makePopcorn("sa"), "Salted popcorn");
        assertEquals(pc.makePopcorn("ca"), "Caramel popcorn");
    }

    @Test
    public void testWrongRequest() {
        assertThrows(IllegalArgumentException.class, () -> {
            pc.makePopcorn("bad");
        });
    }

    @Test
    public void testTooMuchRequests() {
        assertEquals(pc.makePopcorn("sw"), "Sweet popcorn");
        assertEquals(pc.makePopcorn("sw"), "Sweet popcorn");
        assertEquals(pc.makePopcorn("sw"), "Sweet popcorn");
        assertEquals(pc.makePopcorn("sw"), "Sweet popcorn");
        assertNull(pc.makePopcorn("sw"));
        assertNull(pc.makePopcorn("sw"));
    }
}
