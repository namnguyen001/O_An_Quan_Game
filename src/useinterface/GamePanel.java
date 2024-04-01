package useinterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
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
        Point p = e.getPoint();
        int px = (int) e.getX();
        int py = (int) e.getY();

        //CLICK HÀNG TRÊN
        if((px > 192 && px < 227) && (py < 305 && py > 275)  ){
            System.out.println("left");
        }
        if((px > 247 && px < 282) && (py < 305 && py > 275)  ){
            System.out.println("right");
        }
        if((px > 284 && px < 323) && (py < 305 && py > 275)  ){
            System.out.println("left-2");
        }
        if((px > 346 && px < 379) && (py < 305 && py > 275)  ){
            System.out.println("right-2");
        }
        if((px > 383 && px < 418) && (py < 305 && py > 275)  ){
            System.out.println("left-3");
        }
        if((px > 441 && px < 476) && (py < 305 && py > 275)  ){
            System.out.println("right-3");
        }
        if((px > 483 && px < 518) && (py < 305 && py > 275)  ){
            System.out.println("left-4");
        }
        if((px > 541 && px < 576) && (py < 305 && py > 275)  ){
            System.out.println("right-4");
        }
        if((px > 582 && px < 617) && (py < 305 && py > 275)  ){
            System.out.println("left-5");
        }
        if((px > 640 && px < 675) && (py < 305 && py > 275)  ){
            System.out.println("right-5");
        }
        
        // CLICK HÀNG DƯỚI
        if((px > 192 && px < 227) && (py < 395 && py > 365)  ){
            System.out.println("left");
        }
        if((px > 247 && px < 282) && (py < 395 && py > 365)  ){
            System.out.println("right");
        }
        if((px > 284 && px < 323) && (py < 395 && py > 365)  ){
            System.out.println("left-2");
        }
        if((px > 346 && px < 379) && (py < 395 && py > 365)  ){
            System.out.println("right-2");
        }
        if((px > 383 && px < 418) && (py < 395 && py > 365)  ){
            System.out.println("left-3");
        }
        if((px > 441 && px < 476) && (py < 395 && py > 365)  ){
            System.out.println("right-3");
        }
        if((px > 483 && px < 518) && (py < 395 && py > 365)  ){
            System.out.println("left-4");
        }
        if((px > 541 && px < 576) && (py < 395 && py > 365)  ){
            System.out.println("right-4");
        }
        if((px > 582 && px < 617) && (py < 395 && py > 365)  ){
            System.out.println("left-5");
        }
        if((px > 640 && px < 675) && (py < 395 && py > 365)  ){
            System.out.println("right-5");
        }
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
        moveStone(e);
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
    
    private void moveStone(MouseEvent e) {
        int px = (int) e.getX();
        int py = (int) e.getY();

        // Xác định vị trí của ô và hướng di chuyển
        int position = -1; // Giả sử không có ô nào được chọn
        int direction = 0; // Khởi tạo hướng di chuyển
        boolean isEaten = false; // Khởi tạo cờ cho biết ô có bị ăn không
        int left = 1, right = 2;

        // Xác định vị trí và hướng di chuyển dựa trên tọa độ của chuột
        if ((px > 192 && px < 227) && (py < 305 && py > 275)) {
            position = 1;
            direction = 1;
            process.move(position, direction, isEaten);
        } else if ((px > 247 && px < 282) && (py < 305 && py > 275)) {
            position = 2;
            direction = 2;
            process.move(position, direction, isEaten);
//        } else if  {
//            // Xử lý các trường hợp khác nếu cần
        }

    }

}
