package io.github.zartc.hangman.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


class LetterBagTest {

	@Test
	void do_not_consume_same_char_twice() {
		LetterBag letterBag = new LetterBag();

		letterBag.consume('a');
		letterBag.consume('a');

		assertThat(letterBag.getConsumed()).hasSize(1).containsExactly('a');
	}

	@Test
	void first_time_consume_returns_true() {
		LetterBag letterBag = new LetterBag();

		boolean retVal = letterBag.consume('a');

		assertThat(retVal).isTrue();
	}

	@Test
	void second_time_consume_returns_false() {
		LetterBag letterBag = new LetterBag();

		letterBag.consume('a');
		boolean retVal = letterBag.consume('a');

		assertThat(retVal).isFalse();
	}

	@Test
	void record_consumed_chars() {
		LetterBag letterBag = new LetterBag();

		letterBag.consume('a');
		letterBag.consume('c');
		letterBag.consume('d');
		letterBag.consume('b');

		assertThat(letterBag.getConsumed()).hasSize(4).containsExactly('a', 'b', 'c', 'd');
	}
}

/* EOF */
