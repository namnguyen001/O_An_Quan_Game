package controller;

import javax.swing.*;
import java.awt.*;
import gameinterface.*;
import gameinterface.Square;
import useinterface.*;

public class Process {
    private Square[] squares;
    private Score[] scBox = new Score[2];
    private MainGame mainGame;
    private Table[] table;

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
    
    public void move(int vitri, int direction, boolean isEaten){
        if (vitri == 0 || vitri == 6) {
            mainGame.nextTurn();
        } else if (squares[vitri].getGiatri() > 0) {
            if (!isEaten) {
                int num = squares[vitri].getGiatri();
                for (int i = 1; i <= num; i++) {
                    int temp = calNewPos(vitri, i * direction);
                    squares[vitri].change(squares[vitri].getGiatri() - 1);
                    squares[temp].change(squares[temp].getGiatri() + 1);
                    int j = 0;
                    while (squares[temp].isQuan[j] == false)
                        j++;
                    squares[vitri].isQuan[j] = false;
                    squares[temp].isQuan[j]= true;
                    table[0].move(temp);
                }
                int vtSau = calNewPos(vitri, (num + 1) * direction);
                move(vtSau, direction, false);
            } else {
                mainGame.nextTurn();
            }
        } else {
            if (squares[calNewPos(vitri, direction)].getGiatri() > 0) {
                kill(mainGame.getCurTeam(), calNewPos(vitri, direction));
                move(calNewPos(vitri, direction * 2), direction, true);
            } else {
                mainGame.nextTurn();
            }
        }
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
        int temp = scBox[team].getGiatri();
        int boxTemp = squares[vitri].getGiatri();
        for (int i = 0; i < boxTemp; i++) {
            int j = 0;
            while (squares[vitri].isQuan() == false)
                j++;
            squares[vitri].setQuan(false);
            scBox[team].isquan[j] = true;
            squares[vitri].change(squares[vitri].getGiatri() - 1);
            table[0].move(team - 2);
            scBox[team].change(1 + scBox[team].getGiatri());
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
