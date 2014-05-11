package observer;

import control.Controller;
import data.MainData;
import ui.playRoom.PlayRoom;

public class controlChess {

	private String[][] chesses;
	private PlayRoom playRoom;
	private int chessBoardWidth, chessBoardHeight;
	private MainData data;
	private Controller controler;
	
	public controlChess() {
		playRoom = new PlayRoom();
		chessBoardWidth = playRoom.getChessBoard().getChessBoardWidth();
		chessBoardHeight = playRoom.getChessBoard().getChessBoardHeight();
		data = new MainData(chessBoardWidth, chessBoardHeight);
		controler = new Controller(chessBoardWidth, chessBoardHeight);
		
		// set observer observable
		data.getChessPieceList().addObserver(playRoom.getChessBoard());
		data.getChessPieceList().addObserver(controler.getChessPieceCoordinate());
		playRoom.getChessBoard().getChessGameObservable().addObserver(controler.getTransferFrameXY());
		// set observer observable end
		data.getChessPieceList().initChessPiece();
	}
	
	public void test() {
		chesses = new String[8][4];
		chesses = controler.getTransferFrameXY().getChessName();
		data.getChessPieceList().setChessPiece(0, chesses);
	}
	
	public static void main(String[] args) {
		controlChess pg = new controlChess();
		pg.test();
	}
}
