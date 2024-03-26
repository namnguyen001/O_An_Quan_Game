package useinterface;

import javax.swing.*;
import java.awt.*;
public class Box {
    private int x, y, width, height;
	private int vitri, giatri;
	private boolean isquan;
    private Image imagesquare;
    public Box(int x, int y, int width, int height, int vitri,int giatri, boolean isquan){
        this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vitri = vitri;
		this.giatri = giatri;
		this.isquan = isquan;
        imagesquare = loadImage("square.jpg");
    }
    private Image loadImage(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadImage'");
    }
    public void draw(Graphics2D g2d){
        if (!isquan && vitri != 12 && vitri != 13) {
			g2d.drawImage(imagesquare, x, y, width, height, null);
			g2d.drawString(giatri + "", x + 40, y + 25);
    }
    }
}