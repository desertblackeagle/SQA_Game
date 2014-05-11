package data.chessPiece;

import java.awt.Point;
/*
 * define chess pieces location
 */
public class ChessPieceLocation {
	private Point[][] chessLocation;
	private int gridLength;
	private int widthFromPanelEdge, heightFromPanelEdge;
	private int width, height;
	
	public ChessPieceLocation(int width, int height) {
		
//		 TODO Auto-generated constructor stub
		chessLocation = new Point[4][8];
		this.width = width;
		this.height = height;
		allocationSpace(width, height);
		calcLocation();
	}
	
	private void allocationSpace(int width, int height) {
		gridLength = Math.min(height / 4, width / 8);
		widthFromPanelEdge = (width - 8 * gridLength) / 2;
		heightFromPanelEdge = (height - 4 * gridLength) / 2;
	}
	
	private void calcLocation() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				chessLocation[i][j] = new Point();
				chessLocation[i][j].x = widthFromPanelEdge + j * gridLength + gridLength / 16;
				chessLocation[i][j].y = heightFromPanelEdge + i * gridLength + gridLength / 20;
			}
		}
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.print("[" + chessLocation[i][j].x + "," + chessLocation[i][j].y + "]  \t  ");
//			}
//			System.out.println();
//		}
	}
	
	public int getGridLength() {
		return gridLength;
	}
	
	public int getBoardWidth() {
		return width;
	}
	
	public int getBoardHeight() {
		return height;
	}
	
	public Point getChessLocation(int chessCoorX, int chessCoorY) {
		if (chessCoorX < 0 || chessCoorX > 8 || chessCoorY < 0 || chessCoorY > 4) {
			System.out.println("Error : ");
		}
		return chessLocation[chessCoorY][chessCoorX];
	}
	
//	public static void main(String[] args) {
//		ChessBoardLocation c = new ChessBoardLocation(848, 790);
//	}

}
