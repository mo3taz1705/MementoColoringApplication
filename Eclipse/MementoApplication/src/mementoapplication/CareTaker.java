package mementoapplication;

/**
 *
 * @author Moutaz
 */
public class CareTaker {
    
    private final Stack stack;
    
    public CareTaker(int stackSize){
        stack = new Stack(stackSize);
    }
    
    // client requests to save a specific originator
    public void save(ButtonOriginator buttonOriginator){
        stack.push(buttonOriginator.createMemento());
    }
    
    // client requests to undo a specific originator
    public Boolean undo(ButtonOriginator buttonOriginator){
        Object poppedObject = stack.pop();
        if(poppedObject != null){
            buttonOriginator.restoreFromMemento(poppedObject);
            return true;
        }
        return false;
    }
}
