package Labb5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//import re
//string = open('a.txt').read()
//new_str = re.sub('[^a-zA-Z0-9\n\.]', ' ', string)
//open('b.txt', 'w').write(new_str)

public class mainutv5 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));     //Skannar undantagsord
		scan.findWithinHorizon("\uFEFF", 1);											//Tar bort onödiga tecken
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		Set<String> stopwords = new HashSet<String>();
		
		while(scan.hasNext()) {
			stopwords.add(scan.next());
			}
		
		UtvProjekt counter = new UtvProjekt(stopwords);						//Skapar räknare med undantagsord som parameter
		Scanner s = new Scanner(new File("nilsholg.txt"));						//Läser in texten som skall räknas
		s.findWithinHorizon("\uFEFF", 1);													//Tar bort onödiga tecken från texten
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");

		while (s.hasNext()) {																		//Medans ord finns kvar i texten, iterera till nästa.	
			String word = s.next().toLowerCase();										//Till små bokstäver
			counter.process(word);																//Kör ordet genom process, alltså jämför och ev. räkna upp
			}

		s.close();

		counter.report();
		
		
		}
}
