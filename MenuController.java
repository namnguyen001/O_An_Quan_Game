package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuController implements ActionListener {
    private MainGame mainGame;

    public MenuController(MainGame mainGame) {
        super();
        this.mainGame = mainGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        if (button.equals("New Game")) {
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem New Game");
        } else if (button.equals("Setting")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem Setting");
        } else if (button.equals("Exit")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem Exit");
            System.exit(0);
        }else if (button.equals("Rule")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem Rule");
        }else if (button.equals("More")) { 
            this.mainGame.setTextJlabel("Bạn đã click jmenuItem More");
        }
    }
}
