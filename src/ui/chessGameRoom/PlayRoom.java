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
		add(readyBtn);//add到PlayRoom
	}

	private void initBackground() {
		background = new JLabel(new ImageIcon("c:/sqa/04.png"));//加入背景圖片
		add(background);
	}
	//設定Panel
	private void initJPanel() {
		playerInfo = new PlayerInfoJPanel(getWidth() /30, getHeight() /90 *62, (getWidth() - getWidth() /10) * 2 / 3, getHeight() /9 *2);
		add(playerInfo);
		chatArea = new ChatJPanel(getWidth() - (getWidth() - getWidth() /50) / 3, getHeight() /9 *3, (getWidth() - getWidth() /60 *7) / 3, getHeight() /90 *52);
		add(chatArea);
	}

	private void initChessBoard() {
		chessBoard = new TaiwanChessBoard(getWidth() /30, getHeight() /90 *14, (getWidth() - getWidth() /10) * 2 / 3, getHeight() /2);
		add(chessBoard);
	}

	private void initBound() {
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
		backWatitingRoomBtn.setBounds(getWidth() - (getWidth() - getWidth() / 50) / 3, getHeight() /90 *14, getWidth() /10, getHeight() /90 *8);
		readyBtn.setBounds(getWidth() - getWidth() /15 *2, getHeight() /90 *14, getWidth() /10, getHeight() /90 *8);
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
