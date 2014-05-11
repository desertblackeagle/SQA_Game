package data.chessPiece;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ChessPiecePicture extends JComponent {
	private String path = "", chessName = "";
	private ImageIcon icon;
	private Image img;
	private int grid;
	private String photoSubPath = "/ChessPiece/";
	
	public ChessPiecePicture(Point point, int grid, String chessName) {
		// TODO Auto-generated constructor stub
		this.chessName = chessName;
		this.grid = grid;
		this.path = photoSubPath + chessName + ".png";
//		setBounds(((int) point.getX()), ((int) point.getY()), 60, 60);
		setBounds(((int) point.getX()), ((int) point.getY()), grid, grid);
	}
	
	public void paintComponent(Graphics g) {
		icon = new ImageIcon(getClass().getResource(path));
		img = icon.getImage();
		g.drawImage(img, 0, 0, grid * 8 / 9, grid * 8 / 9, this);
		g.dispose();
	}
	
	public String getChessName() {
		return chessName;
	}
}
