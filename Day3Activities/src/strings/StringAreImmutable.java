package strings;

public class StringAreImmutable {

	public static void main(String[] args) {
		//Immutable
		String str = "Hello";
		str.concat(" World!");
		System.out.println(str);
		
		//Immutable
		int num = 5;
		Math.addExact(num, 10);
		System.out.println(num);
		
		//Mutable
		StringBuilder str2 = new StringBuilder("Hello");
		str2.append(" World 2!");
		System.out.println(str2);
	}

}
