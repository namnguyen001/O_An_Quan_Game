package gameinterface;

import javax.swing.*;

import useinterface.MainGame;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Table extends JFrame {

	public static int WIDTH = 100, HEIGHT = 100, HEIGHT_QUAN = 200, X = 50, Y = 50;

	public static final int[] coordinatesX = { 25, 50, 35, 35, 60, 30, 60, 50, 75, 25, 60, 30, 55, 65, 27, 37, 52, 33,
			73, 51, 43, 68, 44, 24, 67, 25, 70, 64, 29, 46, 35, 25, 64, 53, 71, 47, 26, 68, 35, 57, 23, 45, 67, 31, 56,
			68, 71, 43, 68, 44, 24, 67, 25, 70, 64, 29, 46, 35, 25, 64, 53, 71, 47, 26, 68, 35, 57, 23, 45, 67 };

	public static final int[] coordinatesY = { 65, 35, 45, 60, 50, 29, 47, 76, 46, 56, 34, 40, 35, 33, 45, 76, 25, 34,
			59, 47, 38, 68, 52, 67, 43, 28, 36, 57, 73, 56, 39, 47, 61, 26, 47, 57, 53, 74, 29, 55, 24, 30, 60, 50, 75,
			25, 60, 38, 68, 52, 67, 43, 28, 36, 57, 73, 56, 39, 47, 61, 26, 47, 57, 53, 74, 29, 55, 24, 30, 60, 50 };

//        private int[] coordinatesX = new int[70];
//        private int[] coordinatesY = new int[70];

	public Box[] boxs = new Box[14];
	private Square[] squares;
	private Table table;

	public Table(Square[] squares) {
		this.squares = squares;
		createBanco();
	}

	public void createBanco() {
		int boxY = Y;
		for (int i = 1; i < 6; i++) {
			boxs[i] = new Box(X + i * WIDTH - 50, boxY + 1 * HEIGHT, WIDTH, HEIGHT, squares[i].getViTri(),
					squares[i].getGiatri(), squares[i].isQuan(), false);
		}

		boxY += HEIGHT;
		for (int i = 7; i <= 11; i++) {
			boxs[i] = new Box(X + (12 - i) * WIDTH - 50, boxY + 1 * HEIGHT, WIDTH, HEIGHT, squares[i].getViTri(),
					squares[i].getGiatri(), squares[i].isQuan(), false);
		}

		boxY += HEIGHT_QUAN;
		boxs[0] = new Box(X + 0 * WIDTH - 50, boxY - 2 * HEIGHT, WIDTH, HEIGHT_QUAN, squares[0].getViTri(),
				squares[0].getGiatri(), squares[0].isQuan(), false);
		boxs[6] = new Box(X + 6 * WIDTH - 50, boxY - 2 * HEIGHT, WIDTH, HEIGHT_QUAN, squares[6].getViTri(),
				squares[6].getGiatri(), squares[6].isQuan(), false);

		boxY += HEIGHT;
		boxs[12] = new Box(X + 3 * WIDTH - 50, (int) (boxY - 0.3 * HEIGHT), WIDTH, HEIGHT, squares[12].getViTri(),
				squares[12].getGiatri(), squares[12].isQuan(), false);
		boxs[13] = new Box(X + 3 * WIDTH - 50, (int) (boxY - 4.5 * HEIGHT), WIDTH, HEIGHT, squares[13].getViTri(),
				squares[13].getGiatri(), squares[13].isQuan(), false);
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

}
