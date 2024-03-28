package useinterface;

import javax.swing.*;
import java.awt.*;
public class Table {
    public static int WIDTH = 100, HEIGHT = 100, HEIGHT_QUAN = 200, X = 100, Y = 90;

	public static final int[] coordinatesX = { 25, 50, 35, 45, 60, 30, 60, 50, 75, 25,35,30,25, 50, 35, 45,25, 50, 35, 45 };
	public static final int[] coordinatesY = { 65, 35, 40, 60, 60, 29, 25, 80, 40, 50,16,24,65, 35, 40, 60,65, 35, 40, 60,};
	private Box[] boxs =  new Box[14];;
	private Square[] squares;

	public Table(Square[] squares) {
		this.squares = squares;
		createBanco();
	}

	public void createBanco() {
	    int boxY = Y; // Initialize boxY with the initial Y coordinate
	    for (int i = 1; i < 6; i++) {
	        boxs[i] = new Box(X + i * WIDTH,Y*2, WIDTH, HEIGHT, squares[i].getViTri(), squares[i].getGiatri(),
	                    squares[i].isQuan());
	    }
	    // Adjust the Y-coordinate for the subsequent boxes as needed
	    boxY += HEIGHT; // Move to the next row	
	    for (int i = 7; i <= 11; i++) {
	        boxs[i] = new Box(X + (12 - i) * WIDTH,Y*3, WIDTH, HEIGHT, squares[i].getViTri(), squares[i].getGiatri(),
	                squares[i].isQuan());
	    }
	    // Move to the next row
	    boxY += HEIGHT_QUAN; // Adjust according to the height of the quan box
	    boxs[0] = new Box(X + 0*WIDTH, Y*2, WIDTH, HEIGHT_QUAN, squares[0].getViTri(), squares[0].getGiatri(),
	            squares[0].isQuan());
	    boxs[6] = new Box(X + WIDTH * 6, Y*2, WIDTH, HEIGHT_QUAN, squares[6].getViTri(), squares[6].getGiatri(),
	            squares[6].isQuan());
	    // Move to the next row
	    boxY += HEIGHT; // Adjust according to the height of the box
	    boxs[12] = new Box(X +3*WIDTH,(int)( 0.25*Y), WIDTH, HEIGHT, squares[12].getViTri(), squares[12].getGiatri(),
	            squares[12].isQuan());
	    boxs[13] = new Box(X + 3*WIDTH, (int)(Y*4.75), WIDTH, HEIGHT, squares[13].getViTri(), squares[13].getGiatri(),
	            squares[13].isQuan());
	}

	public void draw(Graphics2D g2d) {
		for (int i = 0; i < boxs.length; i++) {
			boxs[i].draw(g2d);
		}
	}

    public void setSquares(Square[] squares) {
	this.squares = squares;
}

}
