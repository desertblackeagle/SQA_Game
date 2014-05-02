package data.chessPiece;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;

import control.observer.ChessBoard;
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
	private String photoSubPath = "/ChessPiece/";
	private ArrayList<ChessPiece> chessPieceList;

	public ChessPieceList(ChessPieceLocation chessBoardLoc) {
		this.chessBoardLoc = chessBoardLoc;
		chessPieceList = new ArrayList<ChessPiece>();
		// TODO Auto-generated constructor stub
	}

	public void initChessPiece() {
//		redHorse1 = new Chess(chessBoardLoc.getChessLocation(1, 9), 1, 9, chessBoardLoc.getGridLength(), photoSubPath + "redHorse.png", "redHorse1", chessBoardLoc);
//		redHorse2 = new Chess(chessBoardLoc.getChessLocation(7, 9), 7, 9, chessBoardLoc.getGridLength(), photoSubPath + "redHorse.png", "redHorse2", chessBoardLoc);
//		blackHorse1 = new Chess(chessBoardLoc.getChessLocation(1, 0), 1, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackHorse.png", "blackHorse1", chessBoardLoc);
//		blackHorse2 = new Chess(chessBoardLoc.getChessLocation(7, 0), 7, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackHorse.png", "blackHorse2", chessBoardLoc);
//		redChariot1 = new Chess(chessBoardLoc.getChessLocation(0, 9), 0, 9, chessBoardLoc.getGridLength(), photoSubPath + "redChariot.png", "redChariot1", chessBoardLoc);
//		redChariot2 = new Chess(chessBoardLoc.getChessLocation(8, 9), 8, 9, chessBoardLoc.getGridLength(), photoSubPath + "redChariot.png", "redChariot2", chessBoardLoc);
//		blackChariot1 = new Chess(chessBoardLoc.getChessLocation(0, 0), 0, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackChariot.png", "blackChariot1", chessBoardLoc);
//		blackChariot2 = new Chess(chessBoardLoc.getChessLocation(8, 0), 8, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackChariot.png", "blackChariot2", chessBoardLoc);
//		redCannon1 = new Chess(chessBoardLoc.getChessLocation(1, 7), 1, 7, chessBoardLoc.getGridLength(), photoSubPath + "redCannon.png", "redCannon1", chessBoardLoc);
//		redCannon2 = new Chess(chessBoardLoc.getChessLocation(7, 7), 7, 7, chessBoardLoc.getGridLength(), photoSubPath + "redCannon.png", "redCannon2", chessBoardLoc);
//		blackCannon1 = new Chess(chessBoardLoc.getChessLocation(1, 2), 1, 2, chessBoardLoc.getGridLength(), photoSubPath + "blackCannon.png", "blackCannon1", chessBoardLoc);
//		blackCannon2 = new Chess(chessBoardLoc.getChessLocation(7, 2), 7, 2, chessBoardLoc.getGridLength(), photoSubPath + "blackCannon.png", "blackCannon2", chessBoardLoc);
//		redSoldier1 = new Chess(chessBoardLoc.getChessLocation(0, 6), 0, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier1", chessBoardLoc);
//		redSoldier2 = new Chess(chessBoardLoc.getChessLocation(2, 6), 2, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier2", chessBoardLoc);
//		redSoldier3 = new Chess(chessBoardLoc.getChessLocation(4, 6), 4, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier3", chessBoardLoc);
//		redSoldier4 = new Chess(chessBoardLoc.getChessLocation(6, 6), 6, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier4", chessBoardLoc);
//		redSoldier5 = new Chess(chessBoardLoc.getChessLocation(8, 6), 8, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier5", chessBoardLoc);
//		blackSoldier1 = new Chess(chessBoardLoc.getChessLocation(0, 3), 0, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier1", chessBoardLoc);
//		blackSoldier2 = new Chess(chessBoardLoc.getChessLocation(2, 3), 2, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier2", chessBoardLoc);
//		blackSoldier3 = new Chess(chessBoardLoc.getChessLocation(4, 3), 4, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier3", chessBoardLoc);
//		blackSoldier4 = new Chess(chessBoardLoc.getChessLocation(6, 3), 6, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier4", chessBoardLoc);
//		blackSoldier5 = new Chess(chessBoardLoc.getChessLocation(8, 3), 8, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier5", chessBoardLoc);
//		redGeneral = new Chess(chessBoardLoc.getChessLocation(4, 9), 4, 9, chessBoardLoc.getGridLength(), photoSubPath + "redGeneral.png", "redGeneral", chessBoardLoc);
//		blackGeneral = new Chess(chessBoardLoc.getChessLocation(4, 0), 4, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackGeneral.png", "blackGeneral", chessBoardLoc);
//		redElephant1 = new Chess(chessBoardLoc.getChessLocation(2, 9), 2, 9, chessBoardLoc.getGridLength(), photoSubPath + "redElephant.png", "redElephant1", chessBoardLoc);
//		redElephant2 = new Chess(chessBoardLoc.getChessLocation(6, 9), 6, 9, chessBoardLoc.getGridLength(), photoSubPath + "redElephant.png", "redElephant2", chessBoardLoc);
//		blackElephant1 = new Chess(chessBoardLoc.getChessLocation(2, 0), 2, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackElephant.png", "blackElephant1", chessBoardLoc);
//		blackElephant2 = new Chess(chessBoardLoc.getChessLocation(6, 0), 6, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackElephant.png", "blackElephant2", chessBoardLoc);
//		redAdvisor1 = new Chess(chessBoardLoc.getChessLocation(3, 9), 3, 9, chessBoardLoc.getGridLength(), photoSubPath + "redAdvisor.png", "redAdvisor1", chessBoardLoc);
//		redAdvisor2 = new Chess(chessBoardLoc.getChessLocation(5, 9), 5, 9, chessBoardLoc.getGridLength(), photoSubPath + "redAdvisor.png", "redAdvisor2", chessBoardLoc);
//		blackAdvisor1 = new Chess(chessBoardLoc.getChessLocation(3, 0), 3, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackAdvisor.png", "blackAdvisor1", chessBoardLoc);
//		blackAdvisor2 = new Chess(chessBoardLoc.getChessLocation(5, 0), 5, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackAdvisor.png", "blackAdvisor2", chessBoardLoc);
//		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				cover = new ChessPiece(chessBoardLoc.getChessLocation(i, j), i, j, -1, chessBoardLoc.getGridLength(), photoSubPath + "cover.png", "cover", chessBoardLoc);
				chessPieceList.add(cover);
			}
		}
		
