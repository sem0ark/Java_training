package gui_tutorial_1;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DragPanel19 extends JPanel {
	
	ImageIcon icon = new ImageIcon("smiley.png");
	final int WIDTH = icon.getIconWidth();
	final int HEIGHT = icon.getIconHeight();
	Point imageCorner;
	Point prevPt;
	
	DragPanel19() {
		imageCorner = new Point(0,0);
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		icon.paintIcon(this,  g, (int) imageCorner.getX(), (int) imageCorner.getY());
	}
	
	private class ClickListener extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			prevPt = e.getPoint();
		}
	}
	
	private class DragListener extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			Point currentPt = e.getPoint();
			imageCorner.translate(
					(int) (currentPt.getX() - prevPt.getX()),
					(int) (currentPt.getY() - prevPt.getY())
					);
			prevPt = currentPt;
			repaint();
		}
	}
}
