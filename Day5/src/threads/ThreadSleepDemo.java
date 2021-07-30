package threads;

class ThreadSleep implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++)	{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}
	
}

public class ThreadSleepDemo {

	public static void main(String[] args) {
		ThreadSleep run = new ThreadSleep();
		Thread thread1 = new Thread(run);
		Thread thread2 = new Thread(run);
		//thread1.setPriority(3); You can set by priority from 1-10. 1 being min and 10 being max
		//thread1.setName("name"); you can set the name of your threads
		thread1.start();
		thread2.start();

	}

}
