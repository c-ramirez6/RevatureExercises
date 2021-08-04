package generics;


/*
 * You can also make the class generic
 */
class Calculator<T>	{
	/*
	 * If you use Object you have unnessecary boxing and unboxing, and you lose type safety
	 * you are able to use different types of objects.
	 */
//	public boolean areEqual(Object a, Object b) {
//		if(a.equals(b))	{
//			return true;
//		}
//		return false;
//	}
	
	/*
	 * Same method but using Generics.  This method will be open to any object until one is use as an argument
	 * at that point that class will be what is required
	 */
//	public <E> boolean areEqual(E a, E b)	{
//		if(a.equals(b)) {
//			return true;
//		}
//		return false;
//	}
	
	public boolean areEqual(T a, T b) {
		if(a.equals(b)) {
			return true;
		}
		return false;
	}
	
	public int test(int a, int b) {
		return a+b;
	}
}

public class GenericDemo {

	public static void main(String[] args) {
		Calculator<Integer> calc = new Calculator<>();
		System.out.println(calc.areEqual(12, 12));
		System.out.println(calc.test(5, 7));
	}

}
