package ui.playRoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.player.Player;

public class PlayerInfoJPanel extends JPanel {

	private JLabel playerAScore, playerBScore, playerAPhoto, playerBPhoto, forWhoToPlay, playerAName, playerBName;
	private ImageIcon defaultPlayerAPhoto, defaultPlayerBPhoto;
	private Player playerA, playerB;
	private Thread updateScore;

	public PlayerInfoJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		setOpaque(false);
		initImageIcon();
		initPlayer();
		initJLabel();
		initBound();
		initLocation();
		setComponentFont();
	}

	// init Component //
	
	private void setComponentFont() {
		playerAScore.setFont(new Font(Font.DIALOG, Font.BOLD, getHeight()*7/40));
		playerBScore.setFont(new Font(Font.DIALOG, Font.BOLD, getHeight()*7/40));
		forWhoToPlay.setFont(new Font(Font.DIALOG, Font.BOLD, getHeight()*7/40));
		playerAName.setFont(new Font(Font.DIALOG, Font.BOLD, getHeight()*7/40));
		playerBName.setFont(new Font(Font.DIALOG, Font.BOLD, getHeight()*7/40));
	}

	private void initImageIcon() {
		defaultPlayerAPhoto = new ImageIcon(getClass().getResource("/Image/playerAPhoto.jpg"));
		defaultPlayerBPhoto = new ImageIcon(getClass().getResource("/Image/playerBPhoto.jpg"));
	}
	
	private void initPlayer() {
		playerA = new Player("playerA", defaultPlayerAPhoto, -1, 0);
		playerB = new Player("playerB", defaultPlayerBPhoto, -1, 0);
	}
	
	private void initJLabel() {
		playerAScore = new JLabel(playerA.getScore() + "分");
		playerAScore.setForeground(Color.red);
		add(playerAScore);

		playerBScore = new JLabel(playerB.getScore() + "分", JLabel.RIGHT);
		playerBScore.setForeground(Color.red);
		add(playerBScore);

		playerAPhoto = new JLabel();
		playerAPhoto.setSize((getWidth() - 20) / 4, (getWidth() - 20) / 4);
		playerA.getPhoto().setImage(playerA.getPhoto().getImage().getScaledInstance(playerAPhoto.getWidth(), playerAPhoto.getHeight(), Image.SCALE_DEFAULT));//設定圖片的顯示
		playerAPhoto.setIcon(playerA.getPhoto());
		add(playerAPhoto);

		playerBPhoto = new JLabel();
		playerBPhoto.setSize((getWidth() - 20) / 4, (getWidth() - 20) / 4);
		playerB.getPhoto().setImage(playerB.getPhoto().getImage().getScaledInstance(playerBPhoto.getWidth(), playerBPhoto.getHeight(), Image.SCALE_DEFAULT));
		playerBPhoto.setIcon(playerB.getPhoto());
		add(playerBPhoto);

		forWhoToPlay = new JLabel("輪到你了");
		forWhoToPlay.setForeground(Color.red);
		add(forWhoToPlay);

		playerAName = new JLabel(playerA.getName());
		playerAName.setBackground(Color.red);
		playerAName.setOpaque(true);
		add(playerAName);

		playerBName = new JLabel(playerB.getName(), JLabel.RIGHT);
		playerBName.setBackground(Color.red);
		playerBName.setOpaque(true);
		add(playerBName);
	}
		 
	private void initBound() { 
		playerAScore.setBounds(getWidth() / 2 - getWidth() * 9 / 45, getHeight() * 2 / 5, getWidth() / 10, getHeight() / 4);
		playerBScore.setBounds(getWidth() / 2 + getWidth() / 10, getHeight() * 2 / 5, getWidth() / 10, getHeight() / 4);
		forWhoToPlay.setBounds(getWidth() / 2 - getWidth() / 13, 0, getWidth() / 4, getHeight() / 4);
		playerAName.setBounds((getWidth() - 20) / 4 , getHeight() - getHeight() / 4, getWidth() / 5, getHeight() / 4);
		playerBName.setBounds(getWidth() - (getWidth() - 20) / 4 - getWidth() / 5, getHeight() - getHeight() / 4, getWidth() / 5, getHeight() / 4);
	}

	private void initLocation() {
		playerAPhoto.setLocation(0, 0);
		playerBPhoto.setLocation(getWidth() - (getWidth() - 20) / 4, 0);
	}
	
	// init Component end //
	
	// API//
	
	public void setplayerAName(String name) {
		this.playerAName.setText(name);
	}
	
	public void setplayerBName(String name) {
		this.playerBName.setText(name);
	}
	
	public void setPlayerAScore(String score) {
		this.playerAScore.setText(score);
	}
	
	public void setPlayerBScore(String score) {
		this.playerAScore.setText(score);
	}
	
	public void changePlay() {
		if (forWhoToPlay.getText().equals("輪到你了")) {
			forWhoToPlay.setText("等待對方");
		} else {
			forWhoToPlay.setText("輪到你了");
		}
	}
	
	public void setPlayerAPhoto(ImageIcon photo) {
		photo.setImage(photo.getImage().getScaledInstance(playerAPhoto.getWidth(), playerAPhoto.getHeight(), Image.SCALE_DEFAULT));
		playerAPhoto.setIcon(photo);
	}
	public void setPlayerBPhoto(ImageIcon photo) {
		photo.setImage(photo.getImage().getScaledInstance(playerBPhoto.getWidth(), playerBPhoto.getHeight(), Image.SCALE_DEFAULT));
		playerBPhoto.setIcon(photo);
	}
	
	// API end //
	
	private void updateChessBoard() {
		updateScore = new Thread(new Runnable() {
//		boolean turnAnother = true;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						Thread.sleep(1000 * 1);
						// update score start
						setPlayerAScore("分");
						setPlayerBScore("分");
						// update score end
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		updateScore.start();
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame f = new JFrame();
//		f.setVisible(true);
//		f.setLayout(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(900, 920);
//		PlayerInfoJPanel ccb = new PlayerInfoJPanel(0,0,f.getWidth(), f.getHeight());
//		f.add(ccb);
//	}

}
