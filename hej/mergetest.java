
package hej;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class mergetest {
	public static void main(String[] args) throws IOException{
		try {
			File fileread = new File(args[0]);
			Scanner myReader = new Scanner(fileread);
			Map<String, Integer> map = new HashMap<String, Integer>();
		 
			 
			 
			 myReader.findWithinHorizon("\uFEFF", 1);											
			 myReader.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
			 
			 
			 while(myReader.hasNext()) {
				 String ord = myReader.next().toLowerCase(); 
				 if(map.containsKey(ord)) {
					 map.replace(ord, map.get(ord)+1);
				 } else {
					 map.put(ord, 1);
				 }
			 }
		 
			 Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
			 
		 
			 WordCountComparator wcc = new WordCountComparator();
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
				List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
				wordList.sort(wcc);
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
