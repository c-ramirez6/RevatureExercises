package threads;

//Without synch
//class Table	{
//	public void printTable(int num)	{
//		for(int i = 0; i <= 10; i++)	{
//			System.out.println(num + " X " + i + "= " + (num * i));
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}

//Synch
class Table	{
	public synchronized void printTable(int num)	{
		for(int i = 0; i <= 10; i++)	{
			System.out.println(num + " X " + i + "= " + (num * i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread1 extends Thread	{
	Table table;
	public Thread1(Table table)	{
		this.table = table;
	}
	
	@Override
	public void run()	{
		table.printTable(5);
	}
}

class Thread2 extends Thread	{
	Table table;
	public Thread2(Table table)	{
		this.table = table;
	}
	
	@Override
	public void run() {
		table.printTable(500);
	}
}

public class Synchro {

	public static void main(String[] args) {
		Table t = new Table();
		Thread1 t1 = new Thread1(t);
		Thread2 t2 = new Thread2(t);
		t1.start();
		t2.start();

	}

}
