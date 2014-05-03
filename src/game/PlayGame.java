package game;

import control.Controller;
import data.MainData;
import ui.playRoom.PlayRoom;

public class PlayGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayRoom playRoom = new PlayRoom();
		int chessBoardWidth = playRoom.getChessBoard().getChessBoardWidth(), chessBoardHeight = playRoom.getChessBoard().getChessBoardHeight();
		MainData data = new MainData(chessBoardWidth, chessBoardHeight);
		Controller controler = new Controller(chessBoardWidth, chessBoardHeight);

		// set observer observable
		data.getChessPieceList().addObserver(playRoom.getChessBoard());
		data.getChessPieceList().addObserver(controler.getChessPieceCoordinate());
		playRoom.addObserver(controler.getTransferFrameXY());
		// set observer observable end
		data.getChessPieceList().initChessPiece();
	}
}
