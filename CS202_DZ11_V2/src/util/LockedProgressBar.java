package util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import javafx.scene.control.ProgressBar;

public class LockedProgressBar extends ProgressBar implements Runnable {
	private int total, length;
	private Condition update, updated;
	private Lock lock;
	private String message;

	public LockedProgressBar(int total, int length, String message, Lock lock, Condition update, Condition updated) {
		super();
		this.update = update;
		this.updated = updated;
		this.lock = lock;
		this.total = total;
		this.length = length;
		this.message = message;
	}
	
	@Override
	public void run() {
		this.lock.lock();
		try {
			System.out.println(message);
			for(int i = 1; i <= this.total; i++) {
				drawProgress(i);
				update.await();
				updated.signal();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted.");
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
	
	public void drawProgress(double v) {
		double q = v / (double) total; 
		this.setProgress(q);
	}
	
}
