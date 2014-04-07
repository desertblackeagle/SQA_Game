package ui;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WaitingRoomChatJPanel extends JPanel {
	private JTextArea chatInputArea, chatTextArea;
	private JScrollPane chatScrollPanel;
	public WaitingRoomChatJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		initJTextArea();
		initScrollPane();
		setComponentFont();
	}

	private void setComponentFont() {
		chatInputArea.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
	}

	private void initJTextArea() {

		chatTextArea = new JTextArea();
//		chatTextArea.setOpaque(false);

		chatInputArea = new JTextArea();
		chatInputArea.setBounds(0, getHeight() * 6 / 7, getWidth(), getHeight() - getHeight() * 6 / 7);
		add(chatInputArea);
	}

	private void initScrollPane() {
		chatScrollPanel = new JScrollPane();
		chatScrollPanel.setBounds(0, 0, getWidth(), getHeight() * 6 / 7);
		chatScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		chatScrollPanel.getViewport().setView(chatTextArea);
//		chatTextArea.setText("45448\n\n\n\n\n\n\n\n5655555");
//		chatScrollPanel.getViewport().setOpaque(false);
//		chatScrollPanel.setOpaque(false);
		add(chatScrollPanel);

	}
}
