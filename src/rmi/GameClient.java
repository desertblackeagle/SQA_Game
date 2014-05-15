package rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.ServerInterface;
import data.chessPiece.ChessPieceList;

public class GameClient {
	public ServerInterface s;
	private int beforeX, beforeY, afterX, afterY;
	private String chat;
	private String userToken, userSecretToken, rivalToken, rivalSecretToken;
	private ChessPieceList chessPieceList;
	
	public GameClient() {
		try {
			s = (ServerInterface) Naming.lookup("rmi://127.0.0.1/ChessGame");
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getRoom() {
		int room;
		room = -1;
		try {
			room = s.getRoomNum(userToken);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return room;
	}
	
//	public static void main(String args[])
//	{
//		d = null;
//		try {
//			d = (ServerInterface) Naming.lookup("rmi://127.0.0.1/arithmetic");
//			System.out.println("check A : " + d.check("123", "201401"));
//			System.out.println("check B : " + d.check("456", "201402"));
//			System.out.println("random connect A (rom num) : " + c.connect("123"));
//			System.out.println("random connect B (rom num) : " + c.connect("456"));
//			int roomNum = d.connect("123", "456");
//			System.out.println("connect A & B (rom num): " + roomNum);
//			System.out.println("A move chess : " + d.moveChess(roomNum, "123", 0, 0, 1, 3));
//			System.out.println("A update : ");
//			for (int i = 0; i < 4; i++) {
//				for (int j = 0; j < 8; j++) {
//					System.out.print(d.updateChessBoardInfo(roomNum, "123")[i][j] + " ");
//				}
//				System.out.println();
//			}
//		}catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

