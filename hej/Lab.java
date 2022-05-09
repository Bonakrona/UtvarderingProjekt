
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Lab {
	public static void main(String[] args) throws IOException{
		try {
			File fileread = new File(args[0]);
			Scanner myReader = new Scanner(fileread);
			LinkedList<Integer> read = new LinkedList<Integer>();
			
			while (myReader.hasNextLine()) {	
				read.add(Integer.parseInt(myReader.nextLine()));
			}
			myReader.close();
			//System.out.print(read.peekFirst());
			
			File result = new File(args[1]);
			result.createNewFile();
			FileOutputStream fos = new FileOutputStream(result);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("Index, tid");
			bw.newLine();

			
			for(int i = 1; i<=Integer.parseInt(args[2]); i++) {
				long start = System.nanoTime();
				LinkedList<Integer> temp = new LinkedList<Integer>(read);
				new ListSorter(temp);
				//Collections.sort(read);
				long finish = System.nanoTime();
				long timeElapsed = finish - start;
				bw.write(i + ",   " + timeElapsed);
				bw.newLine();
			}
			bw.close();

		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
}
