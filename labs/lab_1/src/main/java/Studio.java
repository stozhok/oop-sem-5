import java.util.List;

public class Studio {
    public void getSongs(List<Song> songs){
        for (Song song : songs){
            System.out.println(song.toString());
        }
        System.out.println();
    }
    public void getTotalDuration(List<Song> songs){
        int totalMinutes = 0;
        int totalSeconds = 0;
        for(int i = 0; i< songs.size(); i++){
            totalMinutes += songs.get(i).getDuration().getMinutes();
            totalSeconds += songs.get(i).getDuration().getSeconds();
            if(totalSeconds >= 60){
                totalMinutes++;
                totalSeconds -= 60;
            }
        }
        System.out.println("Total duration: " + totalMinutes + ":" +totalSeconds);
    }
    public void sortingByGenre(List<Song> songs, String genre){
        System.out.println("Sorting by Genre:");
        for (Song song : songs){
            if (song.getGenre() == genre) {
                System.out.println(song.toString());
            }
        }
        for (Song song : songs){
            if (song.getGenre() != genre){
                System.out.println(song.toString());
            }
        }
    }
    public void findByRange(List<Song> songs, Duration min, Duration max){
        System.out.println("Find by range:");
        boolean isEmpty = true;
        for (int i = 0; i<songs.size(); i++){
            int minSum = 0;
            minSum += min.getMinutes()*60;
            minSum += min.getSeconds();

            int maxSum = 0;
            maxSum += max.getMinutes()*60;
            maxSum += max.getSeconds();

            int trackSize = 0;
            trackSize += songs.get(i).getDuration().getMinutes()*60;
            trackSize += songs.get(i).getDuration().getSeconds();
            if(trackSize >= minSum && trackSize <= maxSum){
                isEmpty = false;
                System.out.println(songs.get(i).toString());
            }
        }
        if(isEmpty){
            System.out.println("There are no such tracks");
        }
    }
}