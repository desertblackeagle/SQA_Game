package ui.chessGameRoom;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChineseChessBoard extends JPanel {

	int gridLength;
	int weightFromPanelEdge, heightFromPanelEdge;

	public ChineseChessBoard(int weight, int height) {
		// TODO Auto-generated constructor stub
		setSize(weight, height);
		allocationSpace(weight, height);
	}

	private void allocationSpace(int weight, int height) {
		gridLength = Math.min(height / 9, weight / 8);
		weightFromPanelEdge = (getWidth() - 8 * gridLength) / 2;
		heightFromPanelEdge = (getHeight() - 9 * gridLength) / 2;
	}

	private void drawBoardWeight(Graphics g) {
		for (int i = 0; i <= 10; i++) {
			((Graphics2D) g).drawLine(weightFromPanelEdge, heightFromPanelEdge + gridLength * i, weightFromPanelEdge + gridLength * 8, heightFromPanelEdge + gridLength * i);
		}
	}

	private void drawBoardHeight(Graphics g) {
		((Graphics2D) g).drawLine(weightFromPanelEdge, heightFromPanelEdge + 4 * gridLength, weightFromPanelEdge, heightFromPanelEdge + 5 * gridLength);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 8 * gridLength, heightFromPanelEdge + 4 * gridLength, weightFromPanelEdge + 8 * gridLength, heightFromPanelEdge + 5 * gridLength);
		for (int i = 0; i <= 8; i++) {
			((Graphics2D) g).drawLine(weightFromPanelEdge + gridLength * i, heightFromPanelEdge, weightFromPanelEdge + gridLength * i, heightFromPanelEdge + gridLength * 4);
		}

		for (int i = 0; i <= 8; i++) {
			((Graphics2D) g).drawLine(weightFromPanelEdge + gridLength * i, heightFromPanelEdge + gridLength * 5, weightFromPanelEdge + gridLength * i, heightFromPanelEdge + gridLength * 9);
		}
	}

	private void drawXLine(Graphics g) {
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength + 1, heightFromPanelEdge + 1, weightFromPanelEdge + 5 * gridLength, heightFromPanelEdge + 2 * gridLength);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength, heightFromPanelEdge + 2 * gridLength, weightFromPanelEdge + 5 * gridLength - 1, heightFromPanelEdge + 1);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength + 1, heightFromPanelEdge + 1, weightFromPanelEdge + 5 * gridLength, heightFromPanelEdge + 2 * gridLength);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength + 1, heightFromPanelEdge + 1, weightFromPanelEdge + 5 * gridLength, heightFromPanelEdge + 2 * gridLength);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength + 1, heightFromPanelEdge + 7 * gridLength + 1, weightFromPanelEdge + 5 * gridLength, heightFromPanelEdge + 9 * gridLength);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength, heightFromPanelEdge + 9 * gridLength, weightFromPanelEdge + 5 * gridLength - 1, heightFromPanelEdge + 1 + 7 * gridLength);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength + 1, heightFromPanelEdge + 1 + 7 * gridLength, weightFromPanelEdge + 5 * gridLength, heightFromPanelEdge + 9 * gridLength);
		((Graphics2D) g).drawLine(weightFromPanelEdge + 3 * gridLength + 1, heightFromPanelEdge + 1 + 7 * gridLength, weightFromPanelEdge + 5 * gridLength, heightFromPanelEdge + 9 * gridLength);
	}

	protected void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon("c:/b.jpg");
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		drawBoardWeight(g);
		drawBoardHeight(g);
		drawXLine(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(900, 900);
		ChineseChessBoard ccb = new ChineseChessBoard(800, 800);
		ccb.setBounds(10, 10, 800, 800);
		f.add(ccb);
	}

}
