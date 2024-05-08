package useinterface;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.Color;

public class StartGame extends JPanel implements ActionListener {
	JButton btnNewButton, btnNewButton_1;
	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JTextArea textArea;
	private boolean historyVisible = false;

	MainGame mainGame;

	public StartGame(MainGame mainGame) {
		this.mainGame = mainGame;

		title = new JLabel("Ô Ăn Quan", JLabel.CENTER);
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		setBounds(100, 200, 870, 708);

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

		btnNewButton_1 = new JButton("History");
		btnNewButton_1.setBounds(54, 323, 105, 30);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);

		btnNewButton = new JButton("New Game");
		btnNewButton.setBounds(54, 249, 105, 30);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(100, 200, 870, 708);
		textArea.setVisible(false);
		add(textArea);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				StartGame.class.getResource("/images/nhung-tranh-ve-ve-tro-choi-dan-gian-hay-nhat_053508041 (1).jpg")));
		lblNewLabel.setBounds(0, 0, 720, 600);
		add(lblNewLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			mainGame.createnewgame();
		} else if (e.getSource() == btnNewButton_1) {
			if (!historyVisible) {
				try {

					JFrame historyFrame = new JFrame("History");
					historyFrame.setSize(500, 500);
					historyFrame.setLocationRelativeTo(null);

					JTextArea textArea = new JTextArea();
					textArea.setEditable(false);

					JScrollPane scrollPane = new JScrollPane(textArea);
					historyFrame.add(scrollPane);
					historyFrame.setResizable(false);

					File file = new File("src/database/History.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line;
					while ((line = br.readLine()) != null) {
						textArea.append(line + "\n");
					}
					br.close();

					historyFrame.setVisible(true);
					historyVisible = true;

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else {
				historyVisible = false;
				textArea.setText("");
			}
		}
	}
}