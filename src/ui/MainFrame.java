package ui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		// TODO Auto-generated constructor stub
<<<<<<< HEAD
		setSize(1000, 600);
=======
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(screenSize.getWidth()/1.2), (int)(screenSize.getHeight()/1.2));
>>>>>>> refs/remotes/origin/master
		setVisible(true);
		setLayout(null);
//		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
