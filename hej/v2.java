package hej;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;


public class v2 {

	public static void main(String[] args) throws FileNotFoundException {
    
    Map<String, Integer> map = new HashMap<String, Integer>();

    Scanner scan = new Scanner(new File("skriv.txt"));
    
    scan.findWithinHorizon("\uFEFF", 1);											
    scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
    
    
    while(scan.hasNext()) {
        String ord = scan.next().toLowerCase(); 
        if(map.containsKey(ord)) {
            map.replace(ord, map.get(ord)+1);
        } else {
            map.put(ord, 1);
        }
    }

    Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
	List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

    WordCountComparator wcc = new WordCountComparator();

    
    wordList.sort(wcc);

    

    for(Map.Entry<String,Integer> word: wordList) {
        System.out.println(word);
    }
    
    }
}