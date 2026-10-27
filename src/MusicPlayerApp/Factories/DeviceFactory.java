package MusicPlayerApp.Factories;

import MusicPlayerApp.Device.IAudioOutputDevice;
import MusicPlayerApp.Device.WiredDeviceAdapter;
import MusicPlayerApp.DeviceType;
import MusicPlayerApp.External.WiredDeviceApi;

// this is to create the object of required IAOD and the object of that particular external api
public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType dt){
        switch (dt){
            case WIRED -> {return new WiredDeviceAdapter(new WiredDeviceApi());}
            default -> {return new WiredDeviceAdapter(new WiredDeviceApi());}
        }
    }
}
