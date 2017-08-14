package models;

import java.util.ArrayList;
import java.util.Collections;

public class MainTest {
	public static void main(String[] args) {
		WordParser wp = WordParser.getInstance();
		
		String text = "I love meat and meat loves me";
		
		ArrayList<Word> words = wp.getWords(text);
		
		System.out.println("....................................");
		Collections.sort(words, (w1, w2) -> w2.getFrequency() - w1.getFrequency());
		
		words.forEach(System.out::println);
	}
}
