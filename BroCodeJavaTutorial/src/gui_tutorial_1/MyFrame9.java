package gui_tutorial_1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyFrame9 extends JFrame implements ActionListener{
	JCheckBox checkBox;
	JButton button;
	
	MyFrame9() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		checkBox = new JCheckBox();
		button = new JButton();
		
		button.setFocusable(false);
		button.setText("Submit");
		button.addActionListener(this);
		
		ImageIcon xIcon 	= new ImageIcon("not_smiley.png");
		ImageIcon checkIcon = new ImageIcon("smiley.png");
		
		checkBox.setText("I'm not a robot.");
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));
		checkBox.setIcon(xIcon);
		checkBox.setSelectedIcon(checkIcon);
		
		this.add(button);
		this.add(checkBox);
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			boolean fg = checkBox.isSelected();
			System.out.println(fg);
		}
		
	}
}
