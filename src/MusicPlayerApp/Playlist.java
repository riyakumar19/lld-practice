package MusicPlayerApp;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    String playListName;
    List<Song> playlist;

    public Playlist(String name){
        playlist = new ArrayList<>();
        this.playListName = name;
    }

    public void addSong(Song song){
        this.playlist.add(song);
    }
}
