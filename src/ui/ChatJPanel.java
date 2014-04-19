package ui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatJPanel extends JPanel {
	private JTextArea chatInputArea, chatTextArea;
	private JScrollPane chatScrollPanel;

	public ChatJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		initJTextArea();
		initScrollPane();
		setComponentFont();
	}

	// init Component //

	private void setComponentFont() {
		chatInputArea.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		chatTextArea.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	}

	private void initJTextArea() {

		chatTextArea = new JTextArea();

		chatInputArea = new JTextArea();
		chatInputArea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}

			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					// call socket to send the message
					System.out.println(chatInputArea.getText());
					chatInputArea.setText("");
				}
			}
		});
		chatInputArea.setBounds(0, getHeight() * 6 / 7, getWidth(), getHeight() - getHeight() * 6 / 7);
		add(chatInputArea);
	}

	private void initScrollPane() {
		chatScrollPanel = new JScrollPane();
		chatScrollPanel.setBounds(0, 0, getWidth(), getHeight() * 6 / 7);
		chatScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		chatScrollPanel.getViewport().setView(chatTextArea);
		add(chatScrollPanel);
	}

	// init Component end //

	// API //
	
	public void appendChatArea(String chatString) {
		chatTextArea.append(chatString.replace('\n', ' ') + "\n");
	}

	// API end //
}
