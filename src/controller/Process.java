package controller;

import javax.swing.*;
import java.awt.*;
import gameinterface.*;
import gameinterface.Box;
import useinterface.*;

public class Process {
    private Square[] squares;
    private Score[] scBox = new Score[2];
    private MainGame mainGame;
    private Table[] table;
    Box[] boxs = new Box[14];

    public Process() {	
        squares = new Square[14];
        boxs = new Box[14]; 
        for (int i = 0; i < 12; i++) {
            if (i % 6 != 0) {
                squares[i] = new Square(i, 5, false);
                boxs[i] = new Box(0,0,0,0, i, 5, false, false);
            } else if (i == 0) {
                squares[i] = new Square(i, 10, true);
                boxs[i] = new Box(0, 0, 0, 0, i, 10, true, false);
            } else {
                squares[i] = new Square(i, 10, true);
                boxs[i] = new Box(0, 0, 0, 0, i, 10, true, false);
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
    
    public void move(int team, int pos) {
        int step = squares[pos].getGiatri();
        squares[pos].change(0);
        for (int i = 1; i <= step; i++) {
            int newPos = calNewPos(pos, i);
            if (i == step) {
                // Check for capturing conditions
                if (squares[newPos].getGiatri() == 0 && squares[11 - newPos].getGiatri() > 0) {
                    xoaO(11 - newPos);
                    kill(team, newPos);
                } else if (squares[newPos].isQuan()) {
                    xoaQuan(team, newPos);
                }
            }
            squares[newPos].change(squares[newPos].getGiatri() + 1);
        }
    }

    
    void xoaO(int vitri) {
        // Xóa tất cả các đá trong ô có chỉ số vị trí (vitri)
        squares[vitri].change(0);
    }

    void xoaQuan(int team, int vitri) {
        // Xóa quân trong ô có chỉ số vị trí (vitri) và cộng vào ô score tương ứng
        if (team == 0) {
            // Nếu là đội 0, thì cộng vào ô score của đội 0
            squares[5].change(squares[5].getGiatri() + squares[vitri].getGiatri());
        } else {
            // Ngược lại, cộng vào ô score của đội 1
            squares[11].change(squares[11].getGiatri() + squares[vitri].getGiatri());
        }
        // Xóa quân trong ô
        squares[vitri].change(0);
    }

    
    public int check(int team) {
        // Check if there is a win situation or out of stones in current team.
        if (squares[5].getGiatri() == 0 && squares[11].getGiatri() == 0) {
            return -1;
        }
        if (scBox[team].getGiatri() < 5 && total(team) == 0) {
            return 0;
        }
        if (scBox[team].getGiatri() > 5 && total(team) == 0) {
            return 1;
        }
        return 2;
    }
    
    int total(int team) {
        // Get the total of stones on normal box.
        if (team == 0) {
            return squares[6].getGiatri() + squares[7].getGiatri() + squares[8].getGiatri() + squares[9].getGiatri() + squares[10].getGiatri();
        } else {
            return squares[0].getGiatri() + squares[1].getGiatri() + squares[2].getGiatri() + squares[3].getGiatri() + squares[4].getGiatri();
        }
    }
    
    int calNewPos(int src, int step) {
        return (src + 1200 + step) % 12;
    }
    
    void kill(int team, int vitri) {
        int boxTemp = squares[vitri].getGiatri();
        for (int i = 0; i < boxTemp; i++) {
            int j = 0;
            while (!squares[vitri].isQuan[j]) {
                j++;
            }
            squares[vitri].isQuan[j] = false;
            scBox[team].isquan[j] = true;
            squares[vitri].change(squares[vitri].getGiatri() - 1);
            // Giảm số lượng đá trong ô của bảng
            table[0].move(team - 2);
            // Tăng số lượng đá trong ô điểm của đội
            scBox[team].change(scBox[team].getGiatri() + 1);
        }
    }

    
    public void nextTurn() {
		int result=check(mainGame.getCurTeam());
		if(result==-1) {
			int winTeam;
			if(scBox[0].getGiatri()>scBox[1].getGiatri()) winTeam=0;
			else if(scBox[0].getGiatri()<scBox[1].getGiatri()) winTeam=1;
			else winTeam=-1;
			//victory(winTeam);
		}
//		if(result==0) victory(1-mainGame.getCurTeam());
//		if(result==1) spread(mainGame.getCurTeam());
//		scBox[mainGame.getCurTeam()].setTurn(true);
//		scBox[1-mainGame.getCurTeam()].setTurn(false);
	}
    public void reDraw() {  
		//reset game.
		//mainGame.currentTeam=0;
		int count=0;
		for(int i=0;i<12;i++) {
			if(i!=0&&i!=6)
				for(int j=1;j<=5;j++) {
					table[count].quickMove(i);
					count++;
				}
			else
				for(int j=7;j<=11;j++) {
					table[count].quickMove(i);
					count++;
				}
			squares[i].resetStone();
		}
		scBox[0].resetStone();
		scBox[1].resetStone();
		for(int i=0;i<12;i++) squares[i].change(mainGame.getNumberInBox());
		squares[5].change(mainGame.getNumberInScoreBox());
		squares[11].change(mainGame.getNumberInScoreBox());
		scBox[0].change(0);
		scBox[1].change(0);
		scBox[0].setTurn(true);
	}
}
