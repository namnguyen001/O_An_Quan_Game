package useinterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import controller.Process;
import gameinterface.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener{
    private Table table;
    private Process process;
    private Box box;
    
    public GamePanel(){
        process = new Process();
        table = new Table(process.getSquares());
        // Thêm các lắng nghe sự kiện chuột vào GamePanel
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;  
        table.draw(g2);
    }
    
    // Override các phương thức của MouseListener và MouseMotionListener
    @Override
    public void mouseClicked(MouseEvent e) {
        // Xử lý sự kiện khi chuột được nhấn và nhả ra
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Xử lý sự kiện khi chuột được nhấn xuống
        table.mousePressed(e);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Xử lý sự kiện khi chuột được nhả ra
        table.mouseReleased(e);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Xử lý sự kiện khi chuột đi vào
        table.mouseEntered(e);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Xử lý sự kiện khi chuột đi ra khỏi vùng GamePanel
        table.mouseExited(e);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Xử lý sự kiện khi chuột được kéo đi (nhấn xuống và di chuyển)
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Xử lý sự kiện khi chuột được di chuyển (không nhấn)
        table.mouseMoved(e);
        repaint();
    }   
}