//		chessmanBoxList.add(redHorse1);
//		chessmanBoxList.add(redHorse2);
//		chessmanBoxList.add(blackHorse1);
//		chessmanBoxList.add(blackHorse2);
//		chessmanBoxList.add(redChariot1);
//		chessmanBoxList.add(redChariot2);
//		chessmanBoxList.add(blackChariot1);
//		chessmanBoxList.add(blackChariot2);
//		chessmanBoxList.add(redCannon1);
//		chessmanBoxList.add(redCannon2);
//		chessmanBoxList.add(blackCannon1);
//		chessmanBoxList.add(blackCannon2);
//		chessmanBoxList.add(redSoldier1);
//		chessmanBoxList.add(redSoldier2);
//		chessmanBoxList.add(redSoldier3);
//		chessmanBoxList.add(redSoldier4);
//		chessmanBoxList.add(redSoldier5);
//		chessmanBoxList.add(blackSoldier1);
//		chessmanBoxList.add(blackSoldier2);
//		chessmanBoxList.add(blackSoldier3);
//		chessmanBoxList.add(blackSoldier4);
//		chessmanBoxList.add(blackSoldier5);
//		chessmanBoxList.add(redGeneral);
//		chessmanBoxList.add(blackGeneral);
//		chessmanBoxList.add(redElephant1);
//		chessmanBoxList.add(redElephant2);
//		chessmanBoxList.add(blackElephant1);
//		chessmanBoxList.add(blackElephant2);
//		chessmanBoxList.add(redAdvisor1);
//		chessmanBoxList.add(redAdvisor2);
//		chessmanBoxList.add(blackAdvisor1);
//		chessmanBoxList.add(blackAdvisor2);
		
		setChanged();
		notifyObservers(chessPieceList);
	}

	public ArrayList<ChessPiece> getChessList() {
		return chessPieceList;
	}
}
