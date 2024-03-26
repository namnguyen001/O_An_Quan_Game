package Game;

import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MainGame();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
