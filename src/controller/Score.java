package controller;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gameinterface.Square;
import useinterface.MainGame;

public class Score {
	private Square[] squares;
	public int giatri;
	public boolean[] isQuan;

	Score(Square[] squares) {
		this.squares = squares;
	}

	public Square[] getSquares() {
		return squares;
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}

	public int getGiatri() {
		return giatri;
	}

	public void change(int n) {
		this.giatri = n;
	}

	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}

}