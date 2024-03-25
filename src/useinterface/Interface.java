package useinterface;

import javax.swing.*;
import java.awt.*;
public class Interface extends JPanel {
    Process proccess;
    public Interface(){
        super();
        init();
    }
    public void init(){
        proccess = new Process(this);
        proccess.start();
		proccess.resize();
    }
    @Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Image backgroundImage;
		try {
			backgroundImage = new ImageIcon("src//images//background.jpg").getImage();
			g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
