package gameinterface;

import javax.swing.*;
import controller.Process;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import useinterface.*;
import gameinterface.*;

public class Box {
	private int x, y, width = 20, height = 20;
	private int vitri, giatri;
	private boolean isquan;
	private Image imagesquare;
	private Image imageleft, imageright;
	private Image imagebox1, imagebox2, flag;
	private JButton boxBtn, lArrow, rArrow;
	private static Font fontArrow;
	private JLabel numLabel = new JLabel("5");
	private MainGame mainGame;

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
			imagebox2 = new ImageIcon("src/images/box2.jpg").getImage(); // Load box2 image
			imagebox1 = new ImageIcon("src/images/box1.jpg").getImage(); // Load box1 image
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
		} else if (vitri == 12) {
			g2d.drawImage(imagebox1, x, y, width, height, null);
		} else {
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

	void create() {
		boxBtn = new JButton();
		boxBtn.setFocusable(false);
		setOutlook(boxBtn);
		boxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Process.removeAllArrow();
				int team = MainGame.getCurTeam();
				if (team == 0 && vitri > 5 && vitri < 11 && giatri > 0)
					showArrow();
				if (team == 1 && vitri < 6 && giatri > 0)
					showArrow();
			}
		});
		numLabel.setFont(fontArrow);
		mainGame.add(numLabel);
		mainGame.add(boxBtn);
	}

//	void createArrow() {
//		int row;
//		if (vitri < 6)
//			row = 1;
//		else
//			row = 0;
//		rArrow = new JButton("\u25B6");
//		lArrow = new JButton("\u25C0");
//		ActionListener r = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int chieu = (row == 0) ? -1 : 1;
//				Square.removeArrow();
//				Process.move(vitri, chieu, false);
//			}
//		};
//		ActionListener l = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int chieu = (row == 0) ? 1 : -1;
//				Square.removeArrow();
//				Process.move(vitri, chieu, false);
//			}
//		};
//		setOutlook(rArrow);
//		setOutlook(lArrow);
//		rArrow.addActionListener(r);
//		lArrow.addActionListener(l);
//		mainGame.add(rArrow);
//		mainGame.add(lArrow);
//		rArrow.setVisible(false);
//		lArrow.setVisible(false);
//	}

	void showArrow() {
		rArrow.setVisible(true);
		lArrow.setVisible(true);
		mainGame.repaint();
	}

	void setOutlook(JButton b) {
		b.setFocusPainted(false);
		b.setFont(fontArrow);

		b.setMargin(new Insets(0, 0, 0, 0));
		b.setHorizontalAlignment(SwingConstants.LEFT);
		b.setVerticalAlignment(SwingConstants.TOP);

		// bug màu nút.
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
	}
}