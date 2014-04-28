package control;

import java.util.Observable;
import java.util.Observer;

import data.chess.Chess;

public class TransferAbsoluteToXY implements Observer {
	private int width, height;

	public TransferAbsoluteToXY(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Chess) {
			int locX = (((Chess) arg).getAbsLocationX() + ((Chess) arg).getWidth() / 2);
			int locY = (((Chess) arg).getAbsLocationY() + ((Chess) arg).getWidth() / 2);
			System.out.println("Tran : " + (((Chess) arg).getAbsLocationX() + ((Chess) arg).getWidth() / 2) + " : " + (((Chess) arg).getAbsLocationY() + ((Chess) arg).getWidth() / 2));
			if (locX < 0 || locY < 0 || locX > width || locY > height) {
				((Chess) arg).goBack();
			}
		}
	}
}
