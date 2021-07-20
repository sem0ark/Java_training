package gui_tutorial_1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DefaultFrame extends JFrame{
	DefaultFrame() {
		ImageIcon img = new ImageIcon("owl_3.png");
		this.setIconImage(img.getImage());
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
