package pack1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = -8642652244199076361L;
	
	static final int GAME_WIDTH  = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * 5)/9;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	
	Random random;
	Paddle paddle1, paddle2;
	Ball ball;
	Score score;
	
	boolean running = true;
	
	GamePanel() {
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		ball = new Ball((GAME_WIDTH-BALL_DIAMETER)/2,(GAME_HEIGHT-BALL_DIAMETER)/2,BALL_DIAMETER,BALL_DIAMETER);
		
	}
	
	public void newPaddles() {
		paddle1 = new Paddle(0, 						(GAME_HEIGHT-PADDLE_HEIGHT)/2, PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, 	(GAME_HEIGHT-PADDLE_HEIGHT)/2, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision() {
		// bounce ball of walls
		if (ball.y < 0)	{
			ball.y=0;
			ball.yVel *= -1;
		}
		if (ball.y > GAME_HEIGHT-BALL_DIAMETER) {
			ball.y=GAME_HEIGHT-BALL_DIAMETER;
			ball.yVel *= -1;
		}
		// bounce ball of paddles
		if (ball.intersects(paddle1)) {
			ball.xVel = Math.abs(ball.xVel);
//			ball.xVel++;
		}
		if (ball.intersects(paddle2)) {
			ball.xVel = -Math.abs(ball.xVel);
//			ball.xVel--;
		}
		
		// gameOver check
		if (ball.x <= 0) {
			score.player2++;
			newPaddles();
			newBall();
		}
		if (ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
		}
		
		// stop paddles at window edges
		if (paddle1.y < 0)							{paddle1.y=0;}
		if (paddle2.y < 0)							{paddle2.y=0;}
		if (paddle1.y > GAME_HEIGHT-PADDLE_HEIGHT) 	{paddle1.y=GAME_HEIGHT-PADDLE_HEIGHT;}
		if (paddle2.y > GAME_HEIGHT-PADDLE_HEIGHT)	{paddle2.y=GAME_HEIGHT-PADDLE_HEIGHT;}
	}
	
	public void run() {
		// create game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
