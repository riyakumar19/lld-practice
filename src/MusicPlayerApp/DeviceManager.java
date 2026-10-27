package MusicPlayerApp;

import MusicPlayerApp.Device.IAudioOutputDevice;
import MusicPlayerApp.Factories.DeviceFactory;

public class DeviceManager {

    public static DeviceManager instance = null;
    IAudioOutputDevice currentDevice;
    private DeviceManager(){}
    public static DeviceManager getInstance(){
        if(instance == null){
            synchronized (DeviceManager.class){
                if(instance == null) return new DeviceManager();
            }
        }
        return instance;
    }
     public void connectDevice(DeviceType dt){
         currentDevice = DeviceFactory.createDevice(dt);
     }

     public IAudioOutputDevice getCurrentDevice(){
        return this.currentDevice;
     }

}
