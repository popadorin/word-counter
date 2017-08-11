package models;

import interfaces.IWordCounting;

public class WordParser implements IWordCounting {
	
	private static WordParser INSTANCE = new WordParser();
	private WordParser() {}
	
	public static WordParser getInstance() {
		return INSTANCE;
	}
	
	@Override
	public Word[] getWords(String text) {
		// TODO Auto-generated method stub
		return null;
	}
}
