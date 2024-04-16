package controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import gameinterface.*;
import gameinterface.Box;
import useinterface.*;

public class Process {
	private MainGame mainGame;
	private Square[] squares;
	private ArrayList<Score> scores;
	Box[] boxs = new Box[14];
	private Score[] scBox;
	private Table table;

	public Process() {
		scores = new ArrayList<>();
		squares = new Square[14];
		boxs = new Box[14];
		scBox = new Score[2];
		scBox[0] = new Score(squares);
		scBox[1] = new Score(squares);
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

	public ArrayList<Score> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Score> scores) {
		this.scores = scores;
	}

	public Square[] copysSquares(Square[] squares) {
		Square[] s = new Square[squares.length];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Square(i, squares[i].getGiatri(), squares[i].isQuan());
		}
		return s;
	}

	public int move(int viTri, int direction) {
	    int giaTri = squares[viTri].getGiatri();

	    if (giaTri == 0) {
	        return 0;
	    }

	    squares[viTri].setGiatri(0);

	    while (giaTri != 0) {
	        viTri += direction;
	        if (viTri == 12) {
	            viTri = 0;
	        } else if (viTri == -1) {
	            viTri = 11;
	        }
	        squares[viTri].setGiatri(squares[viTri].getGiatri() + 1);
	        giaTri--;
	        System.out.println("Vitri: " + viTri);
	        Score score = new Score(copysSquares(squares));
	        scores.add(score);
	    }
	    viTri += direction;
	    if (viTri == 12) {
	        viTri = 0;
	    } else if (viTri == -1) {
	        viTri = 11;
	    }
	    if (squares[viTri].getGiatri() != 0 && viTri % 6 != 0) {
	        return move(viTri, direction);
	    } else {
	        return viTri--;
	    }
	}


	public int kill(int viTri, int direction) {
		if (squares[viTri].getGiatri() == 0 && viTri % 6 != 0) {
			viTri += direction;
			if (viTri == 12) {
				viTri = 0;
			} else if (viTri == -1) {
				viTri = 11;
			}
			if (squares[viTri].getGiatri() != 0) {
				int diem = squares[viTri].getGiatri();
				squares[viTri].setGiatri(0);
				Score score = new Score(copysSquares(squares));
				scores.add(score);
				viTri += direction;
				if (viTri == 12) {
					viTri = 0;
				} else if (viTri == -1) {
					viTri = 11;
				}
				if (squares[viTri].getGiatri() == 0 && viTri % 6 != 0) {
					return diem + kill(viTri, direction);
				} else {
					return diem;
				}
			}
			return 0;
		}
		return 0;
	}

	public boolean finish() {
		if (squares[0].getGiatri() == 0 && squares[6].getGiatri() == 0) {
			return true;
		}
		if (squares[12].getGiatri() == 0) {
			if (kiemTraHetQuan(1)) {
				return true;

			}
		}
		if (squares[13].getGiatri() == 0) {
			if (kiemTraHetQuan(2)) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraHetQuan(int player) {
		if (player == 1) {
			int score = 0;
			for (int i = 1; i < 6; i++) {
				score += squares[i].getGiatri();
			}
			if (score == 0) {
				return true;
			}
		} else {
			int score = 0;
			for (int i = 7; i < 12; i++) {
				score += squares[i].getGiatri();
			}
			if (score == 0) {
				return true;
			}
		}
		return false;
	}

	public void setScorePlayer(int diem, int player) {
		if (player == 2) {
			int a = squares[12].getGiatri();
			squares[12].setGiatri(diem + a);
			Score score = new Score(squares);
			scores.add(score);
		}
		if (player == 1) {
			int a = squares[13].getGiatri();
			squares[13].setGiatri(diem + a);
			Score score = new Score(squares);
			scores.add(score);
		}
	}

	public int rai(int player) {
		if (player == 1) {
			int diem = squares[13].getGiatri();
			if (diem <= 5) {
				for (int i = 1; i <= diem; i++) {
					squares[i].setGiatri(1);
				}
				squares[12].setGiatri(0);
				Score score = new Score(copysSquares(squares));
				scores.add(score);
				return diem;
			} else {
				for (int i = 1; i < 6; i++) {
					squares[i].setGiatri(1);
				}
				squares[12].setGiatri(diem - 5);
				Score score = new Score(copysSquares(squares));
				scores.add(score);
				return 5;
			}
		} else {
			int diem = squares[13].getGiatri();
			if (diem <= 5) {
				for (int i = 7; i < 7 + diem; i++) {
					squares[i].setGiatri(1);
				}
				squares[12].setGiatri(0);
				Score score = new Score(copysSquares(squares));
				scores.add(score);
				return diem;
			} else {
				for (int i = 7; i < 12; i++) {
					squares[i].setGiatri(1);
				}
				squares[13].setGiatri(diem - 5);
				Score score = new Score(copysSquares(squares));
				scores.add(score);
				return 5;
			}
		}
	}
}
