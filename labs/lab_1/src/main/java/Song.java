public class Song {
    private String name;
    private String genre;
    private Duration duration;
    public Song(String name, String genre, int minutes, int seconds){
        this.name = name;
        this.genre = genre;
        this.duration = new Duration(minutes, seconds);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setDuration(int minutes, int seconds) {
        this.duration = new Duration(minutes,seconds);
    }

    public String getGenre() {return genre;}
    public String getName() {return name;}
    public Duration getDuration() {return duration;}

    public String toString() {
        return "Track name: " + getName() + ", Duration: " + getDuration() + ", Genre: " +getGenre();
    }
}