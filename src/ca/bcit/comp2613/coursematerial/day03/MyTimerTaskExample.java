package ca.bcit.comp2613.coursematerial.day03;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTaskExample extends TimerTask {
	public static final String RUNNING = "Running Task";

	@Override
	public void run() {
		System.out.println(RUNNING);
	}

	public static void main(String args[]) {
		TimerTask timerTask = new MyTimerTaskExample();
		// running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.schedule(timerTask, 5000);
		System.out.println("I wonder will this line be printed before "
				+ RUNNING);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I wonder will this line be printed before "
				+ RUNNING);
	}

}
