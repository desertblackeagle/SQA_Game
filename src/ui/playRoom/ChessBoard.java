package ui.playRoom;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;
import control.ChessGameObservable;
import data.chessPiece.ChessPiece;
import data.chessPiece.ChessPieceList;

public class ChessBoard extends ChessBoardPanel implements MouseMotionListener, MouseListener, Observer {
	private int grid;
	private int X, Y, toX, toY;
	private ChessGameObservable gameObs;
	
	public ChessBoard(int width, int height) {
		// TODO Auto-generated constructor stub
		super(width, height);
		gameObs = new ChessGameObservable();
//		allocationSpace(width - 60, height - 60);
	}
	public ChessBoard(int locationX, int locationY, int width, int height) {
		// TODO Auto-generated constructor stub
		super(width, height);
		setLocation(locationX, locationY);
		gameObs = new ChessGameObservable();
//		allocationSpace(width - 60, height - 60);
	}
	
	public ChessGameObservable getChessGameObservable() {
		return gameObs;
	}
	
//	public int getBeforeX() {
//		return (X - getWidthFromPanelEdge()) / getGridLength();
//	}
//	
//	public int getBeforeY() {
//		return (Y - getHeightFromPanelEdge()) / getGridLength();
//	}
//	
//	public int getAfterX() {
//		return (toX - getWidthFromPanelEdge()) / getGridLength();
//	}
//	
//	public int getAfterY() {
//		return (toY - getHeightFromPanelEdge()) / getGridLength();
//	}
//	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int locX = (e.getX() + ((JComponent) e.getSource()).getLocation().x - grid / 2);
		int locY = (e.getY() + ((JComponent) e.getSource()).getLocation().y - grid / 2);
		setComponentZOrder(((JComponent) e.getSource()), 0);
		((JComponent) e.getSource()).setLocation(locX, locY);
//		System.out.println("Dragged: " + locX + " : " + locY);
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
	public void mousePressed(MouseEvent e) { //mouse location
		// TODO Auto-generated method stub
		X = (e.getX() + ((ChessPiece) e.getSource()).getLocation().x);
		Y = (e.getY() + ((ChessPiece) e.getSource()).getLocation().y);
		((ChessPiece) e.getSource()).setBeforeX((X - getWidthFromPanelEdge()) / getGridLength());
		((ChessPiece) e.getSource()).setBeforeY((Y - getHeightFromPanelEdge()) / getGridLength());
//		System.out.println("Pressed: " + (X - getWidthFromPanelEdge()) / getGridLength() + " : " + Y/getGridLength());
//		System.out.println("GridLength: " + getGridLength() + "grid: " + grid);
//		System.out.println("WidthFromPanelEdge: " + getWidthFromPanelEdge());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) { //mouse location
		// TODO Auto-generated method stub
		toX = (e.getX() + ((ChessPiece) e.getSource()).getLocation().x);
		toY = (e.getY() + ((ChessPiece) e.getSource()).getLocation().y);
		
		((ChessPiece) e.getSource()).setAfterX((toX - getWidthFromPanelEdge()) / getGridLength());
		((ChessPiece) e.getSource()).setAfterY((toY - getHeightFromPanelEdge()) / getGridLength());
		gameObs.setChanged();
		gameObs.notifyObservers(((JComponent) e.getSource()));
//		System.out.println("Released: " + toX + " : " + toY);
	}
	
	// observer //
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		removeAll();
		if (o instanceof ChessPieceList) {
			if (arg instanceof ArrayList<?>) {
				for (ChessPiece chess : (ArrayList<ChessPiece>) arg) {
					this.grid = chess.getGrid();
					add(chess);
					if (!chess.getChessName().equals("cover")) {
						chess.addMouseMotionListener(this);
					}
					chess.addMouseListener(this);
				}
				repaint();
				revalidate();
			}
		}
	}
}
