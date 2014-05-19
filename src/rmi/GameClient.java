package rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.ServerInterface;
import data.chessPiece.ChessPieceList;
import data.player.Player;

public class GameClient {
	public ServerInterface s;
	private int beforeX, beforeY, afterX, afterY;
	private int room;
	private String chat;
	private String userToken, userSecretToken, rivalToken, rivalSecretToken;
	private ChessPieceList chessPieceList;
	private boolean action = false;
	
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
    /*還未加上的*/
//	public int connect(String UserToken) ;
//	public int connect(String UserToken,String rivalToken) ;
//	public String[][] updateChessBoardInfo(int roomNum,String UserToken) ;
	
	//room拉到上面
	public int getRoom() {
		room = -1;
		try {
			room = s.getRoomNum(userToken);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return room;
	}
	
	public boolean moveChess(){
		action = false;
		try{
			action = s.moveChess(room, userToken, beforeX, beforeY, afterX, afterY);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return action;
	}
	
	public String getRivalToken(){
		String rival = "";
		try{
			rival = s.getRivalToken(room);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return rival;
	}
	//聊天訊息放chat?
	public boolean chat(){
		action = false;
		try{
			action = s.chat(room, userToken, msg);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return action;
	}
	
	public boolean isTurnUser(){
		action = false;
		try{
			action = s.isTurnUser(room, userToken);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return action;
	}
	
	public boolean hasNewMsg(){
		action = false;
		try{
			action = s.hasNewMsg(room);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return action;
	}
	
	public String updateChat(){
		try{
			chat = s.updateChat(room);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return chat;
	}
	
	public int getScore(){
		int score = 0;
		try{
			score = s.getScore(room, userToken);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return score;
	}
	
	public boolean isWin(){
		try{
			action = s.isWin(room, userToken);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return action;
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

