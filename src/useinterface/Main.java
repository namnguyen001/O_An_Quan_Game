package useinterface;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartGame();
            }
        });
    }
}
