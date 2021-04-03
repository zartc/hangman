package io.github.zartc.hangman.service.keyreader;

import java.util.Scanner;


public class KeyReaderImpl implements KeyReader, AutoCloseable {
	protected final Scanner scanner;

	public KeyReaderImpl() {
		this.scanner = new Scanner(System.in);
	}

	public char readNext() {
		char c;

		do {
			c = scanner.next().charAt(0);
		} while (!isAcceptable(c));

		return normalize(c);
	}

	@Override
	public void close() throws Exception {
		try {
			scanner.close();
		} catch (Exception e) {
			// ignore error, and do nothing
		}
	}
}

/* EOF */
