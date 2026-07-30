package InvokerInterface;

import CommandInterface.Command;

public interface Invoker {
    void setCommand(int button, Command command);
    void pressButton(int button);
    void pressUndo();
}
