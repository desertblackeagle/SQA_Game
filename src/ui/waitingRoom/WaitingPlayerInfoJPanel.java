package ui.waitingRoom;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitingPlayerInfoJPanel extends JPanel {
	private JLabel playerPhoto, playerInfo_Win, playerInfo_Lose, playerInfo_Tie;
	private JPanel playerInfo;
	private JButton challenge;
	private ImageIcon noPlayerImageIcon;
	private String playerName;

	// init Component //

	public WaitingPlayerInfoJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		initImageIcon();
		initJPanel();
		initJLabel();
		initJButton();
		setComponentFont();
	}

	private void setComponentFont() {
		playerInfo_Win.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		playerInfo_Lose.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		playerInfo_Tie.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
	}

	private void initImageIcon() {
		noPlayerImageIcon = new ImageIcon("c:/sqa/noplayer.jpg");
	}

	private void initJLabel() {
		playerInfo_Win = new JLabel("-----");
		playerInfo_Win.setBounds(50, 0, 50, 20);
		playerInfo.add(playerInfo_Win);

		playerInfo_Lose = new JLabel("-----");
		playerInfo_Lose.setBounds(50, playerInfo.getHeight() / 3, 50, 20);
		playerInfo.add(playerInfo_Lose);

		playerInfo_Tie = new JLabel("-----");
		playerInfo_Tie.setBounds(50, playerInfo.getHeight() * 2 / 3, 50, 20);
		playerInfo.add(playerInfo_Tie);

		playerPhoto = new JLabel(noPlayerImageIcon);
		playerPhoto.setBounds(0, 0, getWidth(), getHeight() * 5 / 6);
		add(playerPhoto);
	}

	private void initJPanel() {
		playerInfo = new JPanel();
		playerInfo.setLayout(null);
		playerInfo.setBounds(0, getHeight() * 5 / 6, getWidth(), getHeight() / 6);
		playerInfo.setOpaque(false);
		add(playerInfo);
	}

	private void initJButton() {
		challenge = new JButton("挑戰");
		challenge.setBounds(playerInfo.getWidth() * 4 / 5, 0, playerInfo.getWidth() / 5, playerInfo.getHeight());
		challenge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (playerInfo_Win.getText().equals("-----")) {
					System.out.println("請選擇等待玩家");
				} else {
					// challenge the player
					System.out.println("挑戰玩家 " + playerName);
				}
			}
		});
		playerInfo.add(challenge);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		((Graphics2D) g).setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		((Graphics2D) g).drawLine(0, getHeight() * 5 / 6 - 2, getWidth(), getHeight() * 5 / 6 - 2);
		((Graphics2D) g).drawString("勝 : ", 5, 455);
		((Graphics2D) g).drawString("敗 : ", 5, 485);
		((Graphics2D) g).drawString("和 : ", 5, 515);
	}

	// init Component end //

	// API//

	public void resetWaitingPlayerAllInfo() {
		playerPhoto.setIcon(noPlayerImageIcon);
		playerInfo_Win.setText("-----");
		playerInfo_Lose.setText("-----");
		playerInfo_Tie.setText("-----");
	}

	public void updateWaitingPlayerPhoto(ImageIcon icon) {
		playerPhoto.setIcon(icon);
	}

	public void updateWaitingPlayerInfo(String win, String lose, String tie) {
		playerInfo_Win.setText(win);
		playerInfo_Lose.setText(lose);
		playerInfo_Tie.setText(tie);
	}

	public void setSelectedPlayer(String player) {
		playerName = player;
	}

	// API end //
}
