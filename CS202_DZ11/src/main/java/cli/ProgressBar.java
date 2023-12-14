package cli;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProgressBar implements Runnable {
	private int total, length;
	private Condition update, updated;
	private Lock lock;
	private String message;
	
	public ProgressBar(int total, int length, String message, Lock lock, Condition update, Condition updated) {
		this.update = update;
		this.updated = updated;
		this.lock = lock;
		this.total = total;
		this.length = length;
		this.message = message;
	}

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
		int percent = (int) Math.ceil(q * 100);
		int chars = (int) Math.ceil(q * length); 

		String line = "[ "  + "=".repeat(chars) + " ".repeat(length - chars) + " ]" + percent + "%";

		System.out.print("\r");
		System.out.print(line);
		System.out.flush();
	}

}
