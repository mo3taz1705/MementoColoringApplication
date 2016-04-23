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
   
   public void saveMemento(ButtonMemento memento){
       stack.push(memento);
   }
   
   public ButtonMemento restoreMemento(){
       return stack.pop();
   }
}