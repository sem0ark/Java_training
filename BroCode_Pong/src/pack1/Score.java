package pack1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle {
	private static final long serialVersionUID = 1711702853896056826L;
	
	static int GAME_WIDTH, GAME_HEIGHT;
	int player1, player2;
	
	Score(int w, int h) {
		Score.GAME_WIDTH  = w;
		Score.GAME_HEIGHT = h;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN, 40));
		
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		
		g.drawString("" + player1/10 + player1%10, GAME_WIDTH/2 - 82, 50);
		g.drawString("" + player2/10 + player2%10, GAME_WIDTH/2 + 42, 50);
	}
}
