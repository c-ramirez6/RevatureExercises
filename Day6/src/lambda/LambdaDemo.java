package lambda;
//
//interface Rectangle	{
//	public void draw();
//}
//

/*
 * 1st way
 */
//class Test implements Rectangle	{
//
//	@Override
//	public void draw() {
//		System.out.println("Drawing...");
//		
//	}
//	
//}


interface Rectangle	{
	public void draw();
}

public class LambdaDemo {

	public static void main(String[] args) {
//		Test test = new Test();
//		test.draw();

		
		/*
		 * 2nd way
		 */
//		Rectangle rect = new Rectangle()	{
//			@Override
//			public void draw() {
//				System.out.println("Drawing...");
//				
//			}
//			
//		};
//		rect.draw();
//		
		
		/*
		 * 3rd way using lambda
		 */
		Rectangle rect = () ->	{
			System.out.println("Drawing...");
		};
		rect.draw();
		
	}

}
