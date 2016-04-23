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
