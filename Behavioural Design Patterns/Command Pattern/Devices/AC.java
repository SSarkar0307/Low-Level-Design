package Devices;
import DeviceInterface.*;

public class AC implements Device{
    String ACIdentity;

    public AC(String identity){
        this.ACIdentity = identity;
    }
    @Override
    public void on(){
        System.out.println(ACIdentity + " Has been turned ON.");
    }
    @Override
    public void off(){
        System.out.println(ACIdentity + " Has been turned OFF.");
    }
}
