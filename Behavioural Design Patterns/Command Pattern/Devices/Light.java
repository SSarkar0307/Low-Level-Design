package Devices;
import DeviceInterface.*;

public class Light implements Device{
    String LightIdentity;
    public Light(String identity){
        this.LightIdentity = identity;
    }
    @Override
    public void on(){
        System.out.println(LightIdentity + " Has been turned ON.");
    }
    @Override
    public void off(){
        System.out.println(LightIdentity + " Has been turned OFF.");
    }
}
