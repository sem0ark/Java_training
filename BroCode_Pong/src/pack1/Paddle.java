package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{
	
	private static final long serialVersionUID = -3051840153076097308L;
	
	int id, yVel;
	static final int SPEED = 7;
	
	Paddle(int x, int y, int w, int h, int id) {
		super(x,y,w,h);
		this.id = id;
	}
	
	public void keyPressed(KeyEvent e) {
		switch (id) {
		case 1:
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				setYDirection(-SPEED);
				break;
			case KeyEvent.VK_S:
				setYDirection(SPEED);
				break;
			} break;
		case 2:
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				setYDirection(-SPEED);
				break;
			case KeyEvent.VK_DOWN:
				setYDirection(SPEED);
				break;
			} break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (id) {
		case 1:
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				setYDirection(0);
				break;
			case KeyEvent.VK_S:
				setYDirection(0);
				break;
			} break;
		case 2:
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				setYDirection(0);
				break;
			case KeyEvent.VK_DOWN:
				setYDirection(0);
				break;
			} break;
		}
	}
	
	public void setYDirection(int yDirection) {
		yVel = yDirection;
	}
	
	public void move() {
		y += yVel;
	}
	
	public void draw(Graphics g) {
		if (id==1) {
			g.setColor(Color.cyan);
		} else {
			g.setColor(Color.red);
		}
		g.fillRect(x,y,width,height);
	}
}
