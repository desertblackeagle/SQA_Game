package observer;

import java.util.Observable;
import java.util.Observer;


import data.chessPiece.ChessPiece;

public class TransferFrameXY implements Observer {
	private int boardWidth, boardHeight;
	private String[][] chesses = new String[8][4];

	public TransferFrameXY(int boardWidth, int boardHeight) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}
	
	public String[][] getChessName() {
		updateChessBoardInfo();
		return chesses;
	}
	
	public String[][] updateChessBoardInfo() {
		chesses = new String[8][4];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				chesses[i][j] = "cover";
			}
		}
		chesses[0][0] = "NULL";
		chesses[1][3] = "redHorse";
		return chesses;
	}

	@Override
	public void update(Observable o, Object arg) {
		boolean canMove = true;
		// TODO Auto-generated method stub
		if (arg instanceof ChessPiece) {
			int locX = (((ChessPiece) arg).getFrameX() + ((ChessPiece) arg).getGrid() / 2);
			int locY = (((ChessPiece) arg).getFrameY() + ((ChessPiece) arg).getGrid() / 2);
			// System.out.println("x: " + ((ChessPiece) arg).getBeforeX() +
			// " to " + ((ChessPiece) arg).getAfterX());

			System.out.println("Tran : " + locX + " : " + locY);
			// System.out.println("locX: " + locX);
			if (locX < 0 || locY < 0 || locX > boardWidth || locY > boardHeight) {
				((ChessPiece) arg).goBack();
//			} else if (canMove){
//				updateChessBoardInfo();
//				((ChessPiece) arg).setChessToXY(((ChessPiece) arg).getAfterX(), ((ChessPiece) arg).getAfterY());
			}
		}
	}
}
