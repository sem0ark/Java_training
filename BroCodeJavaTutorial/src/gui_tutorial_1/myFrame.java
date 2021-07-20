package gui_tutorial_1;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class myFrame extends JFrame{

	myFrame() {
		this.setTitle("JFrame title goes here");
		ImageIcon img = new ImageIcon("owl_3.png");
		this.setIconImage(img.getImage());
		this.setSize(420, 420);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(0x123456));
	}
}
