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

    public ButtonOriginator(Color color) {
        this.color = color;
        
        // show button with selected color
        this.setBackground(color);
    }
    
    public void setColor(Color newColor){
        this.color = newColor;
        this.setBackground(color);
    }

    // create Memento to save in the careTaker
    public ButtonMemento createMemento() {
        return(new ButtonMemento(color));
    }
    
    // restore to the Memento given from the CareTaker
    public void restoreFromMemento(Object mementoObject) {
        ButtonMemento memento = (ButtonMemento) mementoObject;
        setColor(memento.color);
    }
    
    // Memento inner class, to be accessed only by its Originator
    private class ButtonMemento {
        private Color color;
        
        public ButtonMemento(Color color){
            this.color = color;
        }
        
    }
}
