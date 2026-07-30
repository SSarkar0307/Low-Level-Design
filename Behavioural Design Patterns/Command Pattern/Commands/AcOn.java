package Commands;
import CommandInterface.*;
import Devices.*;

public class AcOn implements Command{
    AC ac;

    public AcOn(AC ac){
        this.ac = ac;
    }
    
    @Override
    public void execute(){
        ac.on();
    }

    @Override
    public void undo(){
        ac.off();
    }
}
