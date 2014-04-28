package data;

import data.chess.ChessBoardLocation;
import data.chess.ChessBox;
import data.chess.ChessXYLocOnChessBoard;

public class MainData {
	private ChessBoardLocation chessBoardLoc;
	private ChessBox chessBox;
	private ChessXYLocOnChessBoard chessXYLoc;

	public MainData(int width, int height) {
		// TODO Auto-generated constructor stub
		chessBoardLoc = new ChessBoardLocation(width, height);
		chessBox = new ChessBox(chessBoardLoc);
		chessXYLoc = new ChessXYLocOnChessBoard();
	}

	public ChessBoardLocation getChessBoardLoc() {
		return chessBoardLoc;
	}

	public ChessBox getChessBox() {
		return chessBox;
	}

	public ChessXYLocOnChessBoard getChessXYLoc() {
		return chessXYLoc;
	}

}
