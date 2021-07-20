package gui_tutorial_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyFrame22 extends JFrame {
	MyPanel panel;
	MyFrame22() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MyPanel();
		this.add(panel);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	private class MyPanel extends JPanel implements ActionListener {
		
		final int PANEL_WIDTH = 500;
		final int PANEL_HEIGHT = 500;
		Image face, bg;
		Timer timer;
		int xVel=2, yVel=5;
		int x=0, y=0;
		
		MyPanel() {
			this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			this.setBackground(Color.black);
			face = new ImageIcon("smiley.png").getImage();
			bg = new ImageIcon("bg1.png").getImage();
			timer = new Timer(10, this);
			timer.start();
		}

		public void paint(Graphics g) {
			super.paint(g);
			
			Graphics2D g2D = (Graphics2D) g;
			g2D.drawImage(bg, 0, 0, null);
			g2D.drawImage(face, x, y, null);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (x>=(PANEL_WIDTH-face.getWidth(null)) || x<0) {xVel *= -1;}
			x = x + xVel;
			if (y>=(PANEL_HEIGHT-face.getHeight(null)) || y<0) {yVel *= -1;}
			y = y + yVel;
			repaint();
		}
	}
}
