import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DurationTest {
    @Test
    public void testGetMinutes() {
        Duration duration = new Duration(3, 30);
        assertEquals(3, duration.getMinutes());
    }

    @Test
    public void testGetSeconds() {
        Duration duration = new Duration(3, 30);
        assertEquals(30, duration.getSeconds());
    }

    @Test
    public void testToStringWithLeadingZero() {
        Duration duration = new Duration(2, 5);
        assertEquals("2:05", duration.toString());
    }

    @Test
    public void testToStringWithoutLeadingZero() {
        Duration duration = new Duration(4, 45);
        assertEquals("4:45", duration.toString());
    }
}