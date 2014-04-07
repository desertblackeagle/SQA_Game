package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitingPlayerInfoJPanel extends JPanel {
	private JLabel playerPhoto;
	private JPanel playerInfo;
	private JButton challenge;

	public WaitingPlayerInfoJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		initJLabel();
		initJPanel();
		initJButton();
//		JLabel o = new JLabel(new ImageIcon("c:/a.jpg"));
//		o.setBounds(0, 0, getWidth(), getHeight());
//		add(o);
	}

	private void initJLabel() {
		playerPhoto = new JLabel();
		playerPhoto.setBounds(0, 0, getWidth(), getHeight() * 5 / 6);
		add(playerPhoto);
	}

	private void initJPanel() {
		playerInfo = new JPanel();
		playerInfo.setLayout(null);
		playerInfo.setBounds(0, getHeight() * 5 / 6, getWidth(), getHeight() / 6);
		add(playerInfo);
	}

	private void initJButton() {
		challenge = new JButton("挑戰");
		challenge.setBounds(playerInfo.getWidth() * 4 / 5, 0, playerInfo.getWidth() / 5, playerInfo.getHeight());
		playerInfo.add(challenge);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
		((Graphics2D) g).drawLine(0, getHeight() * 5 / 6 - 2, getWidth(), getHeight() * 5 / 6 - 2);
	}

}
