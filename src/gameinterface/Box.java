package gameinterface;

import javax.swing.*;
import useinterface.GamePanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Box {
	private int x, y, width, height;
	private int vitri;
	public int giatri;
	public boolean isquan;
	private Image imagesquare, imageleft, imageright, buttonImage, imagebox, imagebox1, imagebox2, flag;
	private boolean isArrowVisible;
	private Image leftArrow, rightArrow;
	public boolean[] isQuan;
	private Box[] boxs = new Box[14];
	private Table table;

	public Box(int x, int y, int width, int height, int vitri, int giatri, boolean isquan, boolean isArrowVisible) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vitri = vitri;
		this.giatri = giatri;
		this.isquan = isquan;
		getImage();
		imagesquare = imagebox;
		this.isArrowVisible = isArrowVisible;
	}

	public void getImage() {
		try {
			imagebox = new ImageIcon("src/images/square.png").getImage();
			imageleft = new ImageIcon("src/images/left.jpg").getImage();
			imageright = new ImageIcon("src/images/right.jpg").getImage();
			imagebox2 = new ImageIcon("src/images/score.png").getImage();
			imagebox1 = new ImageIcon("src/images/score.png").getImage();
			flag = new ImageIcon("src/images/flag.jpg").getImage();
			buttonImage = new ImageIcon("src/images/square.jpg").getImage();
			leftArrow = new ImageIcon("src/images/aleft.jpg").getImage();
			rightArrow = new ImageIcon("src/images/aright.jpg").getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.setFont(new Font("NewellsHand", Font.BOLD, 20));
		g2d.setColor(Color.BLACK);

		if (!isquan && vitri != 12 && vitri != 13) {
			g2d.drawImage(imagesquare, x, y, width, height, null);
			g2d.drawString(giatri + "", x + 40, y + 20);
		} else if (isquan) {
			if (vitri == 0) {
				g2d.drawImage(imageleft, x, y, width, height, null);
				g2d.drawString(giatri + "", x + 35, y + 50);
			} else {
				g2d.drawImage(imageright, x, y, width, height, null);
				g2d.drawString(giatri + "", x + 35, y + 50);
			}
		} else if (vitri == 12) {
			g2d.drawImage(imagebox1, x, y, width, height, null);
			g2d.drawString(giatri + "", x + 110, y + 70);
		} else {
			g2d.drawImage(imagebox2, x, y, width, height, null);
			g2d.drawString(giatri + "", x + 110, y + 70);
		}
		if (isquan) {
			for (int i = 0; i < giatri; i++) {
				g2d.fillOval(x + Table.coordinatesX[i], y + Table.coordinatesY[i] + 40, 13, 10);
			}
		} else {
			for (int i = 0; i < giatri; i++) {
				g2d.fillOval(x + Table.coordinatesX[i], y + Table.coordinatesY[i], 13, 10);
			}
		}
		if (isArrowVisible) {
			g2d.drawImage(leftArrow, x + 2, y + 35, 35, 30, null);
			g2d.drawImage(rightArrow, x + 60, y + 35, 35, 30, null);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (!isquan && vitri != 12 && vitri != 13 && vitri > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
				imagesquare = buttonImage;
				isArrowVisible = true;
			}
		}

	}

	public void mousePressed(MouseEvent e) {
		if (!isquan && vitri != 12 && vitri != 13 && vitri > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
				imagesquare = buttonImage;
			}
		}
	}

	public void mouseExited(MouseEvent e) {
		if (!isquan && vitri != 12 && vitri != 13 && giatri > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px <= x || px >= x + width) || (py <= y || py >= y + height)) {
				imagesquare = imagebox;
				isArrowVisible = false;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (!isquan && vitri != 12 && vitri != 13 && giatri > 0) {
			Point p = e.getPoint();
			int px = (int) p.getX();
			int py = (int) p.getY();
			if ((px >= x && px <= x + width) && (py >= y && py <= y + height)) {
				imagesquare = buttonImage;
			} else {
				imagesquare = imagebox;
			}
		}

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		if (!isquan && vitri != 12 && vitri != 13 && giatri > 0) {
			mouseEntered(e);
			mouseExited(e);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getGiatri() {
		return giatri;
	}

}
