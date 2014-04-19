package ui.waitingRoom;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class WaitingPlayerJPanel extends JPanel {
	private JLabel waitingPlayerLabel;
	private JScrollPane waitingPlayerList;
	private JList<String> waitingPlayerJlist;
	private WaitingPlayerInfoJPanel waitingPlayerInfoPanel;
	private String selectedPlayer = "";

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

	// init Component //

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
		waitingPlayerJlist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (e.getValueIsAdjusting()) {
					int index = waitingPlayerJlist.getSelectedIndex();
					System.out.println("index: " + index);
					String selectedItem = waitingPlayerJlist.getSelectedValue().toString();
					System.out.println("選擇了:" + selectedItem);
					selectedPlayer = selectedItem;
					// call waitingPlayerInfoPanel to display player info
					waitingPlayerInfoPanel.updateWaitingPlayerInfo("10", "20", "1");
					waitingPlayerInfoPanel.updateWaitingPlayerPhoto(new ImageIcon("c:/sqa/testPlayer.jpg"));
					waitingPlayerInfoPanel.setSelectedPlayer(selectedItem);
				}
			}
		});
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
		add(waitingPlayerInfoPanel);
	}

	private boolean checkSelectedPlayerExistInWaitingList(String[] waitingPlayerList, String selectedPlayer) {
		for (String player : waitingPlayerList) {
			if (player.equals(selectedPlayer)) {
				return true;
			}
		}
		return false;
	}

	// init Component end //

	// API //

	public void updateWaitingPlayerList(String[] waitingPlayerList) {
		waitingPlayerJlist.setListData(waitingPlayerList);
		if (!checkSelectedPlayerExistInWaitingList(waitingPlayerList, selectedPlayer)) {
			waitingPlayerInfoPanel.resetWaitingPlayerAllInfo();
		}
	}

	// API end //
}
