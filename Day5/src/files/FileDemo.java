package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("data.txt");
		int count = 0;
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File " + file.getName() + " Has been created");
		try {
			FileWriter writer = new FileWriter(file.getName(), true);
			for(int i = 0; i <= 25; i++)	{
				int rand = (int)(Math.random() * 100);
				writer.write(String.valueOf(rand));
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Scanner fileReader = new Scanner(file);
			while(fileReader.hasNextLine()) {
				System.out.println(fileReader.nextLine());
				count++;
				if(count >= 150)	{
					file.deleteOnExit();
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
