package gui_tutorial_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame1 extends JFrame implements ActionListener{
//public class MyFrame1 extends JFrame{
	JButton button;
	JLabel label;
	
	MyFrame1() {
		ImageIcon img = new ImageIcon("owl_3.png");
		
		label = new JLabel();
		label.setBounds(125, 200, 150, 150);
		label.setVisible(false);
		this.add(label);
		
		button = new JButton();
		button.setBounds(125, 100, 250, 100);
		button.setText("Hello");
		button.setFocusable(false);
//		button.addActionListener((e) -> System.out.println("Hello"));
		button.addActionListener(this);
		button.setIcon(img);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic Sans", Font.BOLD, 20));
		button.setIconTextGap(-5);
		button.setForeground(Color.green);
		button.setBackground(Color.lightGray);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setEnabled(true);
		this.add(button);
		
		this.setSize(500, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("Hello");
			label.setText("clicked");
			label.setVisible(true);
			button.setEnabled(false);
		}
	}
}
