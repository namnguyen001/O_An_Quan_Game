package useinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartGame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel title;

    /**
     * Create the panel.
     */
    public StartGame() {

        title = new JLabel("Ô Ăn Quan", JLabel.CENTER);

        getContentPane().setBackground(new Color(153, 255, 153));
        getContentPane().setLayout(null);

        JButton btnNewButton_2 = new JButton("Exit");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_2.setBounds(194, 267, 85, 21);
        getContentPane().add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("History");
        btnNewButton_1.setBounds(194, 224, 85, 21);
        getContentPane().add(btnNewButton_1);

        setTitle("Ô Ăn Quan");

        JButton btnNewButton = new JButton("New Game");
        btnNewButton.setBounds(194, 181, 85, 21);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Ô ĂN QUAN\r\n");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblNewLabel.setBounds(132, 91, 228, 61);
        getContentPane().add(lblNewLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setSize(500, 462);
        setLocationRelativeTo(null); 
        setVisible(true);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainGame().setVisible(true);
            }
        });
    }

   
}
