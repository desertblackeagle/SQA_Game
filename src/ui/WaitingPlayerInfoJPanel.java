package ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitingPlayerInfoJPanel extends JPanel {
	private JLabel playerPhoto;
	private JPanel playerInfo;

	public WaitingPlayerInfoJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		initJLabel();
		initJPanel();
//		JLabel o = new JLabel(new ImageIcon("c:/a.jpg"));
//		o.setBounds(0, 0, getWidth(), getHeight());
//		add(o);
	}

	private void initJLabel() {
		playerPhoto = new JLabel();
		playerPhoto.setBackground(Color.black);
		playerPhoto.setBounds(0, 0, getWidth(), getHeight() * 5 / 6);
		add(playerPhoto);
	}

	private void initJPanel() {
		playerInfo = new JPanel();
		playerInfo.setBackground(Color.red);
		playerInfo.setBounds(0, getHeight() * 5 / 6, getWidth(), getHeight() / 6);
		add(playerInfo);
	}
}
