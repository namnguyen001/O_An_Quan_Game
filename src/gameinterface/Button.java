//package gameinterface;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//import controller.Process;
//import useinterface.MainGame;
//
//public class Button {
//	private int x, y, width = 20, height = 20;
//	private int vitri, giatri;
//	private boolean isquan;
//	private Image imagesquare;
//	private Image imageleft, imageright;
//	private Image imagebox1, imagebox2, flag;
//	private JButton boxBtn, lArrow, rArrow;
//	private static Font fontArrow;
//	private JLabel numLabel = new JLabel("5");
//	private MainGame mainGame;
//	private Process process;
//	
//	
//	public Button(int x, int y, int width, int height, int vitri, int giatri, boolean isquan, Image imagesquare,
//			Image imageleft, Image imageright, Image imagebox1, Image imagebox2, Image flag, JButton boxBtn,
//			JButton lArrow, JButton rArrow, JLabel numLabel, MainGame mainGame) {
//		super();
//		this.x = x;
//		this.y = y;
//		this.width = width;
//		this.height = height;
//		this.vitri = vitri;
//		this.giatri = giatri;
//		this.isquan = isquan;
//		this.imagesquare = imagesquare;
//		this.imageleft = imageleft;
//		this.imageright = imageright;
//		this.imagebox1 = imagebox1;
//		this.imagebox2 = imagebox2;
//		this.flag = flag;
//		this.boxBtn = boxBtn;
//		this.lArrow = lArrow;
//		this.rArrow = rArrow;
//		this.numLabel = numLabel;
//		this.mainGame = mainGame;
//	}
//	
//	void create() {
//		boxBtn = new JButton();
//		boxBtn.setFocusable(false);
//		setOutlook(boxBtn);
//		boxBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				process.removeAllArrow();
//				int team = MainGame.getCurTeam();
//				if (team == 0 && vitri > 5 && vitri < 11 && giatri > 0)
//					showArrow();
//				if (team == 1 && vitri < 6 && giatri > 0)
//					showArrow();
//			}
//		});
//		numLabel.setFont(fontArrow);
//		mainGame.add(numLabel);
//		mainGame.add(boxBtn);
//	}
//
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
//				process.move(vitri, chieu, false);
//			}
//		};
//		ActionListener l = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int chieu = (row == 0) ? 1 : -1;
//				Square.removeArrow();
//				process.move(vitri, chieu, false);
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
//
//	void showArrow() {
//		rArrow.setVisible(true);
//		lArrow.setVisible(true);
//		mainGame.repaint();
//	}
//
//	void setOutlook(JButton b) {
//		b.setFocusPainted(false);
//		b.setFont(fontArrow);
//
//		b.setMargin(new Insets(0, 0, 0, 0));
//		b.setHorizontalAlignment(SwingConstants.LEFT);
//		b.setVerticalAlignment(SwingConstants.TOP);
//
//		// bug màu nút.
//		b.setContentAreaFilled(false);
//		b.setBorderPainted(false);
//	}
//	
//}
