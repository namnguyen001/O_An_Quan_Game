package gameinterface;

import javax.swing.*;

import useinterface.MainGame;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Table extends JFrame {

    public static int WIDTH = 100, HEIGHT = 100, HEIGHT_QUAN = 200, X = 50, Y = 50;
    public static final int[] coordinatesX = { 20, 60, 40, 20, 60, 50, 80, 60, 70, 60 };
    public static final int[] coordinatesY = { 20, 20, 50, 80, 80, 120, 30, 60, 65, -5 };

    private Box[] boxs = new Box[14];
    private Square[] squares;
    private MainGame mg;

    public Table(Square[] squares) {
        this.squares = squares;
        createBanco();
    }

    public void createBanco() {
        int boxY = Y; // Initialize boxY with the initial Y coordinate
        for (int i = 1; i < 6; i++) {
            boxs[i] = new Box(X + i * WIDTH - 50, boxY + 1 * HEIGHT, WIDTH, HEIGHT, squares[i].getViTri(),
                    squares[i].getGiatri(), squares[i].isQuan(), false);
        }
        // Adjust the Y-coordinate for the subsequent boxes as needed
        boxY += HEIGHT; // Move to the next row
        for (int i = 7; i <= 11; i++) {
            boxs[i] = new Box(X + (12 - i) * WIDTH - 50, boxY + 1 * HEIGHT, WIDTH, HEIGHT, squares[i].getViTri(),
                    squares[i].getGiatri(), squares[i].isQuan(),false);
        }
        // Move to the next row
        boxY += HEIGHT_QUAN; // Adjust according to the height of the quan box
        boxs[0] = new Box(X + 0 * WIDTH - 50, boxY - 2 * HEIGHT, WIDTH, HEIGHT_QUAN, squares[0].getViTri(),
                squares[0].getGiatri(), squares[0].isQuan(),false);
        boxs[6] = new Box(X + 6 * WIDTH - 50, boxY - 2 * HEIGHT, WIDTH, HEIGHT_QUAN, squares[6].getViTri(),
                squares[6].getGiatri(), squares[6].isQuan(),false);
        // Move to the next row
        boxY += HEIGHT; // Adjust according to the height of the box
        boxs[12] = new Box(X + 3 * WIDTH - 50, (int) (boxY  - 0.3 * HEIGHT), WIDTH, HEIGHT, squares[12].getViTri(),
                squares[12].getGiatri(), squares[12].isQuan(),false);
        boxs[13] = new Box(X + 3 * WIDTH - 50, (int) (boxY - 4.5 * HEIGHT), WIDTH, HEIGHT, squares[13].getViTri(),
                squares[13].getGiatri(), squares[13].isQuan(),false);
    }
    
    public void move(int vitri) {
        int newX = boxs[vitri].getX(); 
        int newY = boxs[vitri].getY(); 
        int speed = 5 ;
        int time = (vitri >= 0) ? 5  : 10 ;
        for (int i = 0; i <= time; i++) {
            try {
                setLocation(X + (int)((newX - X) * i / time), Y + (int)((newY - Y) * i / time));
                Thread.sleep(1);
                mg.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        X = newX;
        Y = newY;
    }
    
    public void draw(Graphics2D g2d) {
        for (int i = 0; i < boxs.length; i++) {
            boxs[i].draw(g2d);
        }
    }

    public void setSquares(Square[] squares) {
        this.squares = squares;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < boxs.length; i++) {
            boxs[i].mouseEntered(e);
        }
    }

    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < boxs.length; i++) {
            boxs[i].mouseExited(e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        mouseEntered(e);
        mouseExited(e);
        
    }

    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < boxs.length; i++) {
            boxs[i].mouseReleased(e);
        }
    }

    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < boxs.length; i++) {
            boxs[i].mousePressed(e);
        }
        repaint();
    }
    
    public void quickMove(int vitri) {
		int 
			newX=boxs[vitri].getX(),
			newY=boxs[vitri].getY();
		setLocation(newX,newY);
		X=newX;
		Y=newY;
	}

}
