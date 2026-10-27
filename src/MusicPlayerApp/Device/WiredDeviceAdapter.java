package MusicPlayerApp.Device;

import MusicPlayerApp.External.WiredDeviceApi;
import MusicPlayerApp.Song;

public class WiredDeviceAdapter implements IAudioOutputDevice {
    WiredDeviceApi wiredDeviceApi;
    String song;
    public WiredDeviceAdapter(WiredDeviceApi wiredDeviceApi){
    this.wiredDeviceApi = wiredDeviceApi;
    }
    public void playAudio(Song song){
        System.out.println("Parsing song to match wired device api");
        this.song = song.getTitle();
        wiredDeviceApi.play(this.song);
    }
}
