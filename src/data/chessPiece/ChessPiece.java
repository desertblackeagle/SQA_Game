package data.chessPiece;

import java.awt.Point;

public class ChessPiece extends ChessPiecePicture {
	private String chessName = "";
	private int color;
	private boolean dead = false;
	private boolean cover = true;
	private int chessCoorX, chessCoorY;
	private ChessPieceLocation chessBoardLoc;
	private ChessPiecePicture chessPiecePicture;
	private int beforeX, beforeY, afterX, afterY;
	private int grid;
	
	public ChessPiece(Point point, int chessCoorX, int chessCoorY,int color, int grid, String chessName, ChessPieceLocation chessBoardLoc) {
		// TODO Auto-generated constructor stub
		super(point, grid, chessName);
		this.grid = grid;
		this.chessBoardLoc = chessBoardLoc;
		this.chessName = chessName;
		this.chessCoorX = chessCoorX;
		this.chessCoorY = chessCoorY;
		this.color = color;	//cover=-1, red=0, black=1
		this.beforeX = chessCoorX;
		this.beforeY = chessCoorY;
	}

	public void goBack() {
		setLocation(chessBoardLoc.getChessLocation(beforeX, beforeY));
		setAfterX(beforeX);
		setAfterY(beforeY);
	}

	public void setChessToXY(int chessCoorX, int chessCoorY) {
		setLocation(chessBoardLoc.getChessLocation(chessCoorX, chessCoorY));
	}

	public String getChessName() {
		return chessName;
	}

	public int getFrameX() {
		return getLocation().x;
	}

	public int getFrameY() {
		return getLocation().y;
	}

	public int getChessBoardX() {
		return chessCoorX;
	}

	public int getChessBoardY() {
		return chessCoorY;
	}
	
	public int getGrid() {
		return grid;
	}
	
	public int getBeforeX() {
		return beforeX;
	}
	
	public int getBeforeY() {
		return beforeY;
	}
	
	public int getAfterX() {
		return afterX;
	}
	
	public int getAfterY() {
		return afterY;
	}
	
	public void setBeforeX(int beforeX) {
		this.beforeX = beforeX;
	}
	
	public void setBeforeY(int beforeY) {
		this.beforeY = beforeY;
	}
	
	public void setAfterX(int afterX) {
		this.afterX = afterX;
	}
	
	public void setAfterY(int afterY) {
		this.afterY = afterY;
	}
}
