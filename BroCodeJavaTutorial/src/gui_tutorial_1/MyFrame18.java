package gui_tutorial_1;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame18 extends JFrame implements MouseListener {
	
	JLabel label;
	ImageIcon icon;
	
	MyFrame18() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		
		icon = new ImageIcon("owl_3.png");
		
		label = new JLabel();
		label.setBounds(0,0,100,100);
		label.setBackground(Color.red);
		label.setOpaque(true);
		label.addMouseListener(this);
//		this.addMouseListener(this);
		
		this.add(label);
		
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// mouse pressed and released on the component
//		System.out.println("you clicked the mouse");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// mouse pressed on the component
//		System.out.println("you pressed the mouse");
		label.setBackground(Color.yellow);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// mouse has been released on a component
//		System.out.println("you released the mouse");
		label.setBackground(Color.green);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// mouse entered a component
//		System.out.println("you entered the component");
		label.setBackground(Color.blue);
		label.setIcon(icon);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// mouse exited a component
//		System.out.println("you exited the component");
		label.setBackground(Color.red);
		label.setIcon(null);
	}
}
