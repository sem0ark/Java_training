package gui_tutorial_1;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class MyFrame20 {
	
	JFrame frame;
	JLabel label;
	Action upAction, downAction, leftAction, rightAction;
	
	MyFrame20() {
		frame = new JFrame("KeyBindin demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);

		label = new JLabel();
		label.setBackground(Color.red);
		label.setBounds(100,100,100,100);
		label.setOpaque(true);
		frame.add(label);
		
		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();
		
		label.getInputMap().put(KeyStroke.getKeyStroke("w"), "upAction");
		label.getInputMap().put(KeyStroke.getKeyStroke("s"), "downAction");
		label.getInputMap().put(KeyStroke.getKeyStroke("a"), "leftAction");
		label.getInputMap().put(KeyStroke.getKeyStroke("d"), "rightAction");
		
		label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
		label.getActionMap().put("upAction", upAction);
		label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
		label.getActionMap().put("downAction", downAction);
		label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		label.getActionMap().put("leftAction", leftAction);
		label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		label.getActionMap().put("rightAction", rightAction);
		
		
		frame.setVisible(true);
	}
	
	public class UpAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY()-10);
		}
		
	}
	
	public class DownAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY()+10);
		}
		
	}
	
	public class LeftAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()-10, label.getY());
		}
		
	}
	
	public class RightAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()+10, label.getY());
		}
		
	}
}
