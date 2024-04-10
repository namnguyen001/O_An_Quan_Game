package useinterface;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import controller.Process;
import gameinterface.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener, Runnable {
    private Table table;
    private Process process;
    private Thread thread;
    private int player = 1, index = 0;
    private int location, action;
    private boolean click;
    private Image background;

    public GamePanel() {
        process = new Process();
        table = new Table(process.getSquares());
        addMouseListener(this);
        addMouseMotionListener(this);
        background = new ImageIcon("src/images/background.jpg").getImage();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        table.draw(g2d);
    }

    @Override
    public void run() {
        while (!process.finish()) {
            process.setScores(new ArrayList<>());// reset lại kết quả trên bàn cờ cho việc tính toán mới
            if (player == 2) {
                if (click) {
                    if (action == 1) {
                        process.left2(location);
                    } else {
                        process.right2(location);
                    }
                    while (index < process.getScores().size()) {
                        table = new Table(process.getScores().get(index).getSquares());
                        repaint();
                        index++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    player = 1;
                }
                repaint();
            } else {
                if (click) {
                    if (action == 1) {
                        process.left(location);
                    } else {
                        process.right(location);
                    }
                    while (index < process.getScores().size()) {
                        table = new Table(process.getScores().get(index).getSquares());
                        repaint();
                        index++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                player = 2;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        table.mousePressed(e);
        Point p = e.getPoint();
        int px = (int) e.getX();
        int py = (int) e.getY();
        Graphics2D g2d = (Graphics2D) getGraphics();

        // CLICK HÀNG TRÊN
        if ((px > 102 && px < 137) && (py < 215 && py > 185)) {
            System.out.println("left");
            player = 1;
            location = 1;
            action = 1;
            click = true;
        }
        if ((px > 160 && px < 195) && (py < 215 && py > 185)) {
            System.out.println("right");
            player = 1;
            location = 1;
            action = 2;
            click = true;
        }
        if ((px > 196 && px < 232) && (py < 215 && py > 185)) {
            System.out.println("left-2");
            player = 1;
            location = 2;
            action = 1;
            click = true;
        }
        if ((px > 255 && px < 293) && (py < 215 && py > 185)) {
            System.out.println("right-2");
            player = 1;
            location = 1;
            action = 2;
            click = true;
        }
        if ((px > 296 && px < 332) && (py < 215 && py > 185)) {
            System.out.println("left-3");
            player = 1;
            location = 3;
            action = 1;
            click = true;
        }
        if ((px > 355 && px < 391) && (py < 215 && py > 185)) {
            System.out.println("right-3");
            player = 1;
            location = 1;
            action = 2;
            click = true;
        }
        if ((px > 393 && px < 429) && (py < 215 && py > 185)) {
            System.out.println("left-4");
            player = 1;
            location = 4;
            action = 1;
            click = true;
        }
        if ((px > 452 && px < 488) && (py < 215 && py > 185)) {
            System.out.println("right-4");
            player = 1;
            location = 1;
            action = 2;
            click = true;
        }
        if ((px > 491 && px < 527) && (py < 215 && py > 185)) {
            System.out.println("left-5");
            player = 1;
            location = 5;
            action = 1;
            click = true;
        }
        if ((px > 551 && px < 587) && (py < 215 && py > 185)) {
            System.out.println("right-5");
            player = 1;
            location = 1;
            action = 2;
            click = true;
        }

        // CLICK HÀNG DƯỚI
        if ((px > 102 && px < 137) && (py < 305 && py > 275)) {
            System.out.println("left");
            player = 2;
            location = 11;
            action = 1;
            click = true;
        }
        if ((px > 160 && px < 195) && (py < 305 && py > 275)) {
            System.out.println("right");
            player = 2;
            location = 11;
            action = 2;
            click = true;
        }
        if ((px > 196 && px < 232) && (py < 305 && py > 275)) {
            System.out.println("left-2");
            player = 2;
            location = 10;
            action = 1;
            click = true;
        }
        if ((px > 255 && px < 293) && (py < 305 && py > 275)) {
            System.out.println("right-2");
            player = 2;
            location = 10;
            action = 2;
            click = true;
        }
        if ((px > 296 && px < 332) && (py < 305 && py > 275)) {
            System.out.println("left-3");
            player = 2;
            location = 9;
            action = 1;
            click = true;
        }
        if ((px > 355 && px < 391) && (py < 305 && py > 275)) {
            System.out.println("right-3");
            player = 2;
            location = 9;
            action = 2;
            click = true;
        }
        if ((px > 393 && px < 429) && (py < 305 && py > 275)) {
            System.out.println("left-4");
            player = 2;
            location = 8;
            action = 1;
            click = true;
        }
        if ((px > 452 && px < 488) && (py < 305 && py > 275)) {
            System.out.println("right-4");
            player = 2;
            location = 8;
            action = 2;
            click = true;
        }
        if ((px > 491 && px < 527) && (py < 305 && py > 275)) {
            System.out.println("left-5");
            player = 2;
            location = 7;
            action = 1;
            click = true;
        }
        if ((px > 551 && px < 587) && (py < 305 && py > 275)) {
            System.out.println("right-5");
            player = 2;
            location = 7;
            action = 2;
            click = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        table.mouseReleased(e);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        table.mouseEntered(e);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        table.mouseExited(e);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        table.mouseMoved(e);
        repaint();
    }
}
