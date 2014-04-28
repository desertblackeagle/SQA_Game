package ui.chessGameRoom;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton leaveBtn, readyBtn;
	private ImageIcon backgroundPhoto;

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
		leaveBtn.setFont(new Font(Font.DIALOG, Font.BOLD, getHeight()/40));
		//readyBtn.setFont(new Font(Font.DIALOG, Font.BOLD, getHeight()/40));
	}
	
	private void initJButton() {
		leaveBtn = new JButton("離開");
		leaveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(leaveBtn);
//		readyBtn = new JButton("Ready");
//		add(readyBtn);//add到PlayRoom
	}

	private void initBackground() { //加入背景圖片
		backgroundPhoto = new ImageIcon("c:/sqa/04.png");
		background = new JLabel();
		backgroundPhoto.setImage(backgroundPhoto.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));//設定圖片的顯示
		background.setIcon(backgroundPhoto);
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
		leaveBtn.setBounds(getWidth() - (getWidth() - getWidth() / 50) / 3, getHeight() /90 *14, getWidth() /10, getHeight() /90 *8);
//		readyBtn.setBounds(getWidth() - getWidth() /15 *2, getHeight() /90 *14, getWidth() /10, getHeight() /90 *8);
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
