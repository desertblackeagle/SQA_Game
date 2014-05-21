package data;

import rmi.GameClient;
import data.chessPiece.ChessPieceList;
import data.chessPiece.ChessPieceLocation;

public class MainData {
	private ChessPieceLocation chessBoardLoc;
	private ChessPieceList chessPieceList;
	

	public MainData(int width, int height, GameClient server, String userToken) {
		// TODO Auto-generated constructor stub
		chessBoardLoc = new ChessPieceLocation(width, height);
		chessPieceList = new ChessPieceList(chessBoardLoc, server, userToken);
		
	}

	public ChessPieceLocation getChessBoardLoc() {
		return chessBoardLoc;
	}

	public ChessPieceList getChessPieceList() {
		return chessPieceList;
	}

	

}
