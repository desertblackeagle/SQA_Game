package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import rmi.GameClient;

public class ChatPanel extends JPanel {
	
	private JTextArea chatInputArea, chatTextArea;
	private JScrollPane chatScrollPanel;
	private String localPlayerName = "";
	private Thread updateChat;
	private GameClient server;

	public ChatPanel(int locationX, int locationY, int width, int height, GameClient server) {
		// TODO Auto-generated constructor stub
		this.server = server;
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		initJTextArea();
		initScrollPane();
		setComponentFont();
		updateChat();
	}

	// init Component //

	private void setComponentFont() {
		chatInputArea.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		chatTextArea.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	}

	private void initJTextArea() {

//		chatTextArea = new JTextArea();
//		chatInputArea = new JTextArea();
		// 聊天室顯示框
		chatTextArea = new JTextArea();
		chatTextArea.setEditable(false);
		chatTextArea.setLineWrap(true);
		// 聊天室輸入框
		chatInputArea = new JTextArea();
		chatInputArea.setLineWrap(true);
		LineBorder tt = new LineBorder(Color.BLACK);
		chatInputArea.setBorder(tt);
		
		chatInputArea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}

			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					// call socket to send the message
//					System.out.println(chatInputArea.getText());
//					chatInputArea.setText("");
					System.out.println(chatInputArea.getText().replace("\n", ""));
					chatTextArea.append(localPlayerName + " >" + chatInputArea.getText().replace("\n", "") + "\n");
					chatTextArea.setCaretPosition(chatTextArea.getText().length());
					//call server chat start
					
					//call server chat end
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
	
	public String getLocalPlayerName() {
		return localPlayerName;
	}

	public void setLocalPlayerName(String localPlayerName) {
		this.localPlayerName = localPlayerName;
	}

	// API end //
	
	private void updateChat() {
		updateChat = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						Thread.sleep(100);
						// update chat start
						if (server.s.hasNewMsg(server.getRoom())) {
							appendChatArea(server.s.updateChat(server.getRoom()));
						}
						// update chat end
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		updateChat.start();
	}
}
