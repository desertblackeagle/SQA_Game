package status;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PlayingRemindMessage {
	private Thread tooNight;
	private Thread playTooLong;

	public PlayingRemindMessage() {
		// TODO Auto-generated constructor stub

//		Calendar date = Calendar.getInstance();
//		date.setTime(new Date());
//		date.add(Calendar.SECOND, 5);
//
//		Timer t = new Timer();
//		t.schedule(new DailyRun(), date.getTime(), 1000*3);

//		tooNightToPlay();
		playTooLongTime();
	}

	private void playTooLongTime() {
		playTooLong = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
//					int tmp = 60;
					Date d = new Date();
					while (true) {
						d = new Date();
						System.out.println(d.getHours()+" : "+d.getMinutes()+" : "+d.getSeconds());
						Thread.sleep(1000 * 5);
//						System.out.println(tmp + "秒過了");
//						tmp += 60;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		playTooLong.start();
	}

	private void tooNightToPlay() {
		tooNight = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayingRemindMessage t = new PlayingRemindMessage();
	}

}

class DailyRun extends TimerTask {
	public DailyRun() {
	}

	public void run() {
// 這裡是要執行的程式內容 
		System.out.println("1");
	} // End of method

} // end of class 