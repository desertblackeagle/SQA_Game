package observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import data.chessPiece.ChessPiece;
import data.chessPiece.ChessPieceList;
/*
 * Coordinate of chess Piece (Model), 8 * 4
 */
public class ChessPieceCoordinate implements Observer {
	private ChessPiece[][] chessPieceCoordinate;

	public ChessPieceCoordinate() {
		// TODO Auto-generated constructor stub
		chessPieceCoordinate = new ChessPiece[4][8];
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof ChessPieceList) {
			if (arg instanceof ArrayList<?>) {
				resetCoordinate();
				for (ChessPiece chess : (ArrayList<ChessPiece>) arg) {
					chessPieceCoordinate[chess.getChessBoardY()][chess.getChessBoardX()] = chess;
				}
				printCoordinate();
			}
		}
	}
	
	private void resetCoordinate() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				chessPieceCoordinate[i][j] = null;
			}
		}
	}
	
	private void printCoordinate() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				if (chessPieceCoordinate[i][j] != null) {
					if (chessPieceCoordinate[i][j].getChessName().equals("cover")) {
						System.out.print(chessPieceCoordinate[i][j].getChessName() + "\t\t");
					} else {
						System.out.print(chessPieceCoordinate[i][j].getChessName() + "\t");
					}
				} else {
					System.out.print("NULL" + "\t\t");
				}
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
	}
}
