package observer;

import java.util.Observable;
import java.util.Observer;
import control.ChessGameObservable;
import data.chessPiece.ChessPiece;

public class TransferFrameXY implements Observer {
	private int boardWidth, boardHeight;

	public TransferFrameXY(int boardWidth, int boardHeight) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof ChessGameObservable) {
			if (arg instanceof ChessPiece) {
				int locX = (((ChessPiece) arg).getFrameX() + ((ChessPiece) arg).getGrid() / 2);
				int locY = (((ChessPiece) arg).getFrameY() + ((ChessPiece) arg).getGrid() / 2);
//				System.out.println("x: " + ((ChessPiece) arg).getBeforeX() + " to " + ((ChessPiece) arg).getAfterX());
				
				System.out.println("Tran : " + locX + " : " + locY);
				// System.out.println("locX: " + locX);
				if (locX < 0 || locY < 0 || locX > boardWidth || locY > boardHeight) {
					((ChessPiece) arg).goBack();
				} else {
					((ChessPiece) arg).setChessToXY(((ChessPiece) arg).getAfterX(), ((ChessPiece) arg).getAfterY());
				}
			}
		}
	}
}
