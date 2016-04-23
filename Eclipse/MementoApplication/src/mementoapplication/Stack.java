package mementoapplication;

/**
*
* @author Moutaz
*/
public class Stack {
   private final int maxSize;
   private final ButtonMemento[] stackArray;
   private int top;

   public Stack(int max) {
       maxSize = max;
       stackArray = new ButtonMemento[maxSize];
       top = -1;
   }
   
   public void push(ButtonMemento memento){
       if(! isFull()){
           stackArray[++top] = memento;
       }
   }
   
   public ButtonMemento pop(){
       if(! isEmpty()){
           return stackArray[top--];
       }
       return null;
   }
   
   public Boolean isEmpty(){
       return (top == -1);
   }
   
   public Boolean isFull(){
       return (top == maxSize - 1);
   }
   
}