package io.github.zartc.hangman.service.keyreader

import spock.lang.Specification

class KeyReaderIT extends Specification {
	KeyReader keyReader = new KeyReaderImpl()

	def "integration test of KeyReader"() {
		expect:
		keyReader.isAcceptable(letter as char) == result

		where:
		letter << ('a'..'z')
		result = true
	}
}
