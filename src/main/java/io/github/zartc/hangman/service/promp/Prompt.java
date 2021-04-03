package io.github.zartc.hangman.service.promp;

import io.github.zartc.hangman.model.LetterBag;
import io.github.zartc.hangman.model.MaskedWord;
import io.github.zartc.hangman.model.Outcome;


public interface Prompt {
	void display(int remainingAttemptCount, MaskedWord maskedWord, LetterBag letterBag);
	void display(Outcome outcome, MaskedWord maskedWord);

	default String stretchWord(String word) {
		StringBuilder sb = new StringBuilder();

		for (byte c : word.getBytes()) {
			sb.append((char)c).append(" ");
		}

		sb.deleteCharAt(sb.length() - 1); // remove the last " " char

		return sb.toString();
	}
}

/* EOF */
