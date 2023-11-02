import java.util.ArrayList;
import java.util.List;

public class Disk {
    private List<Song> songs = new ArrayList<>();
    private Studio studio = new Studio();
    public Disk(){
        addSong("Song 1", "Rock", 3, 45);
        addSong("Song 2", "Pop", 4, 15);
        addSong("Song 3", "Rock", 4, 30);
        addSong("Song 4", "Pop", 5, 10);
        addSong("Song 5", "R&B", 3, 55);
        addSong("Song 6", "Country", 4, 40);
        addSong("Song 7", "R&B", 6, 20);
        addSong("Song 8", "Electronic", 3, 30);
        addSong("Song 9", "R&B", 4, 0);
        addSong("Song 10", "Electronic", 4, 50);
        studio.getSongs(songs);
        studio.getTotalDuration(songs);
        studio.sortingByGenre(songs,"R&B");
        Duration min = new Duration(3,0);
        Duration max = new Duration(4,0);
        studio.findByRange(songs,min,max);
    }
    private void addSong(String name, String genre, int minutes, int seconds) {
        Song song = new Song(name, genre, minutes, seconds);
        songs.add(song);
    }
}