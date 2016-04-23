/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mementoapplication;

import javax.swing.JButton;
import java.awt.Color;

/**
 *
 * @author Moutaz
 */


// Button that supports save option
public class ButtonOriginator extends JButton{
    private Color color;
    
    CareTaker careTaker;

    public ButtonOriginator(Color color, CareTaker careTaker) {
        this.color = color;
        this.careTaker = careTaker;
        
        // show button with selected color
        this.setBackground(color);
        save();  // save initial state
    }
    
    public void setColor(Color newColor){
        this.color = newColor;
        this.setBackground(color);
    }

    public final void save() {
        // save color to caretaker
        careTaker.saveMemento(new ButtonMemento(color));
    }
    
    public Boolean undo() {
        // show button with color returned from the care taker
        ButtonMemento memento = careTaker.restoreMemento();
        if(memento != null){
            setColor(memento.getColor());
            return true;
        }
        return false;
    }
}
