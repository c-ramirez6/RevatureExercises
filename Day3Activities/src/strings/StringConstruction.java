package strings;

public class StringConstruction {

	public static void main(String[] args) {
		/*
		 * Ways to construct a String
		 * String objects are immutable, which means they can't be changed
		 * when assigning a new value to a String variable, it will create a new string and point to it
		 * the old string is left in the String constant pool
		 */
		String str = "Hello!";
		char[] charString = {'h', 'e', 'l', 'l', 'o', '!'};
		String str2 = new String(charString);
		String str3 = new String("Hello World!");
		
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3);
		
		
		//StringBuilder is not synchronized
		//Empty StringBuilder
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("Hello!");
		//StringBuilder with initialized value
		StringBuilder strBuild2 = new StringBuilder("Hello Worlds!");
		//StringBuilder with explicitly defined capacity.
		StringBuilder strBuild3 = new StringBuilder(10);
		
		//The same for StringBuffer, but StringBuffer is synchronized

	}

}
