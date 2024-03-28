package controller;

import javax.swing.*;
import java.awt.*;
import gameinterface.*;
import gameinterface.Square;
import useinterface.*;

public class Process {
    private static Square[] squares;
	private MainGame mainGame;

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
	
	public static void removeAllArrow() {
		for(int i=0;i<12;i++) squares[i].removeArrow();
	}
	int calNewPos(int src,int step){
		return (src+1200+step)%12;
	}
	
//	public void move(int pos,int direction, boolean isEaten){
//		//main function to move stones.
//		if(pos==5||pos==11) mainGame.nextTurn();
//		else if (squares[pos].getNum()>0){
//			if(!isEaten){
//				int num=squares[pos].getNum();
//				squares[pos].setColor(Color.BLUE);
//				for(int i=1;i<=num;i++) {
//					int temp=calNewPos(pos,i*direction);
//					squares[pos].change(squares[pos].getGiatri()-1);
//					squares[temp].change(squares[temp].getGiatri()+1);
//					int j=0;
//					while(squares[pos].isStone[j]==false)
//						j++;
//					squares[pos].isStone[j]=false;
//					squares[temp].isStone[j]=true;
//					stone[j].move(temp);
//				}
//				int vtSau=calNewPos(pos,(num+1)*direction);
//				move(vtSau,direction,false);
//			}else mainGame.nextTurn();
//		}else{
//			if(squares[calNewPos(pos,direction)].getGiatri()>0){
//				kill(mainGame.getCurTeam(),calNewPos(pos,direction));
//				move(calNewPos(pos,direction*2),direction,true);
//			}else mainGame.nextTurn();
//		}
//	}
}
