package data.chessPiece;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/* 
 * add chess in ArrayList
 * initChessPiece
 */
public class ChessPieceList extends Observable implements Observer {
	private ChessPiece temp;
	private ChessPiece cover;
	private ChessPieceLocation chessBoardLoc;
	private ArrayList<ChessPiece> chessPieceList;
	private Thread updateChessBoard;
	boolean canMove = true;

	public ChessPieceList(ChessPieceLocation chessBoardLoc) {
		this.chessBoardLoc = chessBoardLoc;
		chessPieceList = new ArrayList<ChessPiece>();
		initChessPiece();
		// TODO Auto-generated constructor stub
	}

	public void initChessPiece() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				cover = new ChessPiece(chessBoardLoc.getChessLocation(i, j), i, j, -1, chessBoardLoc.getGridLength(), "cover", chessBoardLoc);
				chessPieceList.add(cover);
			}
		}
		
		setChanged();
		notifyObservers(chessPieceList);
	}
	
	public void setChessPiece(int color, String[][] chessBoard) {
		
		chessPieceList.removeAll(chessPieceList);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				if (!chessBoard[i][j].equals("NULL")) {
					cover = new ChessPiece(chessBoardLoc.getChessLocation(i, j), i, j, -1, chessBoardLoc.getGridLength(), chessBoard[i][j], chessBoardLoc);
					chessPieceList.add(cover);
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
			// System.out.println("x: " + ((ChessPiece) arg).getBeforeX() +
			// " to " + ((ChessPiece) arg).getAfterX());
			
//			System.out.println("Tran : " + locX + " : " + locY);
//			System.out.println("chessBoardLoc.getBoardWidth() : " + chessBoardLoc.getBoardWidth());
			// System.out.println("locX: " + locX);
			if (locX < 0 || locY < 0 || locX > chessBoardLoc.getBoardWidth() || locY > chessBoardLoc.getBoardHeight()) {
				((ChessPiece) arg).goBack();
//				System.out.println("123");
			} else if (canMove) {
				
				setChessPiece(-1, updateChessBoardInfo());
				canMove = false;
//				((ChessPiece) arg).setChessToXY(((ChessPiece) arg).getAfterX(), ((ChessPiece) arg).getAfterY());
			} else {
				((ChessPiece) arg).goBack();
			}
		}
	}
	
	public String[][] updateChessBoardInfo() {
		String[][] chesses = new String[8][4];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				chesses[i][j] = "cover";
			}
		}
		chesses[0][0] = "NULL";
		chesses[1][3] = "redHorse";
		return chesses;
	}
	
	private void updateChessBoard() {
		updateChessBoard = new Thread(new Runnable() {
		boolean turnAnother = true;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (turnAnother) {
						Thread.sleep(1000 * 1);
						// update chess board start
						setChessPiece(-1, updateChessBoardInfo());
						canMove = false;
						// update chess board end
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		updateChessBoard.start();
	}
}
