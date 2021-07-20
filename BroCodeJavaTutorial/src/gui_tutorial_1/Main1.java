package gui_tutorial_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main1 {

	public static void main(String[] args) {
		t10();
	}

	public static void t1() {
		JFrame frame = new JFrame();
		ImageIcon img = new ImageIcon("owl_3.png");

		frame.setTitle("JFrame title goes here");
		frame.setIconImage(img.getImage());
		frame.setSize(420, 420);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(0x123456));
	}

	public static void t2() {
		new myFrame();
	}

	public static void t3() {
		ImageIcon img = new ImageIcon("owl_3.png");

		Border border = BorderFactory.createLineBorder(Color.green);

		JLabel label = new JLabel(); // can set text instantly new JLabel("text");
		label.setText("Hello! How is it going?");
		label.setIcon(img);
		label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of image icon
		label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of image icon

		label.setBorder(border);
		label.setForeground(Color.cyan);
		label.setFont(new Font("MV Boli", Font.PLAIN, 10)); // set font of text
		label.setIconTextGap(10); // set gap of text to image
		label.setBackground(Color.black);
		label.setOpaque(true);

		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

//		label.setBounds(100, 0, 250, 250); // set dimensions

		JFrame frame = new JFrame();
//		frame.setLayout(null);
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(label);

		frame.pack();

		frame.setVisible(true);
	}

	public static void t4() {
		ImageIcon img = new ImageIcon("owl_3.png");
		JLabel label = new JLabel();
		label.setText("Hi");
		label.setIcon(img);
//		label.setVerticalAlignment(JLabel.BOTTOM);
//		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setBounds(0, 0, 100, 100);

		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0, 0, 150, 150);
//		redPanel.setLayout(new BorderLayout());
		redPanel.setLayout(null);

		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(150, 0, 150, 150);
//		bluePanel.setLayout(new BorderLayout());
		bluePanel.setLayout(null);

		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0, 150, 300, 150);
		greenPanel.setLayout(new BorderLayout());
//		greenPanel.setLayout(null);

		DefaultFrame frame = new DefaultFrame();
		frame.setLayout(null);

		frame.add(redPanel);
		frame.add(bluePanel);
		frame.add(greenPanel);

		redPanel.add(label);
//		bluePanel.add(label);
//		greenPanel.add(label);
	}

	public static void t5() {
		new MyFrame1();
	}

	public static void t6() {
		new MyFrame2();
	}

	public static void t7() {
		new MyFrame3();
	}

	public static void t8() {
		new MyFrame4();
	}

	public static void t9() {
		new MyFrame5();
	}

	public static void t10() {
		new LaunchPage();
	}

	public static void t11() {
		new MyFrame7();
	}

	public static void t12() {
		new MyFrame8();
	}

	public static void t13() {
		new MyFrame9();
	}

	public static void t14() {
		new MyFrame10();
	}

	public static void t15() {
		new MyFrame11();
	}

	public static void t16() {
		new MyFrame12();
	}

	public static void t17() {
		new MyFrame13();
	}

	public static void t18() {
		new MyFrame14();
	}

	public static void t19() {
		new MyFrame15();
	}

	public static void t20() {
		new MyFrame16();
	}

	public static void t21() {
		new MyFrame17();
	}

	public static void t22() {
		new MyFrame18();
	}
	
	public static void t23() {
		new MyFrame19();
	}

	public static void t24() {
		new MyFrame20();
	}

	public static void t25() {
		new MyFrame21();
	}

	public static void t26() {
		new MyFrame22();
	}
}
