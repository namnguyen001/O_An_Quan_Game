package useinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.Process;
import gameinterface.*;

public class MainGame extends JFrame {

	private JLabel jlabel;
	private MenuController menuControl;
	private GamePanel gamePanel;
	public int currentTeam = 0;
	int numberInBox = 5;
	int numberInScoreBox = 10;
	private StartGame start;
	private Process process;
	private MainGame mainGame;
	private Table table;
	private gameinterface.Box[] boxs;

	public MainGame() {
		this.setTitle("Ô Ăn Quan");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(713, 600);
		setLocationRelativeTo(null);
		setResizable(false);

		start = new StartGame(this);
		add(start);

		gamePanel = new GamePanel();
		process = new Process();

		this.setVisible(true);

	}

	public void createnewgame() {
		getContentPane().remove(start);
		getContentPane().repaint();

		gamePanel = new GamePanel();
		getContentPane().add(gamePanel);

		getContentPane().revalidate();
		getContentPane().repaint();

		menuControl = new MenuController(this);
		this.setJMenuBar(menuControl.getMenu());
	}

	public void setTextJlabel(String s) {
		this.jlabel.setText(s);
	}

	void showMore() {
		String s = "The game simulates the Ô Ăn Quan .\nAuthor: NG.\nHave fun.";
		JOptionPane.showMessageDialog(this, s, "Ô Ăn Quan", JOptionPane.PLAIN_MESSAGE);
	}

	void showRule() {
		JLabel content = new JLabel("<html>" + "<h1>How to play</h1>" + "<p>"
				+ "Mouse over one of the five cells belonging to your side.<br>"
				+ "An arrow will appear depending on whether the mouse pointer is to the left or right of the cell, showing the direction.<br>"
				+ "Click on the box to make a move.<br>" + "The game ends when both squares have been taken.<br>"
				+ "</p>" + "<h1>Hướng dẫn chơi game</h1>" + "<p>"
				+ "Đưa chuột lên một trong năm ô thuộc về bên của bạn.<br>"
				+ "Nếu bạn đưa chuột về bên phải ô sẽ hiện lên ▶, nếu đưa chuột về bên trái ô sẽ hiện lên ◀, tương ứng với chiều rải quân.<br>"
				+ "Bạn click chuột để thực hiện nước đi của mình.<br>"
				+ "Trò chơi kết thúc khi hai ô quan đã được ăn hết.<br>" + "</html>");
		content.setBorder(new EmptyBorder(1, 1, 1, 1));
		JOptionPane.showMessageDialog(this, content, "Rule", JOptionPane.PLAIN_MESSAGE);
	}

	public void newGame() {
		int option = JOptionPane.showConfirmDialog(this, "Do you want to play again??", "Retard alert",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {
			this.gamePanel.reDraw();
		}
	}

	public void Exit() {
		int option = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Retard alert",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	void Setting() {
		JFrame setupFrame = new JFrame("Cài đặt");
		final int stWidth = 400, stHeight = 220;
		setupFrame.setSize(stWidth, stHeight);
		setupFrame.setResizable(false);
		setupFrame.setLayout(null);

		Font fontMenu = new Font("SansSerif", Font.BOLD, 15);

		JButton colorButton = new JButton("Chọn màu sỏi");
		colorButton.setBounds(55, 20, 150, 30);
		colorButton.setFont(fontMenu);
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = colorButton.getBackground();
				Color newColor = JColorChooser.showDialog(null, "Chọn màu sỏi", initialBackground);
				if (newColor != null) {
					colorButton.setBackground(newColor);
				}
			}
		});

		JLabel lbSpeed = new JLabel("Tốc độ di chuyển");
		lbSpeed.setBounds(55, 80, 150, 30);
		lbSpeed.setFont(fontMenu);
		setupFrame.add(lbSpeed);

		JSpinner spSpeed = new JSpinner(new SpinnerNumberModel(500, 100, 800, 100));
		spSpeed.setBounds(300, 80, 50, 30);
		setupFrame.add(spSpeed);

		JButton dongY = new JButton("Chấp nhận");
		dongY.setBounds(55, 130, 130, 35);
		dongY.setFont(fontMenu);
		dongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table != null) {
					Color newColor = (Color) colorButton.getBackground();
					table.setCurrentColor(newColor);
					table.repaint();
				}
				int newSpeed = (Integer) spSpeed.getValue();
				gamePanel.setMoveSpeed(newSpeed);
				setupFrame.setVisible(false);
			}
		});

		JButton huyBo = new JButton("Huỷ bỏ");
		huyBo.setBounds(200, 130, 100, 35);
		huyBo.setFont(fontMenu);
		huyBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupFrame.setVisible(false);
			}
		});

		setupFrame.add(colorButton);
		setupFrame.add(dongY);
		setupFrame.add(huyBo);
		setupFrame.setLocationRelativeTo(this);
		setupFrame.setVisible(true);
	}

}
