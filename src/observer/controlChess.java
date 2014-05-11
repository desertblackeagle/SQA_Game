package observer;

import java.util.Observable;
import java.util.Observer;
import data.chessPiece.ChessPiece;

public class controlChess implements Observer {
	private int boardWidth, boardHeight;

	public controlChess(int boardWidth, int boardHeight) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof ChessPiece) {
//			int locX = (((ChessPiece) arg).getFrameX() + ((ChessPiece) arg).getGrid() / 2);
//			int locY = (((ChessPiece) arg).getFrameY() + ((ChessPiece) arg).getGrid() / 2);
//			System.out.println("Tran : " + locX + " : " + locY);
//			System.out.println("locX: " + locX);
//			if (locX < 0 || locY < 0 || locX > boardWidth || locY > boardHeight) {
//				((ChessPiece) arg).goBack();
//			}
//			System.out.println("x: " + ((ChessPiece) arg).getBeforeX() + " to " + ((ChessPiece) arg).getAfterX());

		}
	}
}
