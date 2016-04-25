package mementoapplication;

/**
 *
 * @author Moutaz
 */
public class Stack {
    private final int maxSize;
    private final Object[] stackArray;
    private int top;

    public Stack(int max) {
        maxSize = max;
        stackArray = new Object[maxSize];
        top = -1;
    }
    
    public void push(Object memento){
        if(! isFull()){
            stackArray[++top] = memento;
        }
    }
    
    public Object pop(){
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
