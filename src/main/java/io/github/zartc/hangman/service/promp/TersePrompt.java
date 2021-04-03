package io.github.zartc.hangman.service.promp;

import java.io.PrintStream;

import io.github.zartc.hangman.model.LetterBag;
import io.github.zartc.hangman.model.MaskedWord;
import io.github.zartc.hangman.model.Outcome;


public class TersePrompt implements Prompt {
	protected final PrintStream out;

	public TersePrompt(PrintStream out) {
		this.out = out;
	}

	@Override
	public void display(int remainingAttemptCount, MaskedWord maskedWord, LetterBag letterBag) {
		out.printf("%d   %s   > ", remainingAttemptCount, stretchWord(maskedWord.getMask()));
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
