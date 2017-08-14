package interfaces;

import java.util.ArrayList;

import models.Word;

public interface IWordCounting {
	public ArrayList<Word> getWords(String text);
}
