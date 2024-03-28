package useinterface;

import javax.swing.*;
import java.awt.*;

public class MainGame extends JFrame{
    
    public static final int SCREEN_WIDTH = 870;
    public static final int SCREEN_HEIGHT = 750;
    private JLabel jlabel;
    private MenuController menuControl;
    private GamePanel gamePanel;

	public MainGame() {
        this.setTitle("Ô Ăn Quan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //hiển thị ảnh nền ban đầu khi mở

        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width - SCREEN_WIDTH) / 2, (dimension.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH,
                SCREEN_HEIGHT);
       gamePanel = new GamePanel();
       add(gamePanel);
        // Tạo controller và thêm MenuBar
        menuControl = new MenuController(this);
        this.setJMenuBar(menuControl.getMenu());
       

//        Toolkit toolkit = this.getToolkit();
//        Dimension dimension = toolkit.getScreenSize();
//        this.setBounds((dimension.width - SCREEN_WIDTH) / 2, (dimension.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH,
//                SCREEN_HEIGHT);
        setSize(SCREEN_WIDTH ,SCREEN_HEIGHT);
        setResizable(false);
        // Truyền kích thước cửa sổ vào GamePanel
        //start = new StartGame();
        gamePanel = new GamePanel();
        add(gamePanel);
        //add(start);
        // Tạo controller và thêm MenuBar
        menuControl = new MenuController(this);
        this.setJMenuBar(menuControl.getMenu());
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public void setTextJlabel(String s) {
    	this.jlabel.setText(s);
    }    
}       
