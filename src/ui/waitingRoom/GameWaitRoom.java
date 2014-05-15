package ui.waitingRoom;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import ui.ChatPanel;
import ui.MainFrame;

public class GameWaitRoom extends MainFrame {
	private JLabel waitingRoomLabel, background;
	private WaitingPlayerJPanel waitingPlayerPanel;
	private ChatPanel waitingRoomChatJPanel;
	private JButton leave;

	public GameWaitRoom() {
		// TODO Auto-generated constructor stub
		initJLabel();
		initPanel();
		initJButton();
		initBackground();
		initBound();
		setComponentFont();      
		revalidate();
		repaint();
		testDrive();
		
		//五秒後更新等待清單為9 模擬若選擇的玩家更新後不再等待清單之狀況
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] a = new String[1];
				a[0] = "9";
				waitingPlayerPanel.updateWaitingPlayerList(a);
			}
		});
//		t.start();
	}

	// Test Drive //

	private void testDrive() {
		String[] waitingPlayerList = new String[5];
		for (int i = 0; i < 5; i++) {
			waitingPlayerList[i] = String.valueOf(i + 1);
		}
		waitingPlayerPanel.updateWaitingPlayerList(waitingPlayerList);

		waitingRoomChatJPanel.appendChatArea("凡凡:我是阿呆凡");
		waitingRoomChatJPanel.appendChatArea("斑比:我是呆比");
		
	}

	// Test Drive end //

	// init Component //

	private void initJButton() {
		leave = new JButton("離開");
		leave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(leave);
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
		leave.setBounds(getWidth() - 175, 700, 100, 50);
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

//		waitingRoomChatJPanel = new ChatPanel(100 + waitingPlayerPanel.getWidth(), 75, remainSpaceX * 1 / 3, 600);
		waitingRoomChatJPanel.setOpaque(false);
		add(waitingRoomChatJPanel);
	}

	// init Component end //
}
