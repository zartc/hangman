package io.github.zartc.hangman;

import io.github.zartc.hangman.service.keyreader.KeyReaderImpl;
import io.github.zartc.hangman.service.promp.ConsoleTersePrompt;
import io.github.zartc.hangman.service.promp.Prompt;
import io.github.zartc.hangman.service.wordsupplier.StaticListWordSupplier;


public class HangmanGameMain {

	public static void main(String[] args) throws Exception {
		// possible improvements:
		// check the args looking for a selector indicating which word list to use.
		// check the args looking for a selector (easy, normal, hard) to set the maxAttempt value.
		// run in a loop so that the game does not quit right after a single run.

		// possible evolutions:
		// replace the console KeyReader and prompt by a graphical IHM
		try (KeyReaderImpl keyReader = new KeyReaderImpl()) {
			String word = new StaticListWordSupplier().nextWord();
			Prompt prompt = new ConsoleTersePrompt();

			new HangmanGame(keyReader, prompt).run(word, 10);
		}
	}
}

/* EOF */
