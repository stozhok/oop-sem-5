public class Duration {
    private int minutes;
    private int seconds;
    public Duration(int minutes,int seconds){
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public void SetDuration(int minutes,int seconds){
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public int getMinutes(){return minutes;}
    public int getSeconds(){return seconds;}

    public String toString() {
        if (seconds < 10){
            return(minutes + ":0" + seconds);
        }
        else {
            return(minutes + ":" + seconds);
        }
    }
}