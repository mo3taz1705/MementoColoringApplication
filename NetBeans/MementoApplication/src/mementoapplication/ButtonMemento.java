/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mementoapplication;

import java.awt.Color;

/**
 *
 * @author Moutaz
 */
public class ButtonMemento {
    private final Color color;
    
    public ButtonMemento(Color color){
        this.color = color;
    }
    
    public Color getColor(){
        return color;
    }
}
