package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class WaitingPlayerJPanel extends JPanel {
	private JLabel waitingPlayerLabel;
	private JScrollPane waitingPlayerList;
	private JList<String> waitingPlayerJlist;
	private WaitingPlayerInfoJPanel waitingPlayerInfoPanel;

	public WaitingPlayerJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		initJLabel();
		initJPanel();
		initJList();
		initJScrollPane();
		setComponentFont();
	}

	private void setComponentFont() {
		waitingPlayerLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		waitingPlayerJlist.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
	}

	private void initJLabel() {
		waitingPlayerLabel = new JLabel("等待中玩家");
		waitingPlayerLabel.setBounds(190, 0, getWidth(), 75);
		add(waitingPlayerLabel);
	}

	private void initJList() {
		waitingPlayerJlist = new JList<String>();
		String[] sa = new String[1];
		sa[0] = "123";
		waitingPlayerJlist.setListData(sa);
	}

	private void initJScrollPane() {
		waitingPlayerList = new JScrollPane();
		waitingPlayerList.setBackground(Color.black);
		waitingPlayerList.getViewport().setView(waitingPlayerJlist);
		waitingPlayerList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		waitingPlayerList.setBounds(0, waitingPlayerLabel.getHeight(), getWidth() / 2, getHeight() - waitingPlayerLabel.getHeight());
		add(waitingPlayerList);

	}

	private void initJPanel() {
		waitingPlayerInfoPanel = new WaitingPlayerInfoJPanel(getWidth() / 2, waitingPlayerLabel.getHeight(), getWidth() / 2, getHeight() - waitingPlayerLabel.getHeight());
		waitingPlayerInfoPanel.setBackground(Color.black);
		add(waitingPlayerInfoPanel);
	}
}
