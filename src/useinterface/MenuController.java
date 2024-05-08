package useinterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuController implements ActionListener {
    private GamePanel gamePanel;
    private MainGame mainGame;
    private JMenuBar menuBar;
    private JMenu menu, help, setname;
    private JMenuItem GameMoi, Thoat, CaiDat, Luat, Them, SetName,Back;

    public MenuController(MainGame mainGame) {
        super();
        this.mainGame = mainGame;
        menu = new JMenu("Menu");
        help = new JMenu("Help");
        setname = new JMenu("Set Name");
        GameMoi = new JMenuItem("New Game");
        Thoat = new JMenuItem("Exit");
        CaiDat = new JMenuItem("Setting");
        Luat = new JMenuItem("Rule");
        Them = new JMenuItem("More");
        SetName = new JMenuItem("Set Name");
        Back = new JMenuItem("Back");

        GameMoi.addActionListener(this);
        Thoat.addActionListener(this);
        CaiDat.addActionListener(this);
        Luat.addActionListener(this);
        Them.addActionListener(this);
        SetName.addActionListener(this);
        Back.addActionListener(this);

        menu.add(GameMoi);
        menu.add(CaiDat);
        menu.add(Back);
        menu.add(Thoat);
        help.add(Luat);
        help.add(Them);
        setname.add(SetName);

        Font fontMenu = new Font("SansSerif", Font.BOLD, 15);
        menu.setFont(fontMenu);
        help.setFont(fontMenu);
        setname.setFont(fontMenu);
    }

    public JMenuBar getMenu() {
        menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(help);
        menuBar.add(setname);
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Thoat) {
            System.exit(0);
        }
        if (e.getSource() == Them) {
            mainGame.showMore();
        }
        if (e.getSource() == Luat) {
            mainGame.showRule();
        }
        if (e.getSource() == GameMoi) {
            mainGame.newGame();
            
        }
        if (e.getSource() == CaiDat) {
            mainGame.Setting();
        }
        if (e.getSource() == SetName) {
            mainGame.SetName();
        }
        if (e.getSource() == Back) {
            mainGame.showStartScreen();
        }

    }
    
}
