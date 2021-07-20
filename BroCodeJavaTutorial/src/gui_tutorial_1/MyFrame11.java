package gui_tutorial_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MyFrame11 extends JFrame implements ActionListener {
	
	JComboBox<String> comboBox;
	
	MyFrame11() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		String[] animals = {
				"dog",
				"cat",
				"bird",
		};
		comboBox = new JComboBox(animals);
		System.out.println(comboBox.getItemCount());
		comboBox.setEditable(true);
		comboBox.addItem("horse");
		comboBox.insertItemAt("pizza", 1);
		comboBox.setSelectedIndex(2);
//		comboBox.removeItem("cat");
//		comboBox.removeItemAt(0);
//		comboBox.removeAllItems();
		comboBox.addActionListener(this);
		
		this.add(comboBox);
		
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			System.out.println(comboBox.getSelectedIndex()+" "+comboBox.getSelectedItem());
		}
	}

}

