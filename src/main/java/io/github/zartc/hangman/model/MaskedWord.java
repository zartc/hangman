package io.github.zartc.hangman.model;

import java.util.Arrays;


public class MaskedWord {
	private final char[] word;
	private final char[] mask;


	public MaskedWord(String word) {
		this.word = word.toCharArray();
		this.mask = new char[this.word.length];
		for (int i = 0; i < mask.length; i++) {
			this.mask[i] = '_';
		}
	}

	/**
	 * Reveal any emplacement in the masked word matching the letter.
	 *
	 * @param c the letter
	 *
	 * @return the number of match
	 */
	public int matches(char c) {
		int matches = 0;

		for (int i = 0; i < word.length; i++) {
			if (word[i] == c) {
				mask[i] = c;
				matches++;
			}
		}

		return matches;
	}

	public boolean isDiscovered() {
		return Arrays.equals(mask, word);
	}

	public String getMask() {
		return new String(mask);
	}

	public String getWord() {
		return new String(word);
	}
}

/* EOF */
