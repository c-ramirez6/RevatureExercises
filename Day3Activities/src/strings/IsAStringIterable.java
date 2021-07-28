package strings;

public class IsAStringIterable {

	public static void main(String[] args) {
		String str = "Hello World!";
		/*
		 * Does not work
		 */
//		for(char x : str) {
//			System.out.println(x);
//		}

		/*
		 * This would work though
		 */
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		/*
		 * Technically a string is not iterable
		 */

		StringBuilder strBuild = new StringBuilder("Hello World 2!");
		StringBuffer strBuff = new StringBuffer("Hello World 3!");
		//Interesting method
		StringBuilder strReverse = strBuild.reverse();
		System.out.println(strReverse);
//		for(char x : strBuild) {
//			
//		}
		
//		for(char x : strBuff) {
//			
//		}
		
		//None of these are iterable
	}

}
