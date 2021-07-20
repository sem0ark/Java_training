package gui_tutorial_1;

import javax.swing.JFrame;

public class MyFrame19 extends JFrame {
	
	DragPanel19 dragPanel;
	
	MyFrame19() {
	
		this.setTitle("Drag and Drop demo");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dragPanel = new DragPanel19();
		this.add(dragPanel);
		
		this.setVisible(true);
	}
}
