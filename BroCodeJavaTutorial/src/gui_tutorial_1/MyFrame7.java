package gui_tutorial_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame7 implements ActionListener {
	JFrame frame = new JFrame();
	JButton button = new JButton("show dialog");
	
	MyFrame7() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		
		button.setBounds(100,160,200,40);
		button.setFocusable(false);
		button.addActionListener(this);
		
		frame.add(button);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
//			JOptionPane.showMessageDialog(null, "This is some useless info", "title", JOptionPane.PLAIN_MESSAGE);
//			JOptionPane.showMessageDialog(null, "This is even more useless info", "title", JOptionPane.INFORMATION_MESSAGE);
//			JOptionPane.showMessageDialog(null, "Is this some useless info?", "title", JOptionPane.QUESTION_MESSAGE);
//			JOptionPane.showMessageDialog(null, "This is some useless info", "title", JOptionPane.WARNING_MESSAGE);
//			JOptionPane.showMessageDialog(null, "Smth went wrong.", "title", JOptionPane.ERROR_MESSAGE);
			
//			int answer = JOptionPane.showConfirmDialog(null, "bro do you even code?",
//					"This is my title", JOptionPane.YES_NO_CANCEL_OPTION);
//			String name = JOptionPane.showInputDialog("What is your name?");
			
			String[] responses = {
					"No ,you are awesome!",
					"Thank you!",
					"*blush*",
			};
			ImageIcon img = new ImageIcon("owl_3.png");
			JOptionPane.showOptionDialog(null,
					"You are awesome!",
					"secret message",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					img, responses, null);
		}
		
	}
}
