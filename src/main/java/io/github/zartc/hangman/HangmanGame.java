package io.github.zartc.hangman;

import io.github.zartc.hangman.model.LetterBag;
import io.github.zartc.hangman.model.MaskedWord;
import io.github.zartc.hangman.model.Outcome;
import io.github.zartc.hangman.service.keyreader.KeyReader;
import io.github.zartc.hangman.service.promp.Prompt;


public class HangmanGame {
	private final Prompt prompt;
	private final KeyReader keyReader;

	HangmanGame(KeyReader keyReader, Prompt prompt) {
		this.prompt = prompt;
		this.keyReader = keyReader;
	}

	public void run(String word, int maxAttempt) {
		int remainingAttemptCount = maxAttempt;
		MaskedWord maskedWord = new MaskedWord(word);

		LetterBag letterBag = new LetterBag();

		while (remainingAttemptCount > 0) {
			prompt.display(remainingAttemptCount, maskedWord, letterBag);

			if (maskedWord.isDiscovered()) {
				prompt.display(Outcome.WIN, maskedWord);
				return;
			}

			char c = keyReader.readNext();

			if (letterBag.consume(c)) {
				if (maskedWord.matches(c) == 0) {
					--remainingAttemptCount;
				}
			}
		}

		prompt.display(Outcome.LOSS, maskedWord);
	}
}

/* EOF */
