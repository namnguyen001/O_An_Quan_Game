package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Box extends Stone{
    private int index;
    protected List<Box> listBox = new ArrayList<>();
    private JButton btn; 
    protected int numberStone;

    public Box(int index) {
        super();
        this.index = index;
        if (index != 0 && index != 6) {
            this.numberStone = 5;
        } else {
            this.numberStone = 10;
        }
    }

    public void SmallGem() {
        this.value = 1;
    }
    
    public int getNumberStone() {
        return numberStone;
    }

    public void setNumberStone(int numberStone) {
        this.numberStone = numberStone;
    }

    public int getIndex() {
        return index;
    }

    public JButton getbtn() { 
        return btn;
    }
    
    public JPanel createBox() {
        JPanel panel = new JPanel(new GridLayout(2,5)); 
        for (int i = 0; i <5; i++) { 
        	  JButton button1 = new JButton();
        	  panel.add(button1);
        }
        	for (int j=6;j<11;j++) {
            JButton button = new JButton();
            panel.add(button); 
        }
        return panel;
    }
}
