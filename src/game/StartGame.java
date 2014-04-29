package game;

import control.Controler;
import data.MainData;
import ui.chessGameRoom.PlayRoom;;

public class StartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayRoom playRoom = new PlayRoom();
		int chessBoardWidth = playRoom.getChessBoard().getChessBoardWidth(), chessBoardHeight = playRoom.getChessBoard().getChessBoardHeight();
		MainData data = new MainData(chessBoardWidth, chessBoardHeight);
		Controler controler = new Controler(chessBoardWidth, chessBoardHeight);

		// set observer observable
		data.getChessBox().addObserver(playRoom.getChessBoard());
		data.getChessBox().addObserver(data.getChessXYLoc());
		playRoom.getChessBoard().addObserver(controler.getTransferAbsoluteToXY());
		// set observer observable end
		data.getChessBox().initChess();
	}
}
