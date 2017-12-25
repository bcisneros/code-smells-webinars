package com.developersdelicias.codesmells.statics;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ValidationUtilsTest {

	private static final String DEFAULT_PASSWORD_LENGTH = "8";

	@Test
	public void should_not_allow_passwords_with_three_consecutive_numbers() {
		assertThat(
				validate("1235"),
				is(anInvalidPasswordResultWithMessage("No permite secuecia de 3 números consecutivos o más."))
		);
	}

	@Test
	public void should_not_allow_passwords_with_same_number_consecutive_more_than_three_times() {
		assertThat(
				validate("abc222cdf"),
				is(anInvalidPasswordResultWithMessage("No se permiten repeticiones seguidas de 3 números o más."))
		);
	}

	@Test
	public void should_not_allow_passwords_with_three_consecutive_letters() {
		assertThat(
				validate("abc134cdf"),
				is(anInvalidPasswordResultWithMessage("No se permiten secuencia de 3 letras consecutivas o más."))
		);
	}

	@Test
	public void should_not_allow_passwords_with_three_consecutive_repeated_letters() {
		assertThat(
				validate("asdbbb12e"),
				is(anInvalidPasswordResultWithMessage("No se permiten repeticiones seguidas de 3 letras o más."))
		);
	}

	@Test
	@Parameters({"banorte", "seguros", "pensiones", "banorteseguros", "banortepensiones", "segurosbanorte", "pensionesbanorte", "seguros&pensionesbanorte", "segurosypensionesbanorte", "sypbanorte", "s&pbanorte", "banortebap", "bancobanorte", "banortebanco", "bancofuerte", "banco", "qwerty", "azerty"})
	public void should_not_allow_passwords_using_reserved_words(String reservedWord) {
		assertThat(
				validate(reservedWord),
				is(anInvalidPasswordResultWithMessage("El Password no puede contener palabras reservadas o mas"))
		);
	}

	@Test
	public void should_validate_against_dictionary() {
		assertThat(
				"Does not find exactly words in dictionary",
				ValidationUtils.validarDiccionario("banorte"),
				is(true)
		);
	}

	@Test
	public void should_validate_against_dictionary_2() {
		assertThat(
				"Does not find containing words in dictionary",
				ValidationUtils.validarDiccionario("banorte2"),
				is(true)
		);
	}

	@Test
	public void should_validate_against_dictionary_3() {
		assertThat(
				"Does not find containing (uppercase) words in dictionary",
				ValidationUtils.validarDiccionario("BANORTE2"),
				is(true)
		);
	}

	@Test
	public void should_validate_against_dictionary_4() {
		assertThat(
				"Does not find containing (uppercase) words in dictionary",
				ValidationUtils.validarDiccionario("Banorte2"),
				is(true)
		);
	}

	private MensajeValidacion anInvalidPasswordResultWithMessage(String message) {
		return new MensajeValidacion(message, false);
	}

	private MensajeValidacion validate(String password) {
		return ValidationUtils.validarPassword(password, DEFAULT_PASSWORD_LENGTH);
	}
}