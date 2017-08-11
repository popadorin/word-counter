package models;

public class MainTest {
	public static void main(String[] args) {
		Word word1 = new Word("Jora", 5, 21.5);
		Word word2 = new Word("Fedea", 3, 24.6);
		Word word3 = new Word("grisha", 5, 21.5);
		Word word4 = new Word("aleosha", 9, 9.8);
		
		Word[] words = {word1, word2, word3, word4};
		
		for (Word word : words) {
			System.out.println(word.getName());
		}
	}
}
