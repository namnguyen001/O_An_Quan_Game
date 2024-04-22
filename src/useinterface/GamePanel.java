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
	private int player = 1, index = 0, diem = 0;
	private int location, direction;
	private boolean click, rai;
	private Image background, playerImage,co;
	private Box[] boxes;
	private int moveSpeed = 500;

	public GamePanel() {
		process = new Process();
		table = new Table(process.getSquares());
		addMouseListener(this);
		addMouseMotionListener(this);
		background = new ImageIcon("src/images/background.jpg").getImage();
		playerImage = new ImageIcon("src/images/flag.jpg").getImage();
		co =  new ImageIcon("src/images/co1.png").getImage();
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		table.draw(g2d);
		if (player == 1) {
			g2d.drawImage(co, 240, 35, 70, 70, null);
			g2d.drawString("Player 1's Turn", 340, 130);
		} else {
			g2d.drawImage(co, 240, 435, 70, 70, null);
			g2d.drawString("Player 2's Turn", 340, 400);
		}
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted() && !process.finish()) {
			index = 0;
			process.setScores(new ArrayList<>());
			if (player == 1) {
				if (process.kiemTraHetQuan(player)) {
					process.rai(player);
					rai = true;
					table = new Table(process.getScores().get(index).getSquares());
					repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						rai = false;
					}
				}
			} else {
				if (process.kiemTraHetQuan(player)) {
					process.rai(player);
					rai = true;
					table = new Table(process.getScores().get(index).getSquares());
					repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						rai = false;
					}
				}
			}
			process.setScores(new ArrayList<>());
			if (player == 2) {
				if (click) {
					diem = 0;
					if (direction == 1) {
						diem = process.kill(process.move(location, -1), -1);
					} else {
						diem = process.kill(process.move(location, 1), 1);
					}
					process.setScorePlayer(diem, 2);
					while (index < process.getScores().size()) {
						table = new Table(process.getScores().get(index).getSquares());
						repaint();
						index++;
						try {
							Thread.sleep(moveSpeed);
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
						diem = process.kill(process.move(location, 1), 1);
					} else {
						diem = process.kill(process.move(location, -1), -1);
					}
					process.setScorePlayer(diem, 1);
					while (index < process.getScores().size()) {
						table = new Table(process.getScores().get(index).getSquares());
						repaint();
						index++;
						try {
							Thread.sleep(moveSpeed);
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
		if (process.getSquares()[12].getGiatri() > process.getSquares()[13].getGiatri()) {
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		} else if (process.getSquares()[12].getGiatri() < process.getSquares()[13].getGiatri()) {
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "It's a tie!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void setMoveSpeed(int newSpeed) {
		this.moveSpeed = newSpeed;
	}

	public int getMoveSpeed() {
		return this.moveSpeed;
	}

	public Table getTable() {
		return this.table;
	}

	public void reDraw() {
	    if (thread != null) {
	        thread.interrupt(); 
	    }

	    removeMouseListener(this);
	    removeMouseMotionListener(this);
	    process = new Process();
	    table = new Table(process.getSquares());
	    addMouseListener(this);
	    addMouseMotionListener(this);
	    process.setCurrentPlayer(1);
	    index = 0;
	    diem = 0;
	    click = false;
	    thread = new Thread(this);
	    thread.start();
	    repaint();
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
			if (process.getCurrentPlayer() == 1) {
				location = 1;
				direction = -1;
				click = true;

				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}

		}
		if ((px > 160 && px < 195) && (py < 215 && py > 185)) {
			System.out.println("right");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 1;
				direction = 1;
				click = true;

				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}

		}
		if ((px > 196 && px < 232) && (py < 215 && py > 185)) {
			System.out.println("left-2");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 2;
				direction = -1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}

		}

		if ((px > 255 && px < 293) && (py < 215 && py > 185)) {
			System.out.println("right-2");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 2;
				direction = 1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}

		}
		if ((px > 296 && px < 332) && (py < 215 && py > 185)) {
			System.out.println("left-3");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 3;
				direction = -1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}
		}

		if ((px > 355 && px < 391) && (py < 215 && py > 185)) {
			System.out.println("right-3");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 3;
				direction = 1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}
		}
		if ((px > 393 && px < 429) && (py < 215 && py > 185)) {
			System.out.println("left-4");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 4;
				direction = -1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}
		}
		if ((px > 452 && px < 488) && (py < 215 && py > 185)) {
			System.out.println("right-4");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 4;
				direction = 1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}
		}

		if ((px > 491 && px < 527) && (py < 215 && py > 185)) {
			System.out.println("left-5");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 5;
				direction = -1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}
		}
		if ((px > 551 && px < 587) && (py < 215 && py > 185)) {
			System.out.println("right-5");
			if (process.getCurrentPlayer() == 1) {
				player = 1;
				location = 5;
				direction = 1;
				click = true;
				process.setCurrentPlayer(2);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 2's turn now, please wait for your turn.");
			}
		}

		// CLICK HÀNG DƯỚI
		if ((px > 102 && px < 137) && (py < 305 && py > 275)) {
			System.out.println("left");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 11;
				direction = -1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 160 && px < 195) && (py < 305 && py > 275)) {
			System.out.println("right");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 11;
				direction = 1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 196 && px < 232) && (py < 305 && py > 275)) {
			System.out.println("left-2");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 10;
				direction = -1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 255 && px < 293) && (py < 305 && py > 275)) {
			System.out.println("right-2");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 10;
				direction = 1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 296 && px < 332) && (py < 305 && py > 275)) {
			System.out.println("left-3");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 9;
				direction = -1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 355 && px < 391) && (py < 305 && py > 275)) {
			System.out.println("right-3");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 9;
				direction = 1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 393 && px < 429) && (py < 305 && py > 275)) {
			System.out.println("left-4");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 8;
				direction = -1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 452 && px < 488) && (py < 305 && py > 275)) {
			System.out.println("right-4");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 8;
				direction = 1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 491 && px < 527) && (py < 305 && py > 275)) {
			System.out.println("left-5");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 7;
				direction = -1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
		}
		if ((px > 551 && px < 587) && (py < 305 && py > 275)) {
			System.out.println("right-5");
			if (process.getCurrentPlayer() == 2) {
				player = 2;
				location = 7;
				direction = 1;
				click = true;
				process.setCurrentPlayer(1);
			} else {
				JOptionPane.showMessageDialog(this, "It is Player 1's turn now, please wait for your turn.");
			}
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
