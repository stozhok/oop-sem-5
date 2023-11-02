import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class SongTest {
    @Test
    public void testGetGenre() {
        Song song = new Song("Test Song", "Test Genre", 3, 30);
        assertEquals("Test Genre", song.getGenre());
    }

    @Test
    public void testGetName() {
        Song song = new Song("Test Song", "Test Genre", 3, 30);
        assertEquals("Test Song", song.getName());
    }

    @Test
    public void testGetDuration() {
        Song song = new Song("Test Song", "Test Genre", 3, 30);
        Duration duration = song.getDuration();
        assertEquals(3, duration.getMinutes());
        assertEquals(30, duration.getSeconds());
    }

    @Test
    public void testSetName() {
        Song song = new Song("Test Song", "Test Genre", 3, 30);
        song.setName("New Name");
        assertEquals("New Name", song.getName());
    }

    @Test
    public void testSetGenre() {
        Song song = new Song("Test Song", "Test Genre", 3, 30);
        song.setGenre("New Genre");
        assertEquals("New Genre", song.getGenre());
    }

    @Test
    public void testSetDuration() {
        Song song = new Song("Test Song", "Test Genre", 3, 30);
        song.setDuration(2, 45);
        Duration duration = song.getDuration();
        assertEquals(2, duration.getMinutes());
        assertEquals(45, duration.getSeconds());
    }

    @Test
    public void testToString() {
        Song song = new Song("Test Song", "Test Genre", 3, 30);
        String expected = "Track name: Test Song, Duration: 3:30, Genre: Test Genre";
        assertEquals(expected, song.toString());
    }
}