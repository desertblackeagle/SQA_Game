package observer;

import java.util.Observable;
import java.util.Observer;
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
		if (arg instanceof ChessPiece) {
			int locX = (((ChessPiece) arg).getFrameX() + ((ChessPiece) arg).getWidth() / 2);
			int locY = (((ChessPiece) arg).getFrameY() + ((ChessPiece) arg).getHeight() / 2);
			System.out.println("Tran : " + (((ChessPiece) arg).getFrameX() + ((ChessPiece) arg).getWidth() / 2) + " : " + (((ChessPiece) arg).getFrameY() + ((ChessPiece) arg).getHeight() / 2));
			if (locX < 0 || locY < 0 || locX > boardWidth || locY > boardHeight) {
				((ChessPiece) arg).goBack();
			}
		}
	}
}
