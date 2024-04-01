package useinterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;

public class StartGame extends JPanel implements ActionListener {
	JButton btnNewButton ;
	private static final long serialVersionUID = 1L;
	private JLabel title;
	MainGame mainGame;
	
	/**
	 * Create the panel.
	 */
	public StartGame(MainGame mainGame) {
		this.mainGame = mainGame; // Set the MainGame instance
		
		title = new JLabel("Ô Ăn Quan", JLabel.CENTER);
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		setBounds(100,200,870, 708);
		
		JLabel lblNewLabel_1 = new JLabel("Ô ĂN QUAN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_1.setBounds(187, 54, 315, 68);
		add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(54, 400, 105, 30);
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		
		
		JButton btnNewButton_1 = new JButton("History");
		btnNewButton_1.setBounds(54, 323, 105, 30);
		add(btnNewButton_1);
		
		btnNewButton = new JButton("New Game");
		btnNewButton.setBounds(54, 249, 105, 30);
		btnNewButton.addActionListener(this);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StartGame.class.getResource("/images/nhung-tranh-ve-ve-tro-choi-dan-gian-hay-nhat_053508041 (1).jpg")));
		lblNewLabel.setBounds(0, 0, 720, 600);
		add(lblNewLabel);
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnNewButton) {
	        mainGame.createnewgame();
	    }
	}
}
