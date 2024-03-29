package useinterface;

import javax.swing.UIManager;

public class Main {
 public static void main(String[] args) {
	try {
		MainGame ng = new MainGame();
		ng.setVisible(true);
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}
}