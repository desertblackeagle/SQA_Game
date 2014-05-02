package ui.playRoom;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import control.ChessGameObservable;
import control.observer.ChessBoard;
import ui.ChatPanel;
import ui.MainFrame;


public class PlayRoom extends MainFrame {
	private JLabel background;
	private PlayerInfoJPanel playerInfo;
	private ChessBoard chessBoard;
	private ChatPanel chatArea;
	private JButton leaveBtn, readyBtn;
	private ImageIcon backgroundPhoto;
	private ChessGameObservable obs;

	public PlayRoom() {
		// TODO Auto-generated constructor stub
		obs = new ChessGameObservable();
		
		initChessBoard();
		initJPanel();
		initJButton();

		initBackground();
		initBound();
		initLocation();
		setComponentFont();
		revalidate();
		repaint();
		
		revalidate();
		repaint();
		testDrive();
	}
	
	private void testDrive() {
		changePlay();
		appendChatArea("Rose > Hello !");

		setPlayerAPhoto(new ImageIcon("C:/sqa/wallpaper/Desert.jpg"));
		setPlayerAInfoName("Rose");

		setPlayerBPhoto(new ImageIcon("C:/sqa/wallpaper/Jellyfish.jpg"));
		setPlayerBInfoName("God");
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
		backgroundPhoto = new ImageIcon(getClass().getResource("/Image/04.png"));
		background = new JLabel();
		backgroundPhoto.setImage(backgroundPhoto.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));//設定圖片的顯示
		background.setIcon(backgroundPhoto);
		add(background);
	}
	//設定Panel
	private void initJPanel() {
		playerInfo = new PlayerInfoJPanel(getWidth() /30, getHeight() /90 *62, (getWidth() - getWidth() /10) * 2 / 3, getHeight() /9 *2);
		add(playerInfo);
		chatArea = new ChatPanel(getWidth() - (getWidth() - getWidth() /50) / 3, getHeight() /9 *3, (getWidth() - getWidth() /60 *7) / 3, getHeight() /90 *52);
		add(chatArea);
	}

	private void initChessBoard() {
		chessBoard = new ChessBoard((getWidth() - getWidth() /10) * 2 / 3, getHeight() /2);
		chessBoard.setLocation(getWidth() /30, getHeight() /90 *14);
		add(chessBoard);
	}

	private void initBound() {
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
//		leaveBtn.setBounds(getWidth() - (getWidth() - getWidth() / 50) / 3, getHeight() /90 *14, getWidth() /10, getHeight() /90 *8);
//		readyBtn.setBounds(getWidth() - getWidth() /15 *2, getHeight() /90 *14, getWidth() /10, getHeight() /90 *8);
		leaveBtn.setBounds(getWidth() - getWidth() /15 *2, getHeight() /90 *14, getWidth() /10, getHeight() /90 *8);
	}

	private void initLocation() {
//		chessBoard.setLocation(50, 185);
	}
	
	// init Component end //

	
	// API //

	public void changePlay() {
		playerInfo.changePlay();
	}

	public void appendChatArea(String chatString) {
		chatArea.appendChatArea(chatString);
	}

	public void setPlayerAPhoto(ImageIcon photo) {
		playerInfo.setPlayerAPhoto(photo);
	}

	public void setPlayerBPhoto(ImageIcon photo) {
		playerInfo.setPlayerBPhoto(photo);
	}
	
	public void setPlayerAInfoName(String name) {
		chatArea.setLocalPlayerName(name);
		playerInfo.setplayerAName(name);
	}

	public void setPlayerBInfoName(String name) {
		playerInfo.setplayerBName(name);
	}

	public PlayerInfoJPanel getPlayerInfoJPanel() {
		return playerInfo;
	}

	public ChatPanel getChatPanel() {
		return chatArea;
	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	// observable //

	public void setChanged() {
		obs.setChanged();
	}

	public void addObserver(Observer observer) {
		obs.addObserver(observer);
	}

	public int countObservers() {
		return obs.countObservers();
	}

	public void deleteObserver(Observer observer) {
		obs.deleteObserver(observer);
	}

	public void deleteObservers() {
		obs.deleteObservers();
	}

	public void notifyObservers() {
		obs.notifyObservers();
	}

	public void notifyObservers(Object o) {
		obs.notifyObservers(o);
	}

	public void notifyObservers(Observer observer) {
		obs.notifyObservers(observer);
	}

	// API end //
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PlayRoom p = new PlayRoom();
//	}
	
}
