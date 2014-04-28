package ui.chessGameRoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfoJPanel extends JPanel {

	private JLabel playerAScore, playerBScore, playerAPhoto, playerBPhoto, forWhoToPlay, playerAName, playerBName;
	private ImageIcon defaultPlayerAPhoto, defaultPlayerBPhoto;

	public PlayerInfoJPanel(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		setLayout(null);
		setOpaque(false);
		initImageIcon();
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
		defaultPlayerAPhoto = new ImageIcon("c:/sqa/playerAPhoto.jpg");
		defaultPlayerBPhoto = new ImageIcon("c:/sqa/playerBPhoto.jpg");
	}

	private void initJLabel() {
		playerAScore = new JLabel("0分");
		playerAScore.setForeground(Color.red);
		add(playerAScore);

		playerBScore = new JLabel("0分", JLabel.RIGHT);
		playerBScore.setForeground(Color.red);
		add(playerBScore);

		playerAPhoto = new JLabel();
		playerAPhoto.setSize((getWidth() - 20) / 4, (getWidth() - 20) / 4);
		defaultPlayerAPhoto.setImage(defaultPlayerAPhoto.getImage().getScaledInstance(playerAPhoto.getWidth(), playerAPhoto.getHeight(), Image.SCALE_DEFAULT));//設定圖片的顯示
		playerAPhoto.setIcon(defaultPlayerAPhoto);
		add(playerAPhoto);

		playerBPhoto = new JLabel();
		playerBPhoto.setSize((getWidth() - 20) / 4, (getWidth() - 20) / 4);
		defaultPlayerBPhoto.setImage(defaultPlayerBPhoto.getImage().getScaledInstance(playerBPhoto.getWidth(), playerBPhoto.getHeight(), Image.SCALE_DEFAULT));
		playerBPhoto.setIcon(defaultPlayerBPhoto);
		add(playerBPhoto);

		forWhoToPlay = new JLabel("----------------");
		forWhoToPlay.setForeground(Color.red);
		add(forWhoToPlay);

		playerAName = new JLabel("PlayerA");
		playerAName.setBackground(Color.red);
		playerAName.setOpaque(true);
		add(playerAName);

		playerBName = new JLabel("PlayerB", JLabel.RIGHT);
		playerBName.setBackground(Color.red);
		playerBName.setOpaque(true);
		add(playerBName);
	}
		 
	private void initBound() { 
		playerAScore.setBounds(getWidth() / 2 - getWidth()*9/45, getHeight()*2/5, getWidth()/10, getHeight()/4);
		playerBScore.setBounds(getWidth() / 2 + getWidth()/10, getHeight()*2/5, getWidth()/10, getHeight()/4);
		forWhoToPlay.setBounds(getWidth() / 2 - getWidth()/10, 0, getWidth()/4, getHeight()/4);
		playerAName.setBounds((getWidth() - 20) / 4 , getHeight() - getHeight()/4, getWidth()/5, getHeight()/4);
		playerBName.setBounds(getWidth() - (getWidth() - 20) / 4 - getWidth()/5, getHeight() - getHeight()/4, getWidth()/5, getHeight()/4);
	}

	private void initLocation() {
		playerAPhoto.setLocation(0, 0);
		playerBPhoto.setLocation(getWidth() - (getWidth() - 20) / 4, 0);
	}
	
	// init Component end //
	
	// API//
	
	
	
	// API end //
	
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
