package control.observer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JPanel;

import ui.playRoom.ChessBoardPanel;
import ui.playRoom.PlayRoom;
import control.ChessGameObservable;
import data.chessPiece.ChessPiece;
import data.chessPiece.ChessPieceList;

public class ChessBoard extends ChessBoardPanel implements MouseMotionListener, MouseListener, Observer {
	int gridLength;
	int widthFromPanelEdge, heightFromPanelEdge;
	private ChessGameObservable gameObs;
	
	public ChessBoard(int width, int height) {
		// TODO Auto-generated constructor stub
		super(width, height);
		gameObs = new ChessGameObservable();
//		allocationSpace(width - 60, height - 60);
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
		if (o instanceof ChessPieceList) {
			if (arg instanceof ArrayList<?>) {
				for (ChessPiece chess : (ArrayList<ChessPiece>) arg) {
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
		gameObs.setChanged();
	}
	
	public void addObserver(Observer observer) {
		gameObs.addObserver(observer);
	}
	
	public int countObservers() {
		return gameObs.countObservers();
	}
	
	public void deleteObserver(Observer observer) {
		gameObs.deleteObserver(observer);
	}
	
	public void deleteObservers() {
		gameObs.deleteObservers();
	}
	
	public void notifyObservers() {
		gameObs.notifyObservers();
	}
	
	public void notifyObservers(Object o) {
		gameObs.notifyObservers(o);
	}
	
	public void notifyObservers(Observer observer) {
		gameObs.notifyObservers(observer);
	}
}
