package useinterface;

import javax.swing.*;
import java.awt.*;

public class Box {
    private int x, y, width=20, height=20;
    private int vitri, giatri;
    private boolean isquan;
    private Image imagesquare;
    private Image imageleft, imageright;

    public Box(int x, int y, int width, int height, int vitri, int giatri, boolean isquan) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vitri = vitri;
        this.giatri = giatri;
        this.isquan = isquan;
        getImage();
        // imagesquare = loadImage("square.jpg");// hình ô dân
        // imageleft = loadImage("src//images//square.jpg"); // hình ô quan trái
        // imageright = loadImage("src//images//square.jpg"); // hình ô quan phải
    }
    // public Image loadImage(String fileName) {
	// 	return new ImageIcon(getClass().getResource("src//images//" + fileName)).getImage();
	// }
    public void getImage() {
        try {
            imagesquare = new ImageIcon("src/images/square.jpg").getImage(); // Load square image
            // imageleft = new ImageIcon("src/images/left.jpg").getImage(); // Load left image
            // imageright = new ImageIcon("src/images/right.jpg").getImage(); // Load right image
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        if (!isquan && vitri != 12 && vitri != 13) {
            g2d.drawImage(imagesquare, x, y, width, height, null);
            // g2d.drawString(giatri + "", x, y);
            // } else if (isquan = true) {
            // g2d.drawImage(imageleft, x, y, width, height, null);
            // g2d.drawString(giatri + "", x, y);
            // } else if (isquan = true) {
            // g2d.drawImage(imageright, x, y, width, height, null);
            // g2d.drawString(giatri + "", x, y);
            // }
        }
    }
}