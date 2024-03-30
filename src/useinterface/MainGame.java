package useinterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainGame extends JFrame {

    private JLabel jlabel;
    private MenuController menuControl;
    private GamePanel gamePanel;
    private static int currentTeam = 0;
    private JButton btnNewButton;

    public MainGame() {
        this.setTitle("Ô Ăn Quan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(870, 750);
        setLocationRelativeTo(null);
        setResizable(false);

        gamePanel = new GamePanel();
        add(gamePanel);
        
        menuControl = new MenuController(this);
        this.setJMenuBar(menuControl.getMenu());
        this.setVisible(true);
    }

    public void setTextJlabel(String s) {
        this.jlabel.setText(s);
    }


    void showMore() {
        String s = "Trò chơi mô phỏng ô ăn quan.\nTác giả: NG\nChúc các bạn vui vẻ.";
        JOptionPane.showMessageDialog(this, s, "Ô Ăn Quan", JOptionPane.PLAIN_MESSAGE);
    }

    void showRule() {
        JLabel content = new JLabel("<html>"
                + "<h1>How to play</h1>"
                + "<p>"
                + "Hover the cursor over one of five square in your side.<br>"
                + "The square will turn blue if it's a valid move.<br>"
                + "An arrow will appear depends on whether the cursor is to the left or the right of the square, indicating the direction of the move.<br>"
                + "You click on the square to make your move.<br>"
                + "The game ends when both big cells are emptied.<br>"
                + "</p>"
                + "<h1>Hướng dẫn chơi game</h1>"
                + "<p>"
                + "Đưa chuột lên một trong năm ô thuộc về bên của bạn.<br>"
                + "Ô đó sẽ chuyển màu xanh dương.<br>"
                + "Nếu bạn đưa chuột về bên phải ô sẽ hiện lên ▶, nếu đưa chuột về bên trái ô sẽ hiện lên ◀, tương ứng với chiều rải quân.<br>"
                + "Bạn click chuột để thực hiện nước đi của mình.<br>"
                + "Trò chơi kết thúc khi hai ô quan đã được ăn hết.<br>"
                + "</html>");
        content.setBorder(new EmptyBorder(50, 50, 50, 50));
        JOptionPane.showMessageDialog(this, content, "Rule", JOptionPane.PLAIN_MESSAGE);
    }
}
