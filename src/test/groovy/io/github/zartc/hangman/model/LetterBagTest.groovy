package io.github.zartc.hangman.model


import spock.lang.Specification

class LetterBagTest extends Specification {
	def "Consumed chars are marked as used"() {
		given:
		LetterBag lb = new LetterBag()

		when:
		lb.consume('A' as char)
		lb.consume('P' as char)
		lb.consume('E' as char)
		lb.consume('R' as char)
		lb.consume('O' as char)

		then:
//		assertThat(lb.getConsumed()).containsExactly(['A', 'E', 'O', 'P', 'R'] as Character[]);
		lb.getConsumed() == ['A', 'E', 'O', 'P', 'R'] as Character[]
	}
}
