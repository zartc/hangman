package io.github.zartc.hangman.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class LetterBag {
	private final Set<Character> consumed = new HashSet<>();

	/**
	 * Register the use of a character.
	 *
	 * @return true if the character c was never used yet, false otherwise.
	 */
	public boolean consume(char c) {
		return consumed.add(c);
	}

	public Character[] getConsumed() {
		Character[] characters = consumed.toArray(new Character[0]);
		Arrays.sort(characters);
		return characters;
	}
}

/* EOF */
