package useinterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import gameinterface.*;
import javax.swing.JPanel;
import controller.Process;

public class GamePanel extends JPanel{
    private Table table;
    private Process process;
    private Box box;
    public GamePanel(){
        process = new Process();
		table = new Table(process.getSquares());
    }
    @Override
   public void paintComponent(Graphics g){
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;  
        table.draw(g2);
   }
}
