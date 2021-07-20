package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle{
	
	private static final long serialVersionUID = -1950920436903509513L;
	
	Random random;
	int xVel, yVel;
	static final int SPEED=6;
	
	Ball(int x, int y, int w, int h) {
		super(x,y,w,h);
		random = new Random();
		setXDirection(random.nextInt(2)*2-1);
		setYDirection(random.nextInt(2)*2-1);
	}
	
	public void setYDirection(int randomYDirection) {
		yVel = randomYDirection * SPEED;
	}
	
	public void setXDirection(int randomXDirection) {
		xVel = randomXDirection * SPEED;
	}
	
	public void move() {
		x += xVel;
		y += yVel;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
	}
	
}
