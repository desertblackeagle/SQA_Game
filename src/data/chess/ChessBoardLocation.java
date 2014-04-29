package data.chess;

import java.awt.Point;

public class ChessBoardLocation {
	private Point[][] location;
	private int gridLength;
	private int widthFromPanelEdge, heightFromPanelEdge;

	public ChessBoardLocation(int width, int height) {
//		 TODO Auto-generated constructor stub
		location = new Point[4][8];
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
				location[i][j] = new Point();
				location[i][j].x = widthFromPanelEdge + j * gridLength + gridLength / 16;
				location[i][j].y = heightFromPanelEdge + i * gridLength + gridLength / 20;
			}
		}

//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.print("[" + location[i][j].x + "," + location[i][j].y + "]  \t  ");
//			}
//			System.out.println();
//		}
	}

	public int getGridLength() {
		return gridLength;
	}

	public Point getAbsLocOnBoard(int x, int y) {
		if (x < 0 || x > 8 || y < 0 || y > 4) {
			System.out.println("Error : ");
		}
		return location[y][x];
	}

//	public static void main(String[] args) {
//		ChessBoardLocation c = new ChessBoardLocation(848, 790);
//	}

}
