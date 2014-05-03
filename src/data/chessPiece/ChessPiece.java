package data.chessPiece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ChessPiece extends ChessPiecePicture {
	private String chessName = "";
	private int color;
	private boolean dead = false;
	private boolean cover = true;
	private int chessCoorX, chessCoorY;
	private ChessPieceLocation chessBoardLoc;
	private ChessPiecePicture chessPiecePicture;
	
	public ChessPiece(Point point, int chessCoorX, int chessCoorY,int color, int grid, String chessName, ChessPieceLocation chessBoardLoc) {
		// TODO Auto-generated constructor stub
		super(point, grid, chessName);
		this.chessBoardLoc = chessBoardLoc;
		this.chessName = chessName;
		this.chessCoorX = chessCoorX;
		this.chessCoorY = chessCoorY;
		this.color = color;	//cover=-1, red=0, black=1
	}

	public void goBack() {
		setLocation(chessBoardLoc.getChessLocation(chessCoorX, chessCoorY));
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

}
