/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
