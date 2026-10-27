package MusicPlayerApp;

import MusicPlayerApp.Device.IAudioOutputDevice;

public class AudioEngine {
    public Song currSong;
    private boolean songPaused;

    public void play(IAudioOutputDevice aod, Song song){
        aod.playAudio(song);
    }

    public void pause(Song song){
        if(this.currSong.equals(song)){
            songPaused = true;
            System.out.println("Song is paused");
        }
        else{
            throw new RuntimeException("Restart, an error occured");
        }
    }
}
