package gui_tutorial_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame8 extends JFrame implements ActionListener {
	JButton button1 = new JButton("Submit");
	JTextField textField = new JTextField();
	
	MyFrame8() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button1.setFocusable(false);
		button1.addActionListener(this);
		this.add(button1);
		
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(new Font("Consolas", Font.PLAIN, 20));
		textField.setForeground(new Color(0x00ff00));
		textField.setBackground(Color.DARK_GRAY);
		textField.setCaretColor(Color.WHITE);
		textField.setText("Username");
//		textField.setEditable(false);
		this.add(textField);
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			String text = textField.getText();
			System.out.println("Welcome, " + text + "!");
			textField.setEditable(false);
			button1.setEnabled(false);
		}
	}
}
