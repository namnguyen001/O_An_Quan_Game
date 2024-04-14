package gameinterface;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import useinterface.MainGame;

public class Square {

    private int vitri;
	public int giatri;
    public boolean isquan;
    public boolean[] isQuan;
    
    public Square(int vitri, int giatri, boolean isquan) {
		this.vitri = vitri;
		this.giatri = giatri;
		this.isquan = isquan;
		this.isQuan = new boolean[giatri]; 
        for (int i = 0; i < giatri; i++) {
            this.isQuan[i] = true; 
        }
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
	public void change(int n) {
		 this.giatri = n;
	}
	
	
	
}
