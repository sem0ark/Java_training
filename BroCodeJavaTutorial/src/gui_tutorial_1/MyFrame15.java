package gui_tutorial_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyFrame15 extends JFrame implements ActionListener {

	JFileChooser fileChooser;
	JButton button1, button2;

	MyFrame15() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		button1 = new JButton("Select Open File");
		button1.addActionListener(this);

		button2 = new JButton("Select Save File");
		button2.addActionListener(this);

		this.add(button1);
		this.add(button2);

		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int res = fileChooser.showOpenDialog(null); // select file to open
			if (res == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
			}
		} else if (e.getSource() == button2) {
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int res = fileChooser.showSaveDialog(null);
			if (res == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
			}
		}
	}

}
