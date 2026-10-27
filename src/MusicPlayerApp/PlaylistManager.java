package MusicPlayerApp;

import java.util.Map;

public class PlaylistManager {
    Map<String, Playlist> mp;
    public void createPlayList(String name){
        mp.put(name, new Playlist(name));
    }
    public void addSong(String name, Song song){
        mp.get(name).addSong(song);
    }

}
