package useinterface;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuController implements ActionListener {
    private MainGame mainGame;
    private JMenuBar menuBar;
    private JMenu menu, help;
    private JMenuItem GameMoi, Thoat, TocDo;

    public MenuController(MainGame mainGame) {
        super();
        this.mainGame = mainGame;
        menu = new JMenu("Menu");
        help = new JMenu("Help");
        GameMoi = new JMenuItem("New Game");
        Thoat = new JMenuItem("Exit");
        TocDo = new JMenuItem("Speed");
        GameMoi.addActionListener(this);
        Thoat.addActionListener(this);
        TocDo.addActionListener(this);
        menu.add(GameMoi);
        menu.add(TocDo);
        menu.add(Thoat);
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

        if (button.equals("New Game")) {
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem New Game");
        } else if (button.equals("Speed")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem Speed");
        } else if (button.equals("Exit")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem Exit");
            System.exit(0);
        }
    }
}

