package data.chessPiece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ChessPiece extends JComponent {
	private String path = "", chessName = "";
	private ImageIcon icon;
	private Image img;
	private int grid, color;
	private boolean dead = false;
	private boolean cover = true;
	private int chessCoorX, chessCoorY;
	private ChessPieceLocation chessBoardLoc;

	public ChessPiece(Point point, int chessCoorX, int chessCoorY,int color, int grid, String path, String chessName, ChessPieceLocation chessBoardLoc) {
		// TODO Auto-generated constructor stub
		this.chessBoardLoc = chessBoardLoc;
		this.chessName = chessName;
		this.chessCoorX = chessCoorX;
		this.chessCoorY = chessCoorY;
		this.grid = grid;
		this.color = color;	//cover=-1, red=0, black=1
		this.path = path;
		setBounds(((int) point.getX()), ((int) point.getY()), 60, 60);
		setBounds(((int) point.getX()), ((int) point.getY()), grid, grid);
		setBackground(Color.black);
	}

	public void paintComponent(Graphics g) {
		g.setColor(new Color(227, 33, 34));
		icon = new ImageIcon(getClass().getResource(path));
		img = icon.getImage();
		g.drawImage(img, 0, 0, grid * 8 / 9, grid * 8 / 9, this);
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
