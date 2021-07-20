package pack;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH  = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 75;
	
	final int[] x = new int[GAME_UNITS];
	final int[] y = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten = 0;
	int appleX;
	int appleY;
	char direction = 'R'; // U D L
	boolean running = false;
	boolean updated = false;
	
	Timer timer;
	Random random;
	
	GamePanel() {
		random = new Random();
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.DARK_GRAY);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		
		startGame();
	}

	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (running) {
			// Grid Lines
//			for (int i=0; i<SCREEN_HEIGHT/UNIT_SIZE; i++) {
//				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
//			}
//			for (int j=0; j<SCREEN_WIDTH/UNIT_SIZE; j++) {
//				g.drawLine(0, j*UNIT_SIZE, SCREEN_WIDTH, j*UNIT_SIZE);
//			}
			
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
			g.setColor(Color.green);
			g.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);
			
			for (int i=1; i<bodyParts; i++) {
				g.setColor(new Color(50-random.nextInt(10),190-random.nextInt(10),10-random.nextInt(10)));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			
			g.setColor(Color.orange);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
			
		} else {
			gameOver(g);
		}
	}
	
	public void newApple() {
		appleX = random.nextInt((int) (SCREEN_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int) (SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;	
	}
	
	public void move() {
		for (int i=bodyParts; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = (y[0] - UNIT_SIZE + SCREEN_HEIGHT)%SCREEN_HEIGHT;
			break;
		case 'D':
			y[0] = (y[0] + UNIT_SIZE + SCREEN_HEIGHT)%SCREEN_HEIGHT;
			break;
		case 'L':
			x[0] = (x[0] - UNIT_SIZE + SCREEN_WIDTH)%SCREEN_WIDTH;
			break;
		case 'R':
			x[0] = (x[0] + UNIT_SIZE + SCREEN_WIDTH)%SCREEN_WIDTH;
			break;
		}
	}

	public void checkApple() {
		if (x[0]==appleX && y[0]==appleY) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	
	public void checkCollisions() {
		// checks if head collides with body
		for (int i=bodyParts; i>0; i--) {
			if ((x[0]==x[i]) && (y[0]==y[i])) {
				running = false;
			}
		}
		
		// if head touches border
//		if (!(
//				(x[0]>=0 && x[0]<SCREEN_WIDTH) &&
//				(y[0]>=0 && y[0]<SCREEN_HEIGHT)
//			)) {
//			running = false;
//		}
	}
	
	public void gameOver(Graphics g) {
		// Keep Score
		g.setColor(Color.orange);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		
		
		// Game Over text
		g.setColor(Color.lightGray);
		g.setFont(new Font("Tahoma", Font.BOLD, 40));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
		updated = true;
	}
	
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (updated) {
				updated = false;
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (direction != 'R') {
						direction = 'L';
					} break;
				
				case KeyEvent.VK_RIGHT:
					if (direction != 'L') {
						direction = 'R';
					} break;
				
				case KeyEvent.VK_UP:
					if (direction != 'D') {
						direction = 'U';
					} break;
				
				case KeyEvent.VK_DOWN:
					if (direction != 'U') {
						direction = 'D';
					} break;
				}
			}
		}
	}
}
