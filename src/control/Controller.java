package control;

import observer.ChessPieceCoordinate;
import observer.TransferFrameXY;

public class Controller {
	private TransferFrameXY transferFrameXY;
	private ChessPieceCoordinate chessPieceCoordinate;

	public Controller(int width, int height) {
		// TODO Auto-generated constructor stub
		transferFrameXY = new TransferFrameXY(width, height);
		chessPieceCoordinate = new ChessPieceCoordinate();
	}

	public TransferFrameXY getTransferFrameXY() {
		return transferFrameXY;
	}
	
	public ChessPieceCoordinate getChessPieceCoordinate() {
		return chessPieceCoordinate;
	}
}
