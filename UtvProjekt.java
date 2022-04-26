package Labb5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class UtvProjekt {
	
	private Set<String> stopwords;
	private Map<String, Integer> m = new HashMap<String,Integer>();
		
	
	public UtvProjekt(Set scan){
		this.stopwords = scan;
	}

	
	public void process(String word) {					//Jämför och räknar ett ord.	
		if(stopwords.contains(word) == false) {		//Ifall itererat ord inte finns i stopwords så fortsätter vi
			if(m.containsKey(word)) {							//Ifall ordet redan är räknat och tillagt i vår map, där vi sparar räkningen, 2 fall:
				m.replace(word, m.get(word) + 1);		//Fall 1: Räkna upp befintligt ord med 1

					}else {
							m.put(word, 1);							//Fall 2: det läggs till med räkningen 1
							}
			}
		}
	
	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = m.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());						//TA EN TITT PÅ, FICK DET AV KURSHANDLEDARE
		
		for(int i = 0; i<=15; i++) {
			System.out.println(wordList.get(i));
			}
		}
	

}
