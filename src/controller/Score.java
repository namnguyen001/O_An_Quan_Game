package controller;

import gameinterface.Square;

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

	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}

}