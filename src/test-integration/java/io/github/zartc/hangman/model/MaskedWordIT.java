package io.github.zartc.hangman.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


class MaskedWordIT {

	@Test
	public void match_characters_in_masked_word() {
		MaskedWord maskedWord = new MaskedWord("abc");

		assertThat(maskedWord.matches('a')).isEqualTo(1);
		assertThat(maskedWord.matches('b')).isEqualTo(1);
		assertThat(maskedWord.matches('c')).isEqualTo(1);
	}

	@Test
	public void do_not_match_characters_not_in_masked_word() {
		MaskedWord maskedWord = new MaskedWord("abc");

		assertThat(maskedWord.matches('d')).isEqualTo(0);
		assertThat(maskedWord.matches('e')).isEqualTo(0);
		assertThat(maskedWord.matches('f')).isEqualTo(0);
	}

	@Test
	public void match_characters_in_masked_word_multiple_time() {
		MaskedWord maskedWord = new MaskedWord("aaa");

		assertThat(maskedWord.matches('a')).isEqualTo(3);
	}

	@Test
	public void isDiscovered_is_false_while_the_word_is_not_discovered() {
		MaskedWord maskedWord = new MaskedWord("abc");
		assertThat(maskedWord.isDiscovered()).isFalse();

		maskedWord.matches('a');
		maskedWord.matches('b');

		assertThat(maskedWord.isDiscovered()).isFalse();
	}

	@Test
	public void isDiscovered_is_true_when_the_word_is_discovered() {
		MaskedWord maskedWord = new MaskedWord("abc");
		assertThat(maskedWord.isDiscovered()).isFalse();

		maskedWord.matches('a');
		maskedWord.matches('b');
		maskedWord.matches('c');

		assertThat(maskedWord.isDiscovered()).isTrue();
	}

	@Test
	public void getWord_isCorrect() {
		MaskedWord maskedWord = new MaskedWord("hangman");

		assertThat(maskedWord.getWord()).isEqualTo("hangman");
	}

	@Test
	public void getMask_isCorrect() {
		MaskedWord maskedWord = new MaskedWord("hangman");

		assertThat(maskedWord.getMask()).isEqualTo("_______");

		maskedWord.matches('a');
		assertThat(maskedWord.getMask()).isEqualTo("_a___a_");

		maskedWord.matches('n');
		assertThat(maskedWord.getMask()).isEqualTo("_an__an");

		maskedWord.matches('m');
		assertThat(maskedWord.getMask()).isEqualTo("_an_man");

		maskedWord.matches('p'); // miss
		assertThat(maskedWord.getMask()).isEqualTo("_an_man"); // not changed

		maskedWord.matches('g');
		assertThat(maskedWord.getMask()).isEqualTo("_angman");

		maskedWord.matches('h');
		assertThat(maskedWord.getMask()).isEqualTo("hangman");
	}
}

/* EOF */
