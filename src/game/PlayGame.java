package game;

import control.Controller;
import data.MainData;
import ui.playRoom.PlayRoom;

public class PlayGame {

	private String[][] chesses;
	PlayRoom playRoom;
	int chessBoardWidth, chessBoardHeight;
	MainData data;
	Controller controler;
	
	public PlayGame() {
		playRoom = new PlayRoom();
		chessBoardWidth = playRoom.getChessBoard().getChessBoardWidth();
		chessBoardHeight = playRoom.getChessBoard().getChessBoardHeight();
		data = new MainData(chessBoardWidth, chessBoardHeight);
		controler = new Controller(chessBoardWidth, chessBoardHeight);
		
		// set observer observable
		data.getChessPieceList().addObserver(playRoom.getChessBoard());
		data.getChessPieceList().addObserver(controler.getChessPieceCoordinate());
		playRoom.getChessBoard().getChessGameObservable().addObserver(controler.getTransferFrameXY());
		playRoom.getChessBoard().getChessGameObservable().addObserver(data.getChessPieceList());
		// set observer observable end
		data.getChessPieceList().initChessPiece();
	}
	
	public void test() {
		chesses = new String[8][4];
		
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 4; j++) {
//				chesses[i][j] = "cover";
//			}
//		}
//		chesses[0][0] = "NULL";
//		data.getChessPieceList().setChessPiece(0, chesses);
//		chesses[1][3] = "redHorse";
//		data.getChessPieceList().setChessPiece(0, chesses);
//		chesses[2][3] = "redHorse";
//		data.getChessPieceList().setChessPiece(0, chesses);
//		System.out.println("x: " + playRoom.getChessBoard().getBefortX() + " to " + playRoom.getChessBoard().getAfterX());
//		chesses = controler.getTransferFrameXY().getChessName();
//		data.getChessPieceList().setChessPiece(0, chesses);
	}
	
	public static void main(String[] args) {
		PlayGame pg = new PlayGame();
		pg.test();
	}
}
