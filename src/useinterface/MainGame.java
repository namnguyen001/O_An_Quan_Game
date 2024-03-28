package useinterface;

import javax.swing.*;
import java.awt.*;

public class MainGame extends JFrame{
    
    // public static final int SCREEN_WIDTH = 1000;
    // public static final int SCREEN_HEIGHT = 600;
    private JLabel jlabel;
    private MenuController menuControl;
    private GamePanel gamePanel;
    private static int currentTeam=0;
    

	public MainGame() {
        this.setTitle("Ô Ăn Quan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(870, 750);
		setLocationRelativeTo(null);
		setResizable(false);

       gamePanel = new GamePanel();
       add(gamePanel);
        // Tạo controller và thêm MenuBar
        menuControl = new MenuController(this);
        this.setJMenuBar(menuControl.getMenu());
        this.setVisible(true);
    }

    public void setTextJlabel(String s) {
    	this.jlabel.setText(s);
    }    
    
    public static int getCurTeam() {
		return currentTeam;
	}
}       