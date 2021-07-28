package exceptions;

import java.io.FileOutputStream;

class Test	{

}

public class TryResources {

	public static void main(String[] args) {
		try(FileOutputStream file = new FileOutputStream("test.txt")){
			String str = "Hello World!";
			byte[] data = str.getBytes();
			file.write(data);
					
		}	catch(Exception e)	{
			System.out.println(e.getMessage());
		}

	}

}
