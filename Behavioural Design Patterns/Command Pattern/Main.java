import Devices.*;
import Invokers.Remote;
import CommandInterface.*;
import Commands.*;
// import DeviceInterface.*;

public class Main{
    public static void main(String[] args) {
        Light hallLight = new Light("Hall Light");
        AC hallAc = new AC("Hall AC");

        Light diningLight = new Light("Dining Light");
        AC diningAc = new AC("Dining AC");

        Command hallLightOn = new LightOn(hallLight);
        Command hallLightOff = new LightOff(hallLight);

        Command diningLightOn = new LightOn(diningLight);
        Command diningLightOff = new LightOff(diningLight);

        Command hallAcOn = new AcOn(hallAc);
        Command hallActOff = new AcOff(hallAc);
        
        Command diningAcOn = new AcOn(diningAc);
        Command diningAcOff = new AcOff(diningAc);


        Remote hallRemote = new Remote();
        hallRemote.setCommand(0, hallLightOn);
        hallRemote.setCommand(1, hallLightOff);
        hallRemote.setCommand(2, hallAcOn);
        hallRemote.setCommand(3, hallActOff);
        
        Remote diningRemote = new Remote();
        diningRemote.setCommand(0, diningLightOn);
        diningRemote.setCommand(1, diningLightOff);
        diningRemote.setCommand(2, diningAcOn);
        diningRemote.setCommand(3, diningAcOff);

        diningRemote.pressButton(0);
        diningRemote.pressButton(2);
        diningRemote.pressButton(3);
        diningRemote.pressUndo();

        hallRemote.pressButton(2);
        hallRemote.pressUndo();
    }
}