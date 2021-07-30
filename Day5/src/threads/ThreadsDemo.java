package threads;


class MultiThreadDemo extends Thread	{
	@Override
	public void run()	{
		System.out.println("Thread that extends thread is running...");
//		super.run();
	}
}


/*
 * implementing Runnable tends to be better because classes can only have 1 parent, but are not limited
 * in interfaces
 */
class MultiThread2 implements Runnable	{

	@Override
	public void run() {
		System.out.println("Thread that implements Runnable is running....");
		
	}
	
}

public class ThreadsDemo {

	public static void main(String[] args) {
		MultiThreadDemo demo = new MultiThreadDemo();
		demo.start();
		MultiThread2 demo2 = new MultiThread2();
//		demo2.run();
		Thread t1 = new Thread(demo2);
		t1.start();
		/*
		 * run() is used to perform an action for a thread
		 * start() used to start a newly created thread
		 */
		
		/*
		 * A threads life cycle has 4 states in it, but there is one we can add
		 * so total there are technically 5 states
		 * 1: New
		 * 2: Runnable
		 * 3: Running
		 * 4: Non-runnable (blocked) -- this is the 5th one we can add
		 * 5: Terminated
		 * Life cycle is controlled by the JVM
		 */
		
		MultiThread2 demo3 = new MultiThread2();
		Thread t2 = new Thread(demo3);	//New Thread
		t2.start();	//Runnable
		t2.run(); //Running state
		//When run method exits excecution we make it to terminated
		//non-runnable happens when thread is still alive but not eligable to run or is blocked
	}

}
