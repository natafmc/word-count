package com.nata.main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


	static void counter(String fileName, Map<String, Integer> words) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		while(file.hasNext()) {
			String word = file.next();
			Integer count = words.get(word);
			if(count != null) {
				count++;
			}else {
				count = 1;
			}
			words.put(word, count);
		}
		file.close();
	}
    public static void main(String[] args) throws FileNotFoundException{
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	counter(".\\test.txt", map);
    	//System.out.println(map);
    	map.entrySet()
	  	  .stream()
	  	  .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	  	  .forEach(System.out::println);
    }

}
