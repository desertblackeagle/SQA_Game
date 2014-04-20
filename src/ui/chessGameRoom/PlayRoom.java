package ui.chessGameRoom;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import ui.ChatJPanel;
import ui.MainFrame;

public class PlayRoom extends MainFrame {
	private JLabel background;
	private PlayerInfoJPanel playerInfo;
	private TaiwanChessBoard chessBoard;
	private ChatJPanel chatArea;
	private JButton backWatitingRoomBtn, readyBtn;

	public PlayRoom() {
		// TODO Auto-generated constructor stub
		initChessBoard();
		initJPanel();
		initJButton();

		initBackground();
		initBound();
		initLocation();
		setComponentFont();
		revalidate();
		repaint();
	}

	// init Component //
	
	private void setComponentFont() {
		backWatitingRoomBtn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		readyBtn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	}
	
	private void initJButton() {
		backWatitingRoomBtn = new JButton("回到大廳");
		add(backWatitingRoomBtn);
		readyBtn = new JButton("Ready");
		add(readyBtn);
	}

	private void initBackground() {
		background = new JLabel(new ImageIcon("c:/sqa/04.png"));
		add(background);
	}

	private void initJPanel() {
		playerInfo = new PlayerInfoJPanel(50, 620, (getWidth() - 150) * 2 / 3, 200);
		add(playerInfo);
		chatArea = new ChatJPanel(getWidth() - (getWidth() - 30) / 3, 300, (getWidth() - 175) / 3, 520);
		add(chatArea);
	}

	private void initChessBoard() {
		chessBoard = new TaiwanChessBoard(50, 140, (getWidth() - 150) * 2 / 3, 450);
		add(chessBoard);
	}

	private void initBound() {
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
		backWatitingRoomBtn.setBounds(getWidth() - (getWidth() - 30) / 3, 140, 150, 80);
		readyBtn.setBounds(getWidth() - 200, 140, 150, 80);
	}

	private void initLocation() {
//		chessBoard.setLocation(50, 185);
	}
	
	// init Component end //
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayRoom p = new PlayRoom();
	}

}
