package io.github.zartc.hangman.service.promp;

import java.io.PrintStream;
import java.util.Arrays;

import io.github.zartc.hangman.model.LetterBag;
import io.github.zartc.hangman.model.MaskedWord;
import io.github.zartc.hangman.model.Outcome;


public class VerbosePrompt implements Prompt {
	protected final PrintStream out;

	public VerbosePrompt(PrintStream out) {
		this.out = out;
	}

	@Override
	public void display(int remainingAttemptCount, MaskedWord maskedWord, LetterBag letterBag) {
		out.printf("Remaining attempt %d  masked word: %s  tried letters: %s  what's your next letter > ",
				remainingAttemptCount, stretchWord(maskedWord.getMask()), Arrays.toString(letterBag.getConsumed()));
	}

	@Override
	public void display(Outcome outcome, MaskedWord maskedWord) {
		switch (outcome) {
			case WIN:
				out.print("Bravo, you win.\n");
				break;
			case LOSS:
				out.printf("You loose, better luck next time! The word was %s\n", maskedWord.getWord());
				break;
		}
	}
}

/* EOF */
