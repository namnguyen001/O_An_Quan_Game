package useinterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.Process;

public class MainGame extends JFrame {

    private JLabel jlabel;
    private MenuController menuControl;
    private GamePanel gamePanel;
    public int currentTeam = 0;
    int numberInBox = 5;
    int numberInScoreBox = 10;
    private StartGame start;
    private Process process; // 
    private MainGame mainGame;

    public MainGame() {
    	this.setTitle("Ô Ăn Quan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(713, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        start = new StartGame(this);
        add(start);
        
        gamePanel = new GamePanel();

       
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
        String s = "Trò chơi mô phỏng ô ăn quan.\nTác giả: NG\nChúc các bạn vui vẻ.";
        JOptionPane.showMessageDialog(this, s, "Ô Ăn Quan", JOptionPane.PLAIN_MESSAGE);
    }

    void showRule() {
        JLabel content = new JLabel("<html>" + "<h1>How to play</h1>" + "<p>"
        		+ "Mouse over one of the five cells belonging to your side.<br>"
                + "An arrow will appear depending on whether the mouse pointer is to the left or right of the cell, showing the direction.<br>"
                + "Click on the box to make a move.<br>"
                + "The game ends when both squares have been taken.<br>" + "</p>" + "<h1>Hướng dẫn chơi game</h1>" + "<p>"
                + "Đưa chuột lên một trong năm ô thuộc về bên của bạn.<br>" 
                + "Nếu bạn đưa chuột về bên phải ô sẽ hiện lên ▶, nếu đưa chuột về bên trái ô sẽ hiện lên ◀, tương ứng với chiều rải quân.<br>"
                + "Bạn click chuột để thực hiện nước đi của mình.<br>"
                + "Trò chơi kết thúc khi hai ô quan đã được ăn hết.<br>" + "</html>");
        content.setBorder(new EmptyBorder(1, 1, 1, 1));
        JOptionPane.showMessageDialog(this, content, "Rule", JOptionPane.PLAIN_MESSAGE);
    }

    // public void newGame() {
    //     int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn chơi lại không?", "Retard alert",
    //             JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
    //     if (option == JOptionPane.YES_OPTION) {
    //         process.reDraw();
    //     }
    // }

   
}
