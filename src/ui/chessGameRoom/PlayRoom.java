package ui.chessGameRoom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.ChatJPanel;
import ui.MainFrame;

public class PlayRoom extends MainFrame {
	private JLabel background;
	private PlayerInfoJPanel playerInfo;
	private TaiwanChessBoard chessBoard;
	ChatJPanel f;

	public PlayRoom() {
		// TODO Auto-generated constructor stub
		initChessBoard();
		initJPanel();
		f = new ChatJPanel(getWidth() - (getWidth() - 100)/3, 300, (getWidth() - 150) / 3, 500);
		add(f);
		initBackground();
		initBound();
		initLocation();
		revalidate();
		repaint();
	}

	private void initBackground() {
		background = new JLabel(new ImageIcon("c:/sqa/04.png"));
		add(background);
	}

	private void initJPanel() {
		playerInfo = new PlayerInfoJPanel((getWidth() - 150) * 2 / 3, 200);
		add(playerInfo);
	}

	private void initChessBoard() {
		chessBoard = new TaiwanChessBoard((getWidth() - 150) * 2 / 3, 420);
		add(chessBoard);
	}

	private void initBound() {
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
	}

	private void initLocation() {
		chessBoard.setLocation(50, 185);
		playerInfo.setLocation(50, 620);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayRoom p = new PlayRoom();
	}

}
