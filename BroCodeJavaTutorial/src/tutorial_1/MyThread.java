package tutorial_1;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("this thread is running");
		
		if(this.isDaemon()) {
			System.out.println("this is deamon thread");
		} else {
			System.out.println("this is user thread");
		}
	}
}
