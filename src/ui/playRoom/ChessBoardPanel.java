package ui.playRoom;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChessBoardPanel extends JPanel {
	int gridLength;
	int widthFromPanelEdge, heightFromPanelEdge;
	private int chessBoardWidth, chessBoardHeight;
	
	
	public ChessBoardPanel(int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		allocationSpace(width, height);
		setLayout(null);
		
		chessBoardWidth = width;
		chessBoardHeight = height;
//		allocationSpace(width - 60, height - 60);
	}

	private void allocationSpace(int width, int height) {
		gridLength = Math.min(height / 4, width / 8);
		widthFromPanelEdge = (getWidth() - 8 * gridLength) / 2;
		heightFromPanelEdge = (getHeight() - 4 * gridLength) / 2;
	}

	private void drawBoardWidth(Graphics g) {
		for (int i = 0; i < 5; i++) {
			((Graphics2D) g).drawLine(widthFromPanelEdge, heightFromPanelEdge + gridLength * i, widthFromPanelEdge + gridLength * 8, heightFromPanelEdge + gridLength * i);
		}
	}

	private void drawBoardHeight(Graphics g) {
		for (int i = 0; i < 9; i++) {
			((Graphics2D) g).drawLine(widthFromPanelEdge + gridLength * i, heightFromPanelEdge, widthFromPanelEdge + gridLength * i, heightFromPanelEdge + gridLength * 4);
		}
	}

	protected void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon(getClass().getResource("/Image/board.png"));
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		drawBoardWidth(g);
		drawBoardHeight(g);
	}
	
	public int getChessBoardWidth() {
		return chessBoardWidth;
	}

	public int getChessBoardHeight() {
		return chessBoardHeight;
	}
	
	public int getGridLength() {
		return gridLength;
	}
	
	public int getWidthFromPanelEdge() {
		return widthFromPanelEdge;
	}
	
	public int getHeightFromPanelEdge() {
		return heightFromPanelEdge;
	}
}
