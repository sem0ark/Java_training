package gui_tutorial_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyFrame10 extends JFrame implements ActionListener {
	
	JRadioButton pizzaButton, hamburgerButton, hotdogButton;
	ImageIcon icon1;
	
	MyFrame10() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		pizzaButton = new JRadioButton("pizza");
		hamburgerButton = new JRadioButton("hamburger");
		hotdogButton = new JRadioButton("hotdog");
		
		icon1 = new ImageIcon("owl_3.png");
		pizzaButton.setIcon(icon1);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(pizzaButton);
		group.add(hamburgerButton);
		group.add(hotdogButton);
		
		pizzaButton.addActionListener(this);
		hamburgerButton.addActionListener(this);
		hotdogButton.addActionListener(this);
		
		this.add(pizzaButton);
		this.add(hamburgerButton);
		this.add(hotdogButton);
		
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pizzaButton) {
			System.out.println("You ordered pizza!");
		} else if(e.getSource() == hamburgerButton) {
			System.out.println("You ordered hotdog!");
		} else if(e.getSource() == hotdogButton) {
			System.out.println("You ordered hotdog!");
		}
		
	}

}
