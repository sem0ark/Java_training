package gui_tutorial_1;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrameNew6 {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Hello!");
	
	MyFrameNew6() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		
		label.setBounds(0,0,100,50);
		label.setFont(new Font(null, Font.PLAIN, 20));
		frame.add(label);
		
		frame.setVisible(true);
	}

}
