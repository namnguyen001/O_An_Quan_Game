package useinterface;

import javax.swing.*;
import java.awt.*;
public class Table {
    public static int WIDTH = 100, HEIGHT = 100, HEIGHT_QUAN = 200, X = 100, Y = 100;
	// public static final int[] coordinatesX = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
	//     1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	//     ,1,1,1,1,1,1,1,1,1,1};
	// public static final int[] coordinatesY = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
	//     1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
	//     ,1,1,1,1,1,1,1,1,1,1};
	private Box[] boxs =  new Box[14];;
	private Square[] squares;

	public Table(Square[] squares) {
		this.squares = squares;
		createBanco();
	}

	public void createBanco() {
		for (int i = 1; i < 6; i++) {
		boxs[i] = new Box( X +i*WIDTH, Y , WIDTH, HEIGHT, squares[i].getViTri(), squares[i].getGiatri(),
					squares[i].isQuan());
		}
		boxs[7] = new Box(X  , Y , WIDTH, HEIGHT, squares[7].getViTri(), squares[7].getGiatri(),
				squares[7].isQuan());
		boxs[8] = new Box(X , Y , WIDTH, HEIGHT, squares[8].getViTri(), squares[8].getGiatri(),
				squares[8].isQuan());
		boxs[9] = new Box(X  , Y , WIDTH, HEIGHT, squares[9].getViTri(), squares[9].getGiatri(),
				squares[9].isQuan());
		boxs[10] = new Box(X  , Y , WIDTH, HEIGHT, squares[10].getViTri(), squares[10].getGiatri(),
				squares[10].isQuan());
		boxs[11] = new Box(X  , Y , WIDTH, HEIGHT, squares[11].getViTri(), squares[11].getGiatri(),
				squares[11].isQuan());
		boxs[0] = new Box(X, Y , WIDTH, HEIGHT_QUAN, squares[0].getViTri(), squares[0].getGiatri(),
				squares[0].isQuan());
		boxs[6] = new Box(X , Y , WIDTH, HEIGHT_QUAN, squares[6].getViTri(), squares[6].getGiatri(),
				squares[6].isQuan());
		boxs[12] = new Box(X , Y , WIDTH, HEIGHT, squares[12].getViTri(), squares[12].getGiatri(),
				squares[12].isQuan());
		boxs[13] = new Box(X, Y , WIDTH, HEIGHT, squares[13].getViTri(), squares[13].getGiatri(),
				squares[13].isQuan());
	}

	public void draw(Graphics2D g2d) {
		for (int i = 0; i < boxs.length; i++) {
			boxs[i].draw(g2d);
		}
	}
// 	public void paint(Graphics g){
//         Graphics2D g2 = (Graphics2D)g;  
//         	for (int i = 0; i < boxs.length; i++) {
// 			boxs[i].draw(g2);
// 		}
//         g2.dispose();
//    }

    public void setSquares(Square[] squares) {
	this.squares = squares;
}

}
