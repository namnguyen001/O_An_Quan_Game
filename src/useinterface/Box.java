package useinterface;

import javax.swing.*;
import java.awt.*;
public class Box {
    private int pos;
    private JLabel numstone = new JLabel("5");
    Interface gameInterface;
    Process pro;
    public Box(Interface i,Process p, int pos){
        gameInterface = i;
        pro = p;
        this.pos = pos;

    }
}
