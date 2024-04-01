package controller;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import useinterface.MainGame;

public class Score {
	JLabel scBoxLabel, turnLabel;
	ImageIcon flag;
	int num, team;
	boolean[] isquan = new boolean[70];
	MainGame mainGame;
	Font fontArrow = new Font("Times New Romans", Font.PLAIN, 10);
	private int giatri;

	Score(MainGame m, int team) {
		this.team = team;
		mainGame = m;
		scBoxLabel = new JLabel("0");
		scBoxLabel.setFocusable(false);
		scBoxLabel.setFont(fontArrow);
		mainGame.add(scBoxLabel);
		flag = new ImageIcon("src\\images\\flag" + Integer.toString(2 - team) + ".jpg");
		turnLabel = new JLabel(flag);
		turnLabel.setFocusable(false);
		turnLabel.setFont(fontArrow);
		turnLabel.setFocusable(false);
		resetStone();
	}

	void resetStone() {
		for (int i = 0; i < 70; i++)
			isquan[i] = false;
	}
	
	public int getGiatri() {
		return giatri;
	}

	public boolean[] isQuan() {
		return isquan;
	}
	
	public void change(int n){
		giatri=n;
	}

	public void setTurn(boolean b) {
		// TODO Auto-generated method stub
		
	}
}