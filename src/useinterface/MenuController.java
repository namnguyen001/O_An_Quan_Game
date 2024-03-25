package useinterface;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import useinterface.MainGame;

public class MenuController implements ActionListener {
    private MainGame mainGame;
    private JMenuBar menuBar;
    private JMenu menu, help;
    private JMenuItem GameMoi, Thoat, CaiDat, Luat, Them;


    public MenuController(MainGame mainGame) {
        super();
        this.mainGame = mainGame;
        menu = new JMenu("Menu");
        help = new JMenu("Help");
        GameMoi = new JMenuItem("New Game");
        GameMoi.addActionListener(this);
        Thoat = new JMenuItem("Exit");
        Thoat.addActionListener(this);
        CaiDat = new JMenuItem("Setting");
        CaiDat.addActionListener(this);
        Luat = new JMenuItem("Rule");
        Luat.addActionListener(this);
        Them = new JMenuItem("More");
        Them.addActionListener(this);
        menu.add(GameMoi);
        menu.add(CaiDat);
        menu.add(Thoat);
        help.add(Luat);
        help.add(Them);
        Font fontMenu=new Font("SansSerif",Font.BOLD,18);
        menu.setFont(fontMenu);
        help.setFont(fontMenu);
    }

    public JMenuBar getMenu() {
        menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(help);
        return menuBar;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        if (button.equals("GameMoi")) {
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem New Game");
        } else if (button.equals("CaiDat")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem Setting");
        } else if (e.getSource() == Thoat) { 
            System.exit(0);
        }else if (button.equals("Luat")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem Rule");
        }else if (button.equals("Them")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem More");
        }
    }
}

