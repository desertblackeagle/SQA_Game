package ui.chessGameRoom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.MainFrame;

public class PlayRoom extends MainFrame {
	private JLabel background;
	private TaiwanChessBoard chessBoard;

	public PlayRoom() {
		// TODO Auto-generated constructor stub
		initChessBoard();
		initBackground();
		initBound();
	}

	private void initBackground() {
		background = new JLabel(new ImageIcon("c:/04.png"));
		add(background);
	}

	private void initChessBoard() {
		chessBoard = new TaiwanChessBoard(920, 420);
		add(chessBoard);
	}

	private void initBound() {
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
		chessBoard.setBounds(50, 185, 920, 420);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayRoom p = new PlayRoom();
	}

}
