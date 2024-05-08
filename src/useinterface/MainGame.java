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
import gameinterface.Box;

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
	private Box[] boxs = new Box[14];
	private String playerName1 = "Player 1";
	private String playerName2 = "Player 2";
	private String[] defaultPlayerNames = {"Player 1", "Player 2"};
	
	
    public MainGame() {
        this.setTitle("Ô Ăn Quan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(713, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        start = new StartGame(this);
        add(start);

		gamePanel = new GamePanel(this);
		process = new Process();
        this.setVisible(true);
    }

    public void createnewgame() {
		
        getContentPane().remove(start);
        getContentPane().repaint();

		
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
			
	        this.setDefaultPlayerNames();
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
		JFrame setupFrame = new JFrame("Setting");
		final int stWidth = 400, stHeight = 220;
		setupFrame.setSize(stWidth, stHeight);
		setupFrame.setResizable(false);
		setupFrame.setLayout(null);

		Font fontMenu = new Font("SansSerif", Font.BOLD, 15);
		JLabel lbSpeed = new JLabel("Speed ​​of movement");
		lbSpeed.setBounds(55, 50, 150, 30);
		lbSpeed.setFont(fontMenu);
		setupFrame.add(lbSpeed);

		JSpinner spSpeed = new JSpinner(new SpinnerNumberModel(500, 100, 800, 100));
		spSpeed.setBounds(300, 50, 50, 30);
		setupFrame.add(spSpeed);

		JButton dongY = new JButton("Accept");
		dongY.setBounds(55, 130, 130, 35);
		dongY.setFont(fontMenu);
		dongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newSpeed = (Integer) spSpeed.getValue();
				gamePanel.setMoveSpeed(newSpeed);
				setupFrame.setVisible(false);
			}
		});

		JButton huyBo = new JButton("Cancel");
		huyBo.setBounds(250, 130, 100, 35);
		huyBo.setFont(fontMenu);
		huyBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupFrame.setVisible(false);
			}
		});

		setupFrame.add(dongY);
		setupFrame.add(huyBo);
		setupFrame.setLocationRelativeTo(this);
		setupFrame.setVisible(true);
	}

	void SetName() {
		JFrame setupFrame = new JFrame("Name Player");
		final int stWidth = 400, stHeight = 220;
		setupFrame.setSize(stWidth, stHeight);
		setupFrame.setResizable(false);
		setupFrame.setLayout(null);

		Font fontMenu = new Font("SansSerif", Font.BOLD, 15);
		JLabel Player1 = new JLabel("Player 1:");
		Player1.setBounds(50, 20, 150, 30);
		Player1.setFont(fontMenu);
		setupFrame.add(Player1);

		JTextField txtPlayer1 = new JTextField();
		txtPlayer1.setBounds(130, 20, 200, 30);
		txtPlayer1.setFont(fontMenu);
		setupFrame.add(txtPlayer1);

		JLabel Player2 = new JLabel("Player 2:");
		Player2.setBounds(50, 90, 150, 30);
		Player2.setFont(fontMenu);
		setupFrame.add(Player2);

		JTextField txtPlayer2 = new JTextField();
		txtPlayer2.setBounds(130, 90, 200, 30);
		txtPlayer2.setFont(fontMenu);
		setupFrame.add(txtPlayer2);

		JButton dongY = new JButton("Accept");
		dongY.setBounds(50, 150, 100, 30);
		dongY.setFont(fontMenu);
		dongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName1 = txtPlayer1.getText();
				playerName2 = txtPlayer2.getText();
				setupFrame.setVisible(false);
				gamePanel.repaint();
			}
		});

		JButton huyBo = new JButton("Cancel");
		huyBo.setBounds(250, 150, 100, 30);
		huyBo.setFont(fontMenu);
		huyBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupFrame.setVisible(false);
			}
		});

		setupFrame.add(dongY);
		setupFrame.add(huyBo);
		setupFrame.setLocationRelativeTo(this);
		setupFrame.setVisible(true);
	}
	
	public String[] getPlayerNames(){
	    return new String[]{playerName1, playerName2};
	}
	
	public void setDefaultPlayerNames() {
		this.playerName1 = defaultPlayerNames[0];
		this.playerName2 = defaultPlayerNames[1];
    }
	
	public void showStartScreen() {
	    getContentPane().remove(gamePanel);
	    getContentPane().repaint();

	    start = new StartGame(this);
	    add(start);

	    getContentPane().revalidate();
	    getContentPane().repaint();

	    this.setJMenuBar(null); 

	    setDefaultPlayerNames();
	}

	
	
}
