package status;

import javax.swing.JLabel;

public class PlayRemainingTime {

	private Thread timeCalc;
	private JLabel time;

	public PlayRemainingTime(JLabel time) {
		// TODO Auto-generated constructor stub
		this.time = time;
		initThread();
	}

	private void initThread() {
		timeCalc = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (Integer.valueOf(time.getText()) < 10) {
						Thread.sleep(1000);
						int i = Integer.valueOf(time.getText());
						time.setText(String.valueOf(i + 1));
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		timeCalc.start();
	}

}
