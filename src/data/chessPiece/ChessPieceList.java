package data.chessPiece;

import java.util.ArrayList;
import java.util.Observable;

/* 
 * add chess in ArrayList
 * initChessPiece
 */
public class ChessPieceList extends Observable {
	private ChessPiece redHorse1;
	private ChessPiece redHorse2;
	private ChessPiece blackHorse1;
	private ChessPiece blackHorse2;
	private ChessPiece redChariot1;
	private ChessPiece redChariot2;
	private ChessPiece blackChariot1;
	private ChessPiece blackChariot2;
	private ChessPiece redCannon1;
	private ChessPiece redCannon2;
	private ChessPiece blackCannon1;
	private ChessPiece blackCannon2;
	private ChessPiece redSoldier1;
	private ChessPiece redSoldier2;
	private ChessPiece redSoldier3;
	private ChessPiece redSoldier4;
	private ChessPiece redSoldier5;
	private ChessPiece blackSoldier1;
	private ChessPiece blackSoldier2;
	private ChessPiece blackSoldier3;
	private ChessPiece blackSoldier4;
	private ChessPiece blackSoldier5;
	private ChessPiece redGeneral;
	private ChessPiece blackGeneral;
	private ChessPiece redElephant1;
	private ChessPiece redElephant2;
	private ChessPiece blackElephant1;
	private ChessPiece blackElephant2;
	private ChessPiece redAdvisor1;
	private ChessPiece redAdvisor2;
	private ChessPiece blackAdvisor1;
	private ChessPiece blackAdvisor2;
	private ChessPiece cover;
	private ChessPieceLocation chessBoardLoc;
	private ArrayList<ChessPiece> chessPieceList;

	public ChessPieceList(ChessPieceLocation chessBoardLoc) {
		this.chessBoardLoc = chessBoardLoc;
		chessPieceList = new ArrayList<ChessPiece>();
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

	public ArrayList<ChessPiece> getChessList() {
		return chessPieceList;
	}
}
