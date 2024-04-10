package controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import gameinterface.*;
import gameinterface.Box;
import useinterface.*;

public class Process {
    private Square[] squares;
    private ArrayList<Score> scores;
    Box[] boxs = new Box[14];

    public Process() {	
        squares = new Square[14];
        boxs = new Box[14]; 
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
    
	public ArrayList<Score> getScores(){
		return scores;
	}

	public void setScores( ArrayList<Score> scores){
		this.scores = scores;
	}

	public Square[] copysSquares(Square[] squares) {
		Square[] s = new Square[squares.length];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Square(i, squares[i].getGiatri(), squares[i].isQuan());
		}
		return s;
	}
	
	public int right(int viTri) {
		int giaTri = squares[viTri].getGiatri();
		squares[viTri].setGiatri(0);
		while (giaTri != 0) {
			viTri++;
			if (viTri == 12) {
				viTri = 0;
			}
			squares[viTri].setGiatri(squares[viTri].getGiatri() + 1);
			giaTri--;
			System.out.println("Vitri: " + viTri);
			Score score = new Score(copysSquares(squares));
			scores.add(score);
		}
		viTri++;
		if (viTri == 12) {
			viTri = 0;
		}
		if (squares[viTri].getGiatri() != 0 && viTri % 6 != 0) {
			return right(viTri);
		} else {
			return viTri--;
		}
	}


	// trả về vị trí sau khi đi qua phải
	public int left(int viTri) {
		int giaTri = squares[viTri].getGiatri();
		squares[viTri].setGiatri(0);
		while (giaTri != 0) {
			viTri--;
			if (viTri == -1) {
				viTri = 11;
			}
			squares[viTri].setGiatri(squares[viTri].getGiatri() + 1);
			giaTri--;
			System.out.println("Vi tri: " + viTri);
			Score score = new Score(copysSquares(squares));
			scores.add(score);
		}
		viTri--;
		if (viTri == -1) {
			viTri = 11;
		}
		if (squares[viTri].getGiatri() != 0 && viTri % 6 != 0) {
			return right(viTri);
		} else {
			return viTri--;
		}
	}

    public int left2(int viTri) {
		int giaTri = squares[viTri].getGiatri();
		squares[viTri].setGiatri(0);
		while (giaTri != 0) {
			viTri++;
			if (viTri == 12) {
				viTri = 0;
			}
			squares[viTri].setGiatri(squares[viTri].getGiatri() + 1);
			giaTri--;
			System.out.println("Vitri: " + viTri);
			Score score = new Score(copysSquares(squares));
			scores.add(score);
		}
		viTri++;
		if (viTri == 12) {
			viTri = 0;
		}
		if (squares[viTri].getGiatri() != 0 && viTri % 6 != 0) {
			return left2(viTri);
		} else {
			return viTri--;
		}
	}


	// trả về vị trí sau khi đi qua phải
	public int right2(int viTri) {
		int giaTri = squares[viTri].getGiatri();
		squares[viTri].setGiatri(0);
		while (giaTri != 0) {
			viTri--;
			if (viTri == -1) {
				viTri = 11;
			}
			squares[viTri].setGiatri(squares[viTri].getGiatri() + 1);
			giaTri--;
			System.out.println("Vi tri: " + viTri);
			System.out.println("sang phai");
			Score score = new Score(copysSquares(squares));
			scores.add(score);
		}
		viTri--;
		if (viTri == -1) {
			viTri = 11;
		}
		if (squares[viTri].getGiatri() != 0 && viTri % 6 != 0) {
			return right2(viTri);
		} else {
			return viTri--;
		}
	}
    
    public boolean finish() {
		if (squares[0].getGiatri() == 0 && squares[6].getGiatri() == 0){
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

    public boolean kiemTra(int viTri, int player) {
		if (player == 1) {
			if (viTri != 7 && viTri != 8 && viTri != 9 && viTri != 10 && viTri != 11) {
				return false;
			}
			if (squares[viTri].getGiatri() == 0 || viTri % 6 == 0) {
				return false;
			}
		} else if(player == 2) {
			if (viTri != 1 && viTri != 2 && viTri != 3 && viTri != 4 && viTri != 5) {
				return false;
			}
			if (squares[viTri].getGiatri() == 0 || viTri % 6 == 0) {
				return false;
			}
		}
		return true;
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
}
