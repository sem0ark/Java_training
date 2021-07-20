package gui_tutorial_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MyFrame13 {
	JFrame frame;
	JProgressBar bar;
	
	MyFrame13() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(420, 420));
		frame.setLayout(null);
		
		bar = new JProgressBar(0,500);
		bar.setValue(0);
		bar.setBounds(0,0,420,50);
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli", Font.PLAIN, 25));
		bar.setForeground(Color.red);
		bar.setBackground(Color.black);
		
		frame.add(bar);
		
		frame.setVisible(true);
		
		fillBar();
	}
	
	public void fillBar() {
		int c = bar.getMaximum();
		
		while (c>0) {
			bar.setValue(c--);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		bar.setString("X(");
	}
}
