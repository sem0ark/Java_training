package gui_tutorial_1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame21 extends JFrame {
	
	MyPanel panel; 
	
	MyFrame21() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		
		panel = new MyPanel();
		this.add(panel);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	private class MyPanel extends JPanel {
		MyPanel() {
			this.setPreferredSize(new Dimension(500,500));
		}
		
		public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			
			Image img1 = new ImageIcon("section-pass.png").getImage();
			g2D.drawImage(img1, 0, 0, null);
			
			g2D.setPaint(Color.blue);
			g2D.setStroke(new BasicStroke(5));
			g2D.drawLine(0, 0, 500, 500);
			
			g2D.setStroke(new BasicStroke(2));
			g2D.setPaint(Color.orange);
			g2D.drawRect(0, 0, 100, 200);
			g2D.fillRect(0, 0, 100, 200);
			
			g2D.setPaint(Color.cyan);
			g2D.drawOval(50,50,150,150);
			g2D.fillOval(55,55,140,140);
			
			g2D.setPaint(Color.red);
			g2D.fillArc(0, 0, 100, 100, 0, 180);
			g2D.setPaint(Color.white);
			g2D.fillArc(0, 0, 100, 100, 180, 180);
			
			int[] xs = {150,250,350};
			int[] ys = {300,150,300};
			g2D.fillPolygon(xs,ys,3);
			g2D.setPaint(Color.yellow);
			g2D.drawPolygon(xs,ys,3);
			
			g2D.setPaint(Color.green);
			g2D.setFont(new Font("Ink Free", Font.BOLD, 20));
			g2D.drawString("you are the winner!", 50, 50);
		}
	}
}
