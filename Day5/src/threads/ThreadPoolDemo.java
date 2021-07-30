package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread extends Thread	{
	
	private String message;
	public WorkerThread(String message) {
		this.message = message;
	}
	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName() + "Start Message ->" + message);
		processMessage();
		System.out.println("Thread: " + Thread.currentThread().getName() + "End Message ->" + message);
	}
	
	private void processMessage()	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ThreadPoolDemo {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 10; i++)	{
			Runnable wThread = new WorkerThread("" + i);
			es.execute(wThread);
		}
		es.shutdown();
		while(!es.isTerminated())	{
			
		}
		System.out.println("Finished all Threads");
	}

}
