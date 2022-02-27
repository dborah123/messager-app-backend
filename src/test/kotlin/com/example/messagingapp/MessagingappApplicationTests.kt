package com.example.messagingapp

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class MessagingappApplicationTests {

	val underTest = Calculator()

	@Test
	fun contextLoads() {
	}

	@Test
	fun itShouldAdd() {
		// given
		val a = 20
		val b = 2

		// when
		val result = underTest.add(a, b)

		// then
		assertThat(result).isEqualTo(22)
	}

	class Calculator {
		fun add(a: Int, b: Int): Int {
			return a+b
		}
	}

}
