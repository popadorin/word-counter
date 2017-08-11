package interfaces;

import models.Word;

public interface IWordCounting {
	public Word[] getWords(String text);
}
