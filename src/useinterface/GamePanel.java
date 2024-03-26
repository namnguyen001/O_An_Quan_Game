package useinterface;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    private Interface face;
    private Process process;
    public GamePanel(){
        process = new Process();
		face = new Interface(process.getSquares());
    }

    
}
