package ui.chessGameRoom;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TaiwanChessBoard extends JPanel {
	int gridLength;
	int weightFromPanelEdge, heightFromPanelEdge;

	public TaiwanChessBoard(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		allocationSpace(width, height);
	}

	private void allocationSpace(int width, int height) {
		gridLength = Math.min(height / 4, width / 9);
		weightFromPanelEdge = (getWidth() - 9 * gridLength) / 2;
		heightFromPanelEdge = (getHeight() - 4 * gridLength) / 2;
	}

	private void drawBoardWeight(Graphics g) {
		for (int i = 0; i < 5; i++) {
			((Graphics2D) g).drawLine(weightFromPanelEdge, heightFromPanelEdge + gridLength * i, weightFromPanelEdge + gridLength * 9, heightFromPanelEdge + gridLength * i);
		}
	}

	private void drawBoardHeight(Graphics g) {
		for (int i = 0; i < 10; i++) {
			((Graphics2D) g).drawLine(weightFromPanelEdge + gridLength * i, heightFromPanelEdge, weightFromPanelEdge + gridLength * i, heightFromPanelEdge + gridLength * 4);
		}
	}

	protected void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon("c:/sqa/b.jpg");
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		drawBoardWeight(g);
		drawBoardHeight(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(900, 920);
		TaiwanChessBoard ccb = new TaiwanChessBoard(10, 10, 800, 800);
		f.add(ccb);
	}

}
