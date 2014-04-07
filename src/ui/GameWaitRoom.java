package ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameWaitRoom extends MainFrame {
	private JLabel waitingRoomLabel, background;
	private WaitingPlayerJPanel waitingPlayerPanel;
	private WaitingRoomChatJPanel waitingRoomChatJPanel;

	public GameWaitRoom() {
		// TODO Auto-generated constructor stub
		initJLabel();
		initPanel();
		initBackground();
		initBound();
		setComponentFont();
		revalidate();
		repaint();
	}

	private void initBackground() {
		background = new JLabel(new ImageIcon("c:/04.png"));
		add(background);
	}

	private void setComponentFont() {
		waitingRoomLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
	}

	private void initBound() {
		waitingRoomLabel.setBounds((getWidth() + 16) / 2 - 75, 20, 150, 50);
		background.setBounds(0, 0, getWidth(), getHeight());
	}

	private void initJLabel() {
		waitingRoomLabel = new JLabel("等待大廳");
		add(waitingRoomLabel);
	}

	private void initPanel() {
		int remainSpaceX = getWidth() - 50 - 50 - 66;
		waitingPlayerPanel = new WaitingPlayerJPanel(50, 75, remainSpaceX * 2 / 3, 600);
		waitingPlayerPanel.setOpaque(false);
		add(waitingPlayerPanel);

		waitingRoomChatJPanel = new WaitingRoomChatJPanel(100 + waitingPlayerPanel.getWidth(), 75, remainSpaceX * 1 / 3, 600);
		waitingRoomChatJPanel.setOpaque(false);
		add(waitingRoomChatJPanel);
	}
}
