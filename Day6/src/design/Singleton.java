package design;

class Calculator	{
	private static int count = 0;
	
	//instance of the class
	private static Calculator instance = null;
	
	private Calculator()	{
		count++;
		System.out.println("Count: " + count);
		System.out.println("Constructor Called");
	}
	
	public static Calculator getInstance() {
		if(instance == null)	{
			instance = new Calculator();
		}
		return instance;
	}
}

public class Singleton {

	public static void main(String[] args) {
//		Calculator calc = Calculator.getInstance();
//		Calculator calc2 = Calculator.getInstance();
		
//		Calculator calc4 = new Calculator();
//		Calculator calc5 = new Calculator();
//		Calculator calc6 = new Calculator();
//		Calculator calc7 = new Calculator();
		Calculator calc1 = Calculator.getInstance();
		Calculator calc2 = Calculator.getInstance();
		Calculator calc3 = Calculator.getInstance();

	}

}
