package useinterface;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import controller.Process;
import gameinterface.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener {
    private Table table;
    private Process process;
    private int position;
    private int direction;
    private Image background; 

    public GamePanel() {
        process = new Process();
        table = new Table(process.getSquares());
        addMouseListener(this);
        addMouseMotionListener(this);
        background = new ImageIcon("src/images/background.jpg").getImage(); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
       
        g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        
        table.draw(g2d);
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
        Graphics2D g2d = (Graphics2D) getGraphics();

        //CLICK HÀNG TRÊN
        if((px > 102 && px < 137) && (py < 215 && py > 185)  ){
            System.out.println("left");
            position = 1; 
            direction = 1; 
            g2d.clearRect(0, 0, px, py);
            g2d.fillOval(px, py, 13, py);
            process.move(position, direction);
           
            
        }
        if((px > 160 && px < 195) && (py < 215 && py > 185)  ){
            System.out.println("right");
            position = 1; 
            direction = 1; 
            process.move(position, direction);
        }
        if((px > 196 && px < 232) && (py < 215 && py > 185)  ){
            System.out.println("left-2");
            position = 1; 
            direction = 2; 
            process.move(position, direction);
        }
        if((px > 255 && px < 293) && (py < 215 && py > 185)  ){
            System.out.println("right-2");
            position = 1; 
            direction = 2; 
            process.move(position, direction);
        }
        if((px > 296 && px < 332) && (py < 215 && py > 185)  ){
            System.out.println("left-3");
            position = 1; 
            direction = 3; 
            process.move(position, direction);
        }
        if((px > 355 && px < 391) && (py < 215 && py > 185)  ){
            System.out.println("right-3");
            position = 1; 
            direction = 3; 
            process.move(position, direction);
        }
        if((px > 393 && px < 429) && (py < 215 && py > 185)  ){
            System.out.println("left-4");
            position = 1; 
            direction = 4; 
            process.move(position, direction);
        }
        if((px > 452 && px < 488) && (py < 215 && py > 185)  ){
            System.out.println("right-4");
            position = 1; 
            direction = 4; 
            process.move(position, direction);
        }
        if((px > 491 && px < 527) && (py < 215 && py > 185)  ){
            System.out.println("left-5");
            position = 1; 
            direction = 5; 
            process.move(position, direction);
        }
        if((px > 551 && px < 587) && (py < 215 && py > 185)  ){
            System.out.println("right-5");
            position = 1; 
            direction = 5; 
            process.move(position, direction);
        }
        
        // CLICK HÀNG DƯỚI
        if((px > 102 && px < 137) && (py < 305 && py > 275)  ){
            System.out.println("left");
            process.move(position, direction);
        }
        if((px > 160 && px < 195) && (py < 305 && py > 275)  ){
            System.out.println("right");
            process.move(position, direction);
        }
        if((px > 196 && px < 232) && (py < 305 && py > 275)  ){
            System.out.println("left-2");
            process.move(position, direction);
        }
        if((px > 255 && px < 293) && (py < 305 && py > 275)  ){
            System.out.println("right-2");
            process.move(position, direction);
        }
        if((px > 296 && px < 332) && (py < 305 && py > 275)  ){
            System.out.println("left-3");
            process.move(position, direction);
        }
        if((px > 355 && px < 391) && (py < 305 && py > 275)  ){
            System.out.println("right-3");
            process.move(position, direction);
        }
        if((px > 393 && px < 429) && (py < 305 && py > 275)  ){
            System.out.println("left-4");
            process.move(position, direction);
        }
        if((px > 452 && px < 488) && (py < 305 && py > 275)  ){
            System.out.println("right-4");
            process.move(position, direction);
        }
        if((px > 491 && px < 527) && (py < 305 && py > 275)  ){
            System.out.println("left-5");
            process.move(position, direction);
        }
        if((px > 551 && px < 587) && (py < 305 && py > 275)  ){
            System.out.println("right-5");
            process.move(position, direction);
        }
        repaint();
    }

    
//    @Override
//    public void mousePressed(MouseEvent e) {
//        Point p = e.getPoint();
//        int px = (int) e.getX();
//        int py = (int) e.getY();
//        int[] pxRange = {102, 160, 196, 255, 296, 355, 393, 452, 491, 551};
//        int[] pyRangeTop = {185, 215};
//        int[] pyRangeBottom = {275, 305};
//
//        for (int i = 0; i < pxRange.length; i++) {
//            for (int j = 0; j < pyRangeTop.length; j++) {
//                if ((px > pxRange[i] && px < pxRange[i] + 35) && (py < pyRangeTop[j] && py > pyRangeTop[j] - 30)) {
//                    Graphics2D g2d = (Graphics2D) getGraphics();
//                    if (g2d != null) {
//                        g2d.clearRect(0, 0, getWidth(), getHeight()); 
//                        g2d.draw(getBounds());
//                    }
//                    position = j + 1;
//                    direction = i / 2 + 1;
//                    System.out.println("Position: " + position + ", Direction: " + direction);
//                    process.move(position, direction);
//                    repaint();
//                    return;
//                }
//            }
//        }
//    }

    @Override
    public void mouseReleased(MouseEvent e) {
        table.mouseReleased(e);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        table.mouseEntered(e);
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
}
