package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.IWordCounting;

public class WordParser implements IWordCounting {
	
	private static WordParser INSTANCE = new WordParser();
	private WordParser() {}
	
	public static WordParser getInstance() {
		return INSTANCE;
	}
	
	@Override
	public ArrayList<Word> getWords(String text) {
		String[] tokens = text.split("\\s+"); // \\s+ is regex for at least one space or more
		int nrOfTokens = tokens.length;
		
		HashMap<String, Integer> dict = new HashMap<>(); // dict with word name key and frequency value
		for (String token : tokens) {
			if (dict.containsKey(token)) {
				dict.put(token, dict.get(token) + 1);
			} else {
				dict.put(token, 1);
			}
		}
		
		Set<String> keys = dict.keySet();
		ArrayList<Word> words = new ArrayList<>();
		
		for (String key : keys) {
			int value = dict.get(key);
			double rate = new Double(value) / nrOfTokens * 100;
			rate = Math.round(rate * 100) / 100.0;
			
			words.add(new Word(key, value, rate));
		}
		
		return words;
	}
	
}
