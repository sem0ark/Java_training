package gui_tutorial_1;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame17 extends JFrame implements KeyListener{
	
	JLabel label;
	
	
	MyFrame17() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		this.addKeyListener(this);
		
		ImageIcon icon = new ImageIcon("owl_3.png");
		
		label = new JLabel();
		label.setBounds(0,0,100,100);
//		label.setBackground(Color.red);
//		label.setOpaque(true);
		label.setIcon(icon);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		this.add(label);
		
		this.getContentPane().setBackground(Color.white);
		this.setLayout(null);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// invokes when a key is typed. Uses KeyChar, char output
		
//		switch (e.getKeyChar()) {
//		case 'a':
//			label.setLocation(label.getX()-10, label.getY());
//		break;
//		case 'd':
//			label.setLocation(label.getX()+10, label.getY());
//		break;
//		case 'w':
//			label.setLocation(label.getX(), label.getY()-10);
//		break;
//		case 's':
//			label.setLocation(label.getX(), label.getY()+10);
//		break;
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// invokes when a physical key is pressed. Uses KeyCode, integer output
		
		switch (e.getKeyCode()) {
		case 37:
			label.setLocation(label.getX()-10, label.getY());
		break;
		case 39:
			label.setLocation(label.getX()+10, label.getY());
		break;
		case 38:
			label.setLocation(label.getX(), label.getY()-10);
		break;
		case 40:
			label.setLocation(label.getX(), label.getY()+10);
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// called whenever button is released
		System.out.println("you released key code: " + e.getKeyCode());
		System.out.println("you released key char: " + e.getKeyChar());
	}
}
