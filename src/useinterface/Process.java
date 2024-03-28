package useinterface;

import javax.swing.*;
import java.awt.*;

public class Process {
    private Square[] squares;

	public Process() {
		squares = new Square[14];
		for (int i = 0; i < 12; i++) {
			if (i % 6 != 0) {
				squares[i] = new Square(i, 5, false);
			} else if (i == 0) {
				squares[i] = new Square(i, 10, true);
			} else {
				squares[i] = new Square(i, 10, true);
			}
		}
		squares[12] = new Square(12, 0, false);
		squares[13] = new Square(13, 0, false);
	}
	
    public Square[] getSquares() {
		return squares;
	}
    
	public void setSquares(Square[] squares) {
		this.squares = squares;
	}
}
