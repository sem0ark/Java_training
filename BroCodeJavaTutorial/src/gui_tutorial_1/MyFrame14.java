package gui_tutorial_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame14 extends JFrame implements ActionListener {
	
	JMenuBar menuBar;
	JMenu fileMenu, editMenu, helpMenu;
	JMenuItem loadItem, saveItem, exitItem;
	ImageIcon icon;
	
	MyFrame14() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");
		
		icon = new ImageIcon("owl_3.png");
		
		loadItem = new JMenuItem("Load");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		loadItem.setIcon(icon);
		
		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f for load
		editMenu.setMnemonic(KeyEvent.VK_E); // Alt + e for save
		helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h for exit
		
		loadItem.setMnemonic(KeyEvent.VK_L); // l for load
		saveItem.setMnemonic(KeyEvent.VK_S); // s for save
		exitItem.setMnemonic(KeyEvent.VK_E); // e for exit
		
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadItem) {
			System.out.println("Loading file");
		} else if (e.getSource() == saveItem) {
			System.out.println("Saving file");
		} else if (e.getSource() == exitItem) {
			System.exit(0);
		}
	}
	
	private void loadFile() {
		System.out.println("Hello");
	}

}
