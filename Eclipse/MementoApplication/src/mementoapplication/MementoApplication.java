package mementoapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Moutaz
 */
public class MementoApplication implements ActionListener{

    // saved button
    private ButtonOriginator buttonOriginator;
    // care taker
    private CareTaker careTaker;
    
    private JFrame mainFrame;
    private JPanel panel;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints gridBagConstraints;
    private JButton button;
    private final int buttonHeight = 400 / 3;
    private final Color [] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK};
    private final String [] colorsNames = {"red", "green", "blue", "black"};
    private final String [] commandNames = {"Save", "Undo"};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MementoApplication mementoApplication = new MementoApplication();
        mementoApplication.prepareGUI();
    }
    
    private void prepareGUI() {
        
        careTaker = new CareTaker(100);
        
        // frame creation
        mainFrame = new JFrame("Memento Example");
        mainFrame.setSize(400,400);
        
        // panel creation
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        gridBagConstraints = new GridBagConstraints();
        
        createPaletteButtons();

        createSavedButton();
        
        createCommandButtons();
        
        mainFrame.add(panel);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });
        
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        mainFrame.setVisible(true);
    }

    private void createSavedButton(){
        buttonOriginator = new ButtonOriginator(Color.LIGHT_GRAY, careTaker);
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 300;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(50, 0, 50, 0);
        panel.add(buttonOriginator, gridBagConstraints);
    }
    
    private void createPaletteButtons() {
        for(int i = 0; i < 4; i++){
            button = new JButton();
            button.setBackground(colors[i]);
            button.setName(colorsNames[i]);
            button.addActionListener(this);
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 0.25;
            gridBagConstraints.gridx = i;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.ipady = buttonHeight;
            panel.add(button, gridBagConstraints);
        }
    }

    private void createCommandButtons() {
        for(int i = 0; i < 2; i++){
            button = new JButton(commandNames[i]);
            button.setFont(new Font("Arial", 0, 30));
            button.setName(commandNames[i]);
            button.addActionListener(this);
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.gridx = i * 2;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.ipady = buttonHeight;
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);
            gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
            gridBagConstraints.weighty = 1.0;
            panel.add(button, gridBagConstraints);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = ((JButton)(e.getSource())).getName();
        switch(buttonName){
            case "red":
                buttonOriginator.setColor(Color.RED);
                break;
            case "green":
                buttonOriginator.setColor(Color.GREEN);
                break;
            case "blue":
                buttonOriginator.setColor(Color.BLUE);
                break;
            case "black":
                buttonOriginator.setColor(Color.BLACK);
                break;
            case "Save":
                buttonOriginator.save();
                break;
            case "Undo":
                if (! buttonOriginator.undo())
                    JOptionPane.showMessageDialog(mainFrame, "No saved state");
                break;
            default:
        }
    }
    
}