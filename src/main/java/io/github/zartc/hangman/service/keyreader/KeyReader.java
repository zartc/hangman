package io.github.zartc.hangman.service.keyreader;

public interface KeyReader {

	char readNext();

	default boolean isAcceptable(char c) {
		return Character.isLetter(c);
	}

	default char normalize(char c) {
		return Character.toUpperCase(c);
	}
}

/* EOF */
