package gui_tutorial_1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame12 implements ChangeListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JSlider slider;
	
	MyFrame12() {
		frame = new JFrame("Slider Demo");
		
		panel = new JPanel();
		label = new JLabel();
		
		slider = new JSlider(0,100,50);
		slider.addChangeListener(this);
		slider.setPreferredSize(new Dimension(400,200));
		
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(25);
		
		slider.setPaintLabels(true);
		slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
		
		slider.setOrientation(SwingConstants.VERTICAL);
//		slider.setOrientation(SwingConstants.HORIZONTAL);
		
		label.setText("*C = " + slider.getValue());
		label.setFont(new Font("MV Boli", Font.PLAIN, 18));
		
		panel.add(slider);
		panel.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(420,420));
		
		frame.add(panel);
		
		frame.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		label.setText("*C = " + slider.getValue());
	}

}
