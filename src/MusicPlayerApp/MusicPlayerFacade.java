package MusicPlayerApp;

import MusicPlayerApp.Device.IAudioOutputDevice;

public class MusicPlayerFacade {
     private static MusicPlayerFacade instance = null;
     private AudioEngine ae;
     private DeviceType dt;
     private MusicPlayerFacade(){
          ae = new AudioEngine();
     }
     public static MusicPlayerFacade getMusicPlayer(){
          if(instance == null){
               synchronized (MusicPlayerFacade.class){
                    if(instance == null){
                         instance = new MusicPlayerFacade();
                    }
               }
          }
          return instance;
     }

     // for connecting
     public void connect(DeviceType dt){
          DeviceManager.getInstance().connectDevice(dt);
     }

     // for getting the current device
     public IAudioOutputDevice getDevice(){
          return DeviceManager.getInstance().getCurrentDevice();
     }

     public void play(Song song){
          ae.play(this.getDevice(), song);
     }

     public void pause(Song song){
          ae.pause(song);
     }







}
