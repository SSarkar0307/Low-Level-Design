package Commands;
import CommandInterface.*;
import Devices.*;

public class AcOff implements Command{
    AC ac;

    public AcOff(AC ac){
        this.ac = ac;
    }
    
    @Override
    public void execute(){
        ac.off();
    }

    @Override
    public void undo(){
        ac.on();
    }
}
