package data.chess;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;

import ui.chessGameRoom.TaiwanChessBoard;;;

public class ChessBox extends Observable {
	private Chess redHorse1;
	private Chess redHorse2;
	private Chess blackHorse1;
	private Chess blackHorse2;
	private Chess redChariot1;
	private Chess redChariot2;
	private Chess blackChariot1;
	private Chess blackChariot2;
	private Chess redCannon1;
	private Chess redCannon2;
	private Chess blackCannon1;
	private Chess blackCannon2;
	private Chess redSoldier1;
	private Chess redSoldier2;
	private Chess redSoldier3;
	private Chess redSoldier4;
	private Chess redSoldier5;
	private Chess blackSoldier1;
	private Chess blackSoldier2;
	private Chess blackSoldier3;
	private Chess blackSoldier4;
	private Chess blackSoldier5;
	private Chess redGeneral;
	private Chess blackGeneral;
	private Chess redElephant1;
	private Chess redElephant2;
	private Chess blackElephant1;
	private Chess blackElephant2;
	private Chess redAdvisor1;
	private Chess redAdvisor2;
	private Chess blackAdvisor1;
	private Chess blackAdvisor2;
	private Chess cover;
	private ChessBoardLocation chessBoardLoc;
	private String photoSubPath = "C:/sqa/chessman/";
	private ArrayList<Chess> chessBoxList;

	public ChessBox(ChessBoardLocation chessBoardLoc) {
		this.chessBoardLoc = chessBoardLoc;
		chessBoxList = new ArrayList<Chess>();
		// TODO Auto-generated constructor stub
	}

	public void initChess() {
//		redHorse1 = new Chess(chessBoardLoc.getAbsLocOnBoard(1, 9), 1, 9, chessBoardLoc.getGridLength(), photoSubPath + "redHorse.png", "redHorse1", chessBoardLoc);
//		redHorse2 = new Chess(chessBoardLoc.getAbsLocOnBoard(7, 9), 7, 9, chessBoardLoc.getGridLength(), photoSubPath + "redHorse.png", "redHorse2", chessBoardLoc);
//		blackHorse1 = new Chess(chessBoardLoc.getAbsLocOnBoard(1, 0), 1, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackHorse.png", "blackHorse1", chessBoardLoc);
//		blackHorse2 = new Chess(chessBoardLoc.getAbsLocOnBoard(7, 0), 7, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackHorse.png", "blackHorse2", chessBoardLoc);
//		redChariot1 = new Chess(chessBoardLoc.getAbsLocOnBoard(0, 9), 0, 9, chessBoardLoc.getGridLength(), photoSubPath + "redChariot.png", "redChariot1", chessBoardLoc);
//		redChariot2 = new Chess(chessBoardLoc.getAbsLocOnBoard(8, 9), 8, 9, chessBoardLoc.getGridLength(), photoSubPath + "redChariot.png", "redChariot2", chessBoardLoc);
//		blackChariot1 = new Chess(chessBoardLoc.getAbsLocOnBoard(0, 0), 0, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackChariot.png", "blackChariot1", chessBoardLoc);
//		blackChariot2 = new Chess(chessBoardLoc.getAbsLocOnBoard(8, 0), 8, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackChariot.png", "blackChariot2", chessBoardLoc);
//		redCannon1 = new Chess(chessBoardLoc.getAbsLocOnBoard(1, 7), 1, 7, chessBoardLoc.getGridLength(), photoSubPath + "redCannon.png", "redCannon1", chessBoardLoc);
//		redCannon2 = new Chess(chessBoardLoc.getAbsLocOnBoard(7, 7), 7, 7, chessBoardLoc.getGridLength(), photoSubPath + "redCannon.png", "redCannon2", chessBoardLoc);
//		blackCannon1 = new Chess(chessBoardLoc.getAbsLocOnBoard(1, 2), 1, 2, chessBoardLoc.getGridLength(), photoSubPath + "blackCannon.png", "blackCannon1", chessBoardLoc);
//		blackCannon2 = new Chess(chessBoardLoc.getAbsLocOnBoard(7, 2), 7, 2, chessBoardLoc.getGridLength(), photoSubPath + "blackCannon.png", "blackCannon2", chessBoardLoc);
//		redSoldier1 = new Chess(chessBoardLoc.getAbsLocOnBoard(0, 6), 0, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier1", chessBoardLoc);
//		redSoldier2 = new Chess(chessBoardLoc.getAbsLocOnBoard(2, 6), 2, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier2", chessBoardLoc);
//		redSoldier3 = new Chess(chessBoardLoc.getAbsLocOnBoard(4, 6), 4, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier3", chessBoardLoc);
//		redSoldier4 = new Chess(chessBoardLoc.getAbsLocOnBoard(6, 6), 6, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier4", chessBoardLoc);
//		redSoldier5 = new Chess(chessBoardLoc.getAbsLocOnBoard(8, 6), 8, 6, chessBoardLoc.getGridLength(), photoSubPath + "redSoldier.png", "redSoldier5", chessBoardLoc);
//		blackSoldier1 = new Chess(chessBoardLoc.getAbsLocOnBoard(0, 3), 0, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier1", chessBoardLoc);
//		blackSoldier2 = new Chess(chessBoardLoc.getAbsLocOnBoard(2, 3), 2, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier2", chessBoardLoc);
//		blackSoldier3 = new Chess(chessBoardLoc.getAbsLocOnBoard(4, 3), 4, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier3", chessBoardLoc);
//		blackSoldier4 = new Chess(chessBoardLoc.getAbsLocOnBoard(6, 3), 6, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier4", chessBoardLoc);
//		blackSoldier5 = new Chess(chessBoardLoc.getAbsLocOnBoard(8, 3), 8, 3, chessBoardLoc.getGridLength(), photoSubPath + "blackSoldier.png", "blackSoldier5", chessBoardLoc);
//		redGeneral = new Chess(chessBoardLoc.getAbsLocOnBoard(4, 9), 4, 9, chessBoardLoc.getGridLength(), photoSubPath + "redGeneral.png", "redGeneral", chessBoardLoc);
//		blackGeneral = new Chess(chessBoardLoc.getAbsLocOnBoard(4, 0), 4, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackGeneral.png", "blackGeneral", chessBoardLoc);
//		redElephant1 = new Chess(chessBoardLoc.getAbsLocOnBoard(2, 9), 2, 9, chessBoardLoc.getGridLength(), photoSubPath + "redElephant.png", "redElephant1", chessBoardLoc);
//		redElephant2 = new Chess(chessBoardLoc.getAbsLocOnBoard(6, 9), 6, 9, chessBoardLoc.getGridLength(), photoSubPath + "redElephant.png", "redElephant2", chessBoardLoc);
//		blackElephant1 = new Chess(chessBoardLoc.getAbsLocOnBoard(2, 0), 2, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackElephant.png", "blackElephant1", chessBoardLoc);
//		blackElephant2 = new Chess(chessBoardLoc.getAbsLocOnBoard(6, 0), 6, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackElephant.png", "blackElephant2", chessBoardLoc);
//		redAdvisor1 = new Chess(chessBoardLoc.getAbsLocOnBoard(3, 9), 3, 9, chessBoardLoc.getGridLength(), photoSubPath + "redAdvisor.png", "redAdvisor1", chessBoardLoc);
//		redAdvisor2 = new Chess(chessBoardLoc.getAbsLocOnBoard(5, 9), 5, 9, chessBoardLoc.getGridLength(), photoSubPath + "redAdvisor.png", "redAdvisor2", chessBoardLoc);
//		blackAdvisor1 = new Chess(chessBoardLoc.getAbsLocOnBoard(3, 0), 3, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackAdvisor.png", "blackAdvisor1", chessBoardLoc);
//		blackAdvisor2 = new Chess(chessBoardLoc.getAbsLocOnBoard(5, 0), 5, 0, chessBoardLoc.getGridLength(), photoSubPath + "blackAdvisor.png", "blackAdvisor2", chessBoardLoc);
//		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				cover = new Chess(chessBoardLoc.getAbsLocOnBoard(i, j), i, j, chessBoardLoc.getGridLength(), photoSubPath + "cover.png", "cover", chessBoardLoc);
				chessBoxList.add(cover);
			}
		}
		
