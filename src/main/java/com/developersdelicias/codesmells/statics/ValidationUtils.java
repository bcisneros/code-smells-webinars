package com.developersdelicias.codesmells.statics;

import java.util.regex.Pattern;

public class ValidationUtils {

	public static MensajeValidacion validarPassword(String password, String length) {

		if (hasSequentialNumbers(password)) {
			return MensajeValidacion.invalidWithMessage("No permite secuecia de 3 números consecutivos o más.");
		}
		if (hasRepeatedNumbers(password)) {
			return MensajeValidacion.invalidWithMessage("No se permiten repeticiones seguidas de 3 números o más.");
		}
		if (tieneLetrasConsecutivas(password)) {
			return MensajeValidacion.invalidWithMessage("No se permiten secuencia de 3 letras consecutivas o más.");
		}
		if (tieneLetrasRepetidas(password)) {
			return  MensajeValidacion.invalidWithMessage("No se permiten repeticiones seguidas de 3 letras o más.");
		}
		if (estaContenidoEnElDiccionario(password)) {
			return MensajeValidacion.invalidWithMessage("El Password no puede contener palabras reservadas o mas");
		}

		if (isNotEnoughComplex(password, length)) {
			return  MensajeValidacion.invalidWithMessage("La contraseña debe de tener por lo menos una letra Mayúscula, una letra minúscula, un número, un caracter especial"
					+ " y minimo " + length + " caracteres.");
		}

		return new MensajeValidacion("Contraseña Valida", true);

	}

	private static boolean isNotEnoughComplex(String password, String length) {
		return !Pattern.compile(complexityPasswordRegExp(length)).matcher(password).matches();
	}

	private static String complexityPasswordRegExp(String length) {
		return "^(?=.*\\d)(?=.*[\\W_])(?=.*[A-Z])(?=.*[a-z])\\S{"+ length +",16}$";
	}

	public static boolean hasSequentialNumbers(String cadena) {
		String[] secuencias = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		for (int i = 0; i < secuencias.length; i++) {
			if (!secuencias[i].equals("8") && !secuencias[i].equals("9")) {
				int search = cadena.indexOf(secuencias[i] + secuencias[i + 1] + secuencias[i + 2]);
				if (search != -1) {
					return true;
				}
			}
		}
		for(int i = secuencias.length - 1; i > 0; i--){
			if (!secuencias[i].equals("1") && !secuencias[i].equals("0")) {
				int search = cadena.indexOf(secuencias[i] + secuencias[i - 1] + secuencias[i - 2]);
				if (search != -1) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasRepeatedNumbers(String cadena) {
		String[] secuencias = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		for (int i = 0; i < secuencias.length; i++) {
			int search = cadena.indexOf(secuencias[i] + secuencias[i] + secuencias[i]);
			if (search != -1) {
				return true;
			}
		}
		return false;
	}

	private static boolean tieneLetrasConsecutivas(String cadena) {
		String[] secuencias = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		for (int i = 0; i < secuencias.length; i++) {
			if (!secuencias[i].equals("y") && !secuencias[i].equals("z")) {
				int search = cadena.indexOf(secuencias[i] + secuencias[i + 1] + secuencias[i + 2]);
				if (search != -1) {
					return true;
				}
				int search2 = cadena.indexOf(secuencias[i].toUpperCase() + secuencias[i + 1].toUpperCase() + secuencias[i + 2].toUpperCase());
				if (search2 != -1) {
					return true;
				}

			}
		}
		for (int i = secuencias.length - 1 ; i > 0; i--) {
			if (!secuencias[i].equals("b") && !secuencias[i].equals("a")) {
				int search = cadena.indexOf(secuencias[i] + secuencias[i - 1] + secuencias[i - 2]);
				if (search != -1) {
					return true;
				}
				int search2 = cadena.indexOf(secuencias[i].toUpperCase() + secuencias[i - 1].toUpperCase() + secuencias[i - 2].toUpperCase());
				if (search2 != -1) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean tieneLetrasRepetidas(String cadena) {
		String[] secuencias = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		for (int i = 0; i < secuencias.length; i++) {
			int search = cadena.indexOf(secuencias[i] + secuencias[i] + secuencias[i]);
			if (search != -1) {
				return true;
			}
		}
		for (int i = 0; i < secuencias.length; i++) {
			int search = cadena.indexOf(secuencias[i].toUpperCase() + secuencias[i].toUpperCase() + secuencias[i].toUpperCase());
			if (search != -1) {
				return true;
			}
		}
		return false;
	}

	static boolean estaContenidoEnElDiccionario(String cadena) {
		String[] secuencias = {"banorte", "seguros", "pensiones", "banorteseguros", "banortepensiones", "segurosbanorte", "pensionesbanorte", "seguros&pensionesbanorte", "segurosypensionesbanorte", "sypbanorte", "s&pbanorte", "banortebap", "bancobanorte", "banortebanco", "bancofuerte", "banco", "qwerty", "azerty"};
		for (int i = 0; i < secuencias.length; i++) {
			int search = cadena.toUpperCase().indexOf(secuencias[i].toUpperCase());
			if (search != -1) {
				return true;
			}
		}
		return false;
	}
}

