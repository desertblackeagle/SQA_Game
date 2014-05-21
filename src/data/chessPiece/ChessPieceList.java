package data.chessPiece;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import rmi.GameClient;

/* 
 * add chess in ArrayList
 * initChessPiece
 * update chess board
 */
public class ChessPieceList extends Observable implements Observer {
	private ChessPiece temp;
	private ChessPieceLocation chessBoardLoc;
	private ArrayList<ChessPiece> chessPieceList;
	private Thread updateChessBoard;
	private GameClient server;
	private String userToken;

	public ChessPieceList(ChessPieceLocation chessBoardLoc, GameClient server, String userToken) {
		this.userToken = userToken;
		this.server = server;
		this.chessBoardLoc = chessBoardLoc;
		chessPieceList = new ArrayList<ChessPiece>();
		initChessPiece();
//		updateChessBoard();
		// TODO Auto-generated constructor stub
	}

	public void initChessPiece() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				temp = new ChessPiece(chessBoardLoc.getChessLocation(i, j), i, j, -1, chessBoardLoc.getGridLength(), "cover", chessBoardLoc);
				chessPieceList.add(temp);
			}
		}
		
		setChanged();
		notifyObservers(chessPieceList);
	}
	
	public void setChessPiece(String[][] chessBoard) {
		chessPieceList.removeAll(chessPieceList);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				if (!chessBoard[i][j].equals("NULL")) {
					temp = new ChessPiece(chessBoardLoc.getChessLocation(i, j), i, j, -1, chessBoardLoc.getGridLength(), chessBoard[i][j], chessBoardLoc);
					chessPieceList.add(temp);
				}
			}
		}
		setChanged();
		notifyObservers(chessPieceList);
	}

	public ArrayList<ChessPiece> getChessList() {
		return chessPieceList;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		if (arg instanceof ChessPiece) {
			int locX = (((ChessPiece) arg).getFrameX() + ((ChessPiece) arg).getGrid() / 2);
			int locY = (((ChessPiece) arg).getFrameY() + ((ChessPiece) arg).getGrid() / 2);
			int beforeX = ((ChessPiece) arg).getBeforeX();
			int beforeY = ((ChessPiece) arg).getBeforeY();
			int afterX = ((ChessPiece) arg).getAfterX();
			int afterY = ((ChessPiece) arg).getAfterY();
			
			if (locX < 0 || locY < 0 || locX > chessBoardLoc.getBoardWidth() || locY > chessBoardLoc.getBoardHeight()) {
				((ChessPiece) arg).goBack();
			} else {
				try {
					if (server.s.moveChess(server.getRoom(), userToken, beforeX, beforeY, afterX, afterY)) {
						setChessPiece(server.s.updateChessBoardInfo(server.getRoom(), userToken));
					} else {
						((ChessPiece) arg).goBack();
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
//	
//	public String[][] updateChessBoardInfo() {
//		String[][] chesses = new String[8][4];
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 4; j++) {
//				chesses[i][j] = "cover";
//			}
//		}
//		chesses[0][0] = "NULL";
//		chesses[1][3] = "redHorse";
//		return chesses;
//	}
	
	private void updateChessBoard() {
		updateChessBoard = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (!server.s.isTurnUser(server.getRoom(), userToken)) {
						Thread.sleep(1000 * 1);
						// update chess board start
						setChessPiece(server.s.updateChessBoardInfo(server.getRoom(), userToken));
						// update chess board end
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		updateChessBoard.start();
	}
}