//		chessBoxList.add(redHorse1);
//		chessBoxList.add(redHorse2);
//		chessBoxList.add(blackHorse1);
//		chessBoxList.add(blackHorse2);
//		chessBoxList.add(redChariot1);
//		chessBoxList.add(redChariot2);
//		chessBoxList.add(blackChariot1);
//		chessBoxList.add(blackChariot2);
//		chessBoxList.add(redCannon1);
//		chessBoxList.add(redCannon2);
//		chessBoxList.add(blackCannon1);
//		chessBoxList.add(blackCannon2);
//		chessBoxList.add(redSoldier1);
//		chessBoxList.add(redSoldier2);
//		chessBoxList.add(redSoldier3);
//		chessBoxList.add(redSoldier4);
//		chessBoxList.add(redSoldier5);
//		chessBoxList.add(blackSoldier1);
//		chessBoxList.add(blackSoldier2);
//		chessBoxList.add(blackSoldier3);
//		chessBoxList.add(blackSoldier4);
//		chessBoxList.add(blackSoldier5);
//		chessBoxList.add(redGeneral);
//		chessBoxList.add(blackGeneral);
//		chessBoxList.add(redElephant1);
//		chessBoxList.add(redElephant2);
//		chessBoxList.add(blackElephant1);
//		chessBoxList.add(blackElephant2);
//		chessBoxList.add(redAdvisor1);
//		chessBoxList.add(redAdvisor2);
//		chessBoxList.add(blackAdvisor1);
//		chessBoxList.add(blackAdvisor2);

		setChanged();
		notifyObservers(chessBoxList);
	}

	public ArrayList<Chess> getChessBox() {
		return chessBoxList;
	}
}
