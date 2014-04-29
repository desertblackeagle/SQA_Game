package ui.chessGameRoom;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.GameObservable;
import data.chess.Chess;
import data.chess.ChessBox;

public class TaiwanChessBoard extends JPanel implements MouseMotionListener, MouseListener, Observer {
	int gridLength;
	int widthFromPanelEdge, heightFromPanelEdge;
	private int chessBoardWidth, chessBoardHeight;
	private GameObservable obs;

	public TaiwanChessBoard(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(locationX, locationY);
		allocationSpace(width, height);
		setLayout(null);

		obs = new GameObservable();

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
		ImageIcon icon = new ImageIcon("c:/sqa/b.jpg");
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		float lineWidth = 3.25f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));

		drawBoardWidth(g);
		drawBoardHeight(g);
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int locX = (e.getX() + ((JComponent) e.getSource()).getLocation().x - ((JComponent) e.getSource()).getWidth() / 2);
		int locY = (e.getY() + ((JComponent) e.getSource()).getLocation().y - ((JComponent) e.getSource()).getHeight() / 2);
		setComponentZOrder(((JComponent) e.getSource()), 0);
		((JComponent) e.getSource()).setLocation(locX, locY);
//		System.out.println(locX + " " + locY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getX() + " " + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int locX = (e.getX() + ((JComponent) e.getSource()).getLocation().x);
		int locY = (e.getY() + ((JComponent) e.getSource()).getLocation().y);
		setChanged();
		notifyObservers(((JComponent) e.getSource()));
		System.out.println(locX + " : " + locY);
	}

	// observer //

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof ChessBox) {
			if (arg instanceof ArrayList<?>) {
				for (Chess chess : (ArrayList<Chess>) arg) {
					add(chess);
					chess.addMouseListener(this);
					chess.addMouseMotionListener(this);
				}
				repaint();
				revalidate();
			}
		}
	}

	public void setChanged() {
		obs.setChanged();
	}

	public void addObserver(Observer observer) {
		obs.addObserver(observer);
	}

	public int countObservers() {
		return obs.countObservers();
	}

	public void deleteObserver(Observer observer) {
		obs.deleteObserver(observer);
	}

	public void deleteObservers() {
		obs.deleteObservers();
	}

	public void notifyObservers() {
		obs.notifyObservers();
	}

	public void notifyObservers(Object o) {
		obs.notifyObservers(o);
	}

	public void notifyObservers(Observer observer) {
		obs.notifyObservers(observer);
	}

	public int getChessBoardWidth() {
		return chessBoardWidth;
	}

	public int getChessBoardHeight() {
		return chessBoardHeight;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame f = new JFrame();
//		f.setVisible(true);
//		f.setLayout(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(900, 920);
//		TaiwanChessBoard ccb = new TaiwanChessBoard(10, 10, 800, 800);
//		f.add(ccb);
//	}

}
