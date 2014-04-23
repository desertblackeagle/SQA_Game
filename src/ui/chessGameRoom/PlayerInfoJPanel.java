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
		playerAScore.setFont(new Font(Font.DIALOG, Font.BOLD, 35 *4/5));
		playerBScore.setFont(new Font(Font.DIALOG, Font.BOLD, 35 *4/5));
		forWhoToPlay.setFont(new Font(Font.DIALOG, Font.BOLD, 35 *4/5));
		playerAName.setFont(new Font(Font.DIALOG, Font.BOLD, 35 *4/5));
		playerBName.setFont(new Font(Font.DIALOG, Font.BOLD, 35 *4/5));
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
		playerAName.setBackground(Color.white);
		playerAName.setOpaque(true);
		add(playerAName);

		playerBName = new JLabel("PlayerB", JLabel.RIGHT);
		playerBName.setBackground(Color.white);
		playerBName.setOpaque(true);
		add(playerBName);
	}
		 
	private void initBound() { 
		playerAScore.setBounds(getWidth() / 2 - 175 *4/5, 75 *4/5, 100 *4/5, 50 *4/5);
		playerBScore.setBounds(getWidth() / 2 + 75 *4/5, 75 *4/5, 100 *4/5, 50 *4/5);
		forWhoToPlay.setBounds(getWidth() / 2 - 100 *4/5, 0 *4/5, 200 *4/5, 50 *4/5);
		playerAName.setBounds((getWidth() - 20) / 4 *4/5, getHeight() - 50 *4/5, 200 *4/5, 50 *4/5);
		playerBName.setBounds(getWidth() - (getWidth() - 20) / 4 - 200 *4/5, getHeight() - 50 *4/5, 200 *4/5, 50 *4/5);
	}

	private void initLocation() {
		playerAPhoto.setLocation(0, 0);
		playerBPhoto.setLocation(getWidth() - (getWidth() - 20) / 4, 0);
	}
	
	// init Component end //
	
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
