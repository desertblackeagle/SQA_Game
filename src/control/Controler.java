package control;

public class Controler {
	private TransferAbsoluteToXY transferAbsoluteToXY;

	public Controler(int width, int height) {
		// TODO Auto-generated constructor stub
		transferAbsoluteToXY = new TransferAbsoluteToXY( width,  height);
	}

	public TransferAbsoluteToXY getTransferAbsoluteToXY() {
		return transferAbsoluteToXY;
	}

}
