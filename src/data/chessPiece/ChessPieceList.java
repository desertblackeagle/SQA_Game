package data.chessPiece;

import java.util.ArrayList;
import java.util.Observable;

/* 
 * add chess in ArrayList
 * initChessPiece
 */
public class ChessPieceList extends Observable {
	private ChessPiece temp;
	private ChessPiece cover;
	private ChessPieceLocation chessBoardLoc;
	private ArrayList<ChessPiece> chessPieceList;

	public ChessPieceList(ChessPieceLocation chessBoardLoc) {
		this.chessBoardLoc = chessBoardLoc;
		chessPieceList = new ArrayList<ChessPiece>();
		initChessPiece();
		// TODO Auto-generated constructor stub
	}

	public void initChessPiece() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				cover = new ChessPiece(chessBoardLoc.getChessLocation(i, j), i, j, -1, chessBoardLoc.getGridLength(), "cover", chessBoardLoc);
				chessPieceList.add(cover);
			}
		}
		
		setChanged();
		notifyObservers(chessPieceList);
	}
	
	public void setChessPiece(int color, String[][] chessBoard) {
		
		chessPieceList.removeAll(chessPieceList);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				if (!chessBoard[i][j].equals("NULL")) {
					cover = new ChessPiece(chessBoardLoc.getChessLocation(i, j), i, j, -1, chessBoardLoc.getGridLength(), chessBoard[i][j], chessBoardLoc);
					chessPieceList.add(cover);
				}
			}
		}
		
		setChanged();
		notifyObservers(chessPieceList);
	}
	

	public ArrayList<ChessPiece> getChessList() {
		return chessPieceList;
	}
}
