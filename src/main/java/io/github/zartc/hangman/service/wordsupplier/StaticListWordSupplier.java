package io.github.zartc.hangman.service.wordsupplier;

import java.util.Random;


public class StaticListWordSupplier implements WordSupplier {
	private static final String[] WORDS = {
			"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
			"CASE", "CATCH", "CHAR", "CLASS", "CONST",
			"CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
			"ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
			"FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
			"IMPORT", "INSTANCEOF", "INT", "INTERFACE",
			"LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
			"PRIVATE", "PROTECTED", "PUBLIC", "RETURN",
			"SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH",
			"SYNCHRONIZED", "THIS", "THROW", "THROWS",
			"TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE"
	};

	private static final Random rnd = new Random();

	@Override
	public String nextWord() {
		return WORDS[rnd.nextInt(WORDS.length)];
	}
}

/* EOF */
