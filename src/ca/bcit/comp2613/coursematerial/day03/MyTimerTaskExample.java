package ca.bcit.comp2613.coursematerial.day03;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTaskExample extends TimerTask {
	public static boolean DONE = false;

	@Override
	public void run() {
		System.out.println("Done");
		DONE = true;
	}

	public static void main(String args[]) {
		TimerTask timerTask = new MyTimerTaskExample();
		// running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.schedule(timerTask, 5000);
		
		
		while (!DONE) {
			System.out.println("Ho hum, ho hum");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Bye");
	}

}
