package useinterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import controller.Process;
import gameinterface.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener{
    private Table table;
    private Process process;
    private Box box;
    
    public GamePanel(){
        process = new Process();
        table = new Table(process.getSquares());
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;  
        table.draw(g2);
    }
    
 
    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        table.mousePressed(e);
        Point p = e.getPoint();
        int px = (int) e.getX();
        int py = (int) e.getY();

        //CLICK HÀNG TRÊN
        if((px > 102 && px < 137) && (py < 215 && py > 185)  ){
            System.out.println("left");
        }
        if((px > 160 && px < 195) && (py < 215 && py > 185)  ){
            System.out.println("right");
        }
        if((px > 196 && px < 232) && (py < 215 && py > 185)  ){
            System.out.println("left-2");
        }
        if((px > 255 && px < 293) && (py < 215 && py > 185)  ){
            System.out.println("right-2");
        }
        if((px > 296 && px < 332) && (py < 215 && py > 185)  ){
            System.out.println("left-3");
        }
        if((px > 355 && px < 391) && (py < 215 && py > 185)  ){
            System.out.println("right-3");
        }
        if((px > 393 && px < 429) && (py < 215 && py > 185)  ){
            System.out.println("left-4");
        }
        if((px > 452 && px < 488) && (py < 215 && py > 185)  ){
            System.out.println("right-4");
        }
        if((px > 491 && px < 527) && (py < 215 && py > 185)  ){
            System.out.println("left-5");
        }
        if((px > 551 && px < 587) && (py < 215 && py > 185)  ){
            System.out.println("right-5");
        }
        
        // CLICK HÀNG DƯỚI
        if((px > 102 && px < 137) && (py < 305 && py > 275)  ){
            System.out.println("left");
        }
        if((px > 160 && px < 195) && (py < 305 && py > 275)  ){
            System.out.println("right");
        }
        if((px > 196 && px < 232) && (py < 305 && py > 275)  ){
            System.out.println("left-2");
        }
        if((px > 255 && px < 293) && (py < 305 && py > 275)  ){
            System.out.println("right-2");
        }
        if((px > 296 && px < 332) && (py < 305 && py > 275)  ){
            System.out.println("left-3");
        }
        if((px > 355 && px < 391) && (py < 305 && py > 275)  ){
            System.out.println("right-3");
        }
        if((px > 393 && px < 429) && (py < 305 && py > 275)  ){
            System.out.println("left-4");
        }
        if((px > 452 && px < 488) && (py < 305 && py > 275)  ){
            System.out.println("right-4");
        }
        if((px > 491 && px < 527) && (py < 305 && py > 275)  ){
            System.out.println("left-5");
        }
        if((px > 551 && px < 587) && (py < 305 && py > 275)  ){
            System.out.println("right-5");
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        table.mouseReleased(e);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        table.mouseEntered(e);
        moveStone(e);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        table.mouseExited(e);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        table.mouseMoved(e);
        repaint();
    }  
    
    private void moveStone(MouseEvent e) {
        int px = (int) e.getX();
        int py = (int) e.getY();

        int position = -1; 
        int direction = 0; 
        boolean isEaten = false; 
        int left = 1, right = 2;

        if ((px > 192 && px < 227) && (py < 305 && py > 275)) {
            position = 1;
            direction = 1;
            process.move(position, direction, isEaten);
        } else if ((px > 247 && px < 282) && (py < 305 && py > 275)) {
            position = 2;
            direction = 2;
            process.move(position, direction, isEaten);
//        } else if  {
        }

    }

}
