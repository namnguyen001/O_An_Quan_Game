package gameinterface;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import useinterface.MainGame;

public class Square {

    private int vitri;
	private int giatri;
    private boolean isquan;
    public boolean[] isQuan = new boolean[70];
    private JButton boxBtn;
	private boolean isArrowVisible;
	private static MainGame mainGame;
	private Box[] boxs = new Box[14];
    
    
    public Square(int vitri, int giatri, boolean isquan) {
		this.vitri = vitri;
		this.giatri = giatri;
		this.isquan = isquan;
	}
	public int getGiatri() {
		return giatri;
	}

	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}

	public boolean isQuan() {
		return isquan;
	}

	public void setQuan(boolean isquan) {
		this.isquan = isquan;
	}

	public int getViTri() {
		return vitri;
	}

	public void setViTri(int vitri) {
		this.vitri = vitri;
	}
	public boolean isArrowVisible() {
		return isArrowVisible = true;
		
	}
	
	public void change(int n){
		giatri=n;
	}
	public void resetStone() {
		for(int i=0;i<70;i++) isQuan[i]=false;
	}
	
}
