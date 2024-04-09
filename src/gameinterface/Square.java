package gameinterface;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import useinterface.MainGame;

public class Square {

    private int vitri;
	public int giatri;
    public boolean isquan;
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
	
	public void change(int n) {
	    // Kiểm tra giá trị mới không âm
	    if (n >= 0) {
	        giatri = n;
	    } else {
	        // Nếu giá trị mới âm, gán giá trị là 0
	        giatri = 0;
	    }
	}

	public void resetStone() {
		for(int i=0;i<70;i++) isQuan[i]=false;
	}
	
}
