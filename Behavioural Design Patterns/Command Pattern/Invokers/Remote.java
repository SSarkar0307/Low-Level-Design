package Invokers;
import InvokerInterface.*;
// import Commands.*;
import CommandInterface.*;
import java.util.*;

public class Remote implements Invoker{
    Command[] buttons = new Command[4];
    Stack<Command> actions = new Stack<>();

    @Override
    public void setCommand(int button, Command command){
        buttons[button] = command;
    }

    @Override
    public void pressButton(int button){
        if(buttons[button] != null){
            buttons[button].execute();
            actions.push(buttons[button]);
        } else{
            System.out.println("No Command assigned to button : " + button);
        }
    }

    @Override
    public void pressUndo(){
        if(!actions.empty()){
            Command lastAction = actions.pop();
            lastAction.undo();
        } else{
            System.out.println("No Commands to Undo.");
        }
    }

}
