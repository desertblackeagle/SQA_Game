package ui.chessGameRoom;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfoJPanel extends JPanel {

	private JLabel playerAScore, playerBScore, playerAPhoto, playerBPhoto, forWhoToPlay;
	private ImageIcon defaultPlayerAPhoto, defaultPlayerBPhoto;

	public PlayerInfoJPanel(int weight, int height) {
		// TODO Auto-generated constructor stub
		setSize(weight, height);
		setLayout(null);
		setOpaque(false);
		initImageIcon();
		initJLabel();
		initBound();
		initLocation();
		setComponentFont();
	}

	private void setComponentFont() {

		playerAScore.setFont(new Font(Font.DIALOG, Font.BOLD, 23));
		playerBScore.setFont(new Font(Font.DIALOG, Font.BOLD, 23));
		forWhoToPlay.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
	}

	private void initImageIcon() {
		defaultPlayerAPhoto = new ImageIcon("c:/sqa/playerAPhoto.jpg");
		defaultPlayerBPhoto = new ImageIcon("c:/sqa/playerBPhoto.jpg");
	}

	private void initJLabel() {
		playerAScore = new JLabel("0分");
		add(playerAScore);
		playerBScore = new JLabel("0分", JLabel.RIGHT);
		add(playerBScore);
		playerAPhoto = new JLabel();
		playerAPhoto.setSize((getWidth() - 20) / 4, (getWidth() - 20) / 4);
		defaultPlayerAPhoto.setImage(defaultPlayerAPhoto.getImage().getScaledInstance(playerAPhoto.getWidth(), playerAPhoto.getHeight(), Image.SCALE_DEFAULT));
		playerAPhoto.setIcon(defaultPlayerAPhoto);
		add(playerAPhoto);
		playerBPhoto = new JLabel();
		playerBPhoto.setSize((getWidth() - 20) / 4, (getWidth() - 20) / 4);
		defaultPlayerBPhoto.setImage(defaultPlayerBPhoto.getImage().getScaledInstance(playerBPhoto.getWidth(), playerBPhoto.getHeight(), Image.SCALE_DEFAULT));
		playerBPhoto.setIcon(defaultPlayerBPhoto);
		add(playerBPhoto);
		forWhoToPlay = new JLabel("--------------");
		add(forWhoToPlay);
	}

	private void initBound() {
		playerAScore.setBounds(getWidth() / 2 - 50, 50, 50, 50);
		playerBScore.setBounds(getWidth() / 2, 50, 50, 50);
		forWhoToPlay.setBounds(getWidth() / 2 - 50, 0, 100, 50);
	}

	private void initLocation() {
		playerAPhoto.setLocation(0, 0);
		playerBPhoto.setLocation(getWidth() - (getWidth() - 20) / 4, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(900, 920);
		PlayerInfoJPanel ccb = new PlayerInfoJPanel(f.getWidth(), f.getHeight());
		ccb.setLocation(0, 0);
		f.add(ccb);
	}

}
