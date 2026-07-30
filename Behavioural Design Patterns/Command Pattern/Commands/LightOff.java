package Commands;
import CommandInterface.*;
import Devices.*;

public class LightOff implements Command{
    Light light;

    public LightOff(Light light){
        this.light = light;
    }
    
    @Override
    public void execute(){
        light.off();
    }

    @Override
    public void undo(){
        light.on();
    }
}
