package useinterface;

import javax.swing.*;
import java.awt.*;

public class Box {
    private int x, y, width, height;
    private int vitri, giatri;
    private boolean isquan;
    private Image imagesquare;
    private Image imageleft, imageright;
    private Image imagebox1, imagebox2, flag;

    public Box(int x, int y, int width, int height, int vitri, int giatri, boolean isquan) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.vitri = vitri;
        this.giatri = giatri;
        this.isquan = isquan;
        getImage();
    }

    public void getImage() {
        try {
            imagesquare = new ImageIcon("src/images/square.png").getImage(); // Load square image
            imageleft = new ImageIcon("src/images/left.jpg").getImage(); // Load left image
            imageright = new ImageIcon("src/images/right.jpg").getImage(); // Load right image
            imagebox2 = new ImageIcon("src/images/box1.jpg").getImage(); // Load box2 image
            imagebox1 = new ImageIcon("src/images/box2.jpg").getImage(); // Load box1 image
            flag = new ImageIcon("src/images/flag.jpg").getImage(); // Load flag image
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        if (!isquan && vitri != 12 && vitri != 13) {
            g2d.drawImage(imagesquare, x, y, width, height, null);
            g2d.drawString(giatri + "", x, y);
        } else if (isquan) {
            if (vitri == 0) {
                g2d.drawImage(imageleft, x, y, width, height, null);
            } else {
                g2d.drawImage(imageright, x, y, width, height, null);
            }
        } else if (vitri == 12){
                g2d.drawImage(imagebox1, x, y, width, height, null);
            }  else {
                g2d.drawImage(imagebox2, x, y, width, height, null);
        }
        g2d.setColor(Color.decode("#48423f"));
		if (isquan) {
			for (int i = 0; i < giatri; i++) {
				g2d.fillOval(x+ Table.coordinatesX[i], y + Table.coordinatesY[i] + 40 , 13, 10);
			}
		} else {
			for (int i = 0; i < giatri; i++) {
				g2d.fillOval(x + Table.coordinatesX[i], y + Table.coordinatesY[i], 13, 10);
			}
		}
    }
}
