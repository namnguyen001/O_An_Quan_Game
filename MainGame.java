package Game;

import javax.swing.*;
import java.awt.*;

public class MainGame extends JFrame {
    private JLabel jlabel;
    
    public static final int 
	xUnit=16,
	yUnit=9;
    public static int multiple=80;
    
    public MainGame() {
        this.setTitle("Ô Ăn Quan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một JLabel để hiển thị ảnh nền
        JLabel backgroundLabel = new JLabel();
        ImageIcon backgroundImage = new ImageIcon("src/images/background.jpg");
        backgroundLabel.setIcon(backgroundImage);

        // Lấy kích thước của ảnh và đặt kích thước cho JLabel
        Dimension imageSize = new Dimension(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        backgroundLabel.setPreferredSize(imageSize);

        // Thêm JLabel vào JFrame
        this.getContentPane().add(backgroundLabel);

        // Tạo controller
        MenuController menucontrol = new MenuController(this);

        // Tạo menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItemNewGame = new JMenuItem("New Game");
        menuItemNewGame.addActionListener(menucontrol);
        JMenuItem menuItemSetting = new JMenuItem("Setting");
        menuItemSetting.addActionListener(menucontrol);
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(menucontrol);
        menu.add(menuItemNewGame);
        menu.add(menuItemSetting);
        menu.add(menuItemExit);
        menuBar.add(menu);

        // Tạo menu Help
        JMenu menuHelp = new JMenu("Help");
        JMenuItem menuItemRule = new JMenuItem("Rule");
        menuItemRule.addActionListener(menucontrol);
        JMenuItem menuItemInfo = new JMenuItem("More");
        menuItemInfo.addActionListener(menucontrol);
        menuHelp.add(menuItemRule);
        menuHelp.add(menuItemInfo);
        menuBar.add(menuHelp);

        // Đặt menu bar vào phía trên cùng của cửa sổ
        this.setJMenuBar(menuBar);

        // Tạo Label hiển thị
        jlabel = new JLabel();
        jlabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        jlabel.repaint();

        this.pack(); // Tự động điều chỉnh kích thước JFrame để vừa với nội dung
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(jlabel, BorderLayout.CENTER);
        this.setVisible(true);
        
        JPanel boxPanel = createBox();
        this.add(boxPanel, BorderLayout.CENTER);
    }

    public void setTextJlabel(String s) {
        this.jlabel.setText(s);
    }

    public JPanel createBox() {
        Box box = new Box(0);
        return box.createBox();
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MainGame();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
}
