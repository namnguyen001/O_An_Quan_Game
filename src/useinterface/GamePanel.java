package useinterface;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.Process;
import gameinterface.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener, Runnable {
	private Table table;
	private Process process;
	private Thread thread;
	private int player = 1, index = 0, diem =0;
	private int location, direction;
	private boolean click;
	private Image background,playerImage;

	public GamePanel() {
		process = new Process();
		table = new Table(process.getSquares());
		addMouseListener(this);
		addMouseMotionListener(this);
		background = new ImageIcon("src/images/background.jpg").getImage();
		playerImage = new ImageIcon("src/images/flag.jpg").getImage();
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
            index = 0;
            process.setScores(new ArrayList<>()); // Reset the scores on the board for new calculations
            if (player == 2) {
                if (click) {
                    diem = 0;
                    if (direction == 1) {
                        diem = process.kill(process.move(location,-1),-1);
                        // process.left2(location);
                    } else {
                        diem = process.kill(process.move(location,1),1);
                        // process.right2(location);
                    }
                    process.setScorePlayer(diem, 2);
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
                    click = false;
                }
                repaint();
            } else {
                if (click) {
                    diem = 0;
                    if (direction == 1) {
                        diem = process.kill(process.move(location,1),1);
                        // process.left(location);
                    } else {
                        diem = process.kill(process.move(location,-1),-1);
                        // process.right(location);
                    }
                    process.setScorePlayer(diem, 1);
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
                    player = 2;
                    click = false;
                }
                repaint();
            }
        }
        JOptionPane.showMessageDialog(null, "Game over", "Game over", JOptionPane.INFORMATION_MESSAGE);
    }

	private void replayGui(Square[] squaresData) {
	    table = new Table(squaresData);
	    repaint();
	    try {
	        Thread.sleep(500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	private boolean gameOver() {
	    return process.finish();
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
			direction = -1;
			click = true;
		}
		if ((px > 160 && px < 195) && (py < 215 && py > 185)) {
			System.out.println("right");
			player = 1;
			location = 1;
			direction = 1;
			click = true;
		}
		if ((px > 196 && px < 232) && (py < 215 && py > 185)) {
			System.out.println("left-2");
			player = 1;
			location = 2;
			direction = -1;
			click = true;
		}
		if ((px > 255 && px < 293) && (py < 215 && py > 185)) {
			System.out.println("right-2");
			player = 1;
			location = 2;
			direction = 1;
			click = true;
		}
		if ((px > 296 && px < 332) && (py < 215 && py > 185)) {
			System.out.println("left-3");
			player = 1;
			location = 3;
			direction = -1;
			click = true;
		}
		if ((px > 355 && px < 391) && (py < 215 && py > 185)) {
			System.out.println("right-3");
			player = 1;
			location = 3;
			direction = 1;
			click = true;
		}
		if ((px > 393 && px < 429) && (py < 215 && py > 185)) {
			System.out.println("left-4");
			player = 1;
			location = 4;
			direction = -1;
			click = true;
		}
		if ((px > 452 && px < 488) && (py < 215 && py > 185)) {
			System.out.println("right-4");
			player = 1;
			location = 4;
			direction = 1;
			click = true;
		}
		if ((px > 491 && px < 527) && (py < 215 && py > 185)) {
			System.out.println("left-5");
			player = 1;
			location = 5;
			direction = -1;
			click = true;
		}
		if ((px > 551 && px < 587) && (py < 215 && py > 185)) {
			System.out.println("right-5");
			player = 1;
			location = 5;
			direction = 1;
			click = true;
		}

		// CLICK HÀNG DƯỚI
		if ((px > 102 && px < 137) && (py < 305 && py > 275)) {
			System.out.println("left");
			player = 2;
			location = 7;
			direction = -1;
			click = true;
		}
		if ((px > 160 && px < 195) && (py < 305 && py > 275)) {
			System.out.println("right");
			player = 2;
			location = 7;
			direction= 1;
			click = true;
		}
		if ((px > 196 && px < 232) && (py < 305 && py > 275)) {
			System.out.println("left-2");
			player = 2;
			location = 8;
			direction = -1;
			click = true;
		}
		if ((px > 255 && px < 293) && (py < 305 && py > 275)) {
			System.out.println("right-2");
			player = 2;
			location = 8;
			direction = 1;
			click = true;
		}
		if ((px > 296 && px < 332) && (py < 305 && py > 275)) {
			System.out.println("left-3");
			player = 2;
			location = 9;
			direction = -1;
			click = true;
		}
		if ((px > 355 && px < 391) && (py < 305 && py > 275)) {
			System.out.println("right-3");
			player = 2;
			location = 9;
			direction = 1;
			click = true;
		}
		if ((px > 393 && px < 429) && (py < 305 && py > 275)) {
			System.out.println("left-4");
			player = 2;
			location = 10;
			direction = -1;
			click = true;
		}
		if ((px > 452 && px < 488) && (py < 305 && py > 275)) {
			System.out.println("right-4");
			player = 2;
			location = 10;
			direction = 1;
			click = true;
		}
		if ((px > 491 && px < 527) && (py < 305 && py > 275)) {
			System.out.println("left-5");
			player = 2;
			location = 11;
			direction = -1;
			click = true;
		}
		if ((px > 551 && px < 587) && (py < 305 && py > 275)) {
			System.out.println("right-5");
			player = 2;
			location = 11;
			direction = 1;
			click = true;
		}

	}
	
	public void reDraw() {  
		    process = new Process();
	        table = new Table(process.getSquares());
	        player = 1;
	        index = 0;
	        diem =0;
	        click = false;
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
