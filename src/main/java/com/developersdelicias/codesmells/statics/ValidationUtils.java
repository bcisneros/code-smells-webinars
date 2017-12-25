package com.developersdelicias.codesmells.statics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	public static MensajeValidacion validarPassword(String password, String length) {
		Pattern pat = Pattern.compile("^(?=.*\\d)(?=.*[\\W_])(?=.*[A-Z])(?=.*[a-z])\\S{"+ length +",16}$");
		Matcher mat = pat.matcher(password);
		int passLenght = password.length();
		int maxLenght = Integer.parseInt(length);
		if(numeroSecuenciales(password)){
			return new MensajeValidacion("No permite secuecia de 3 números consecutivos o más.", false);
		} else if(numerosRepetidos(password)){
			return new MensajeValidacion("No se permiten repeticiones seguidas de 3 números o más.", false);
		} else if(secuenciaLetras(password)){
			return new MensajeValidacion("No se permiten secuencia de 3 letras consecutivas o más.", false);
		} else if(letrasRepetidas(password)){
			return new MensajeValidacion("No se permiten repeticiones seguidas de 3 letras o más.", false);
		} else if(validarDiccionario(password)){
			return new MensajeValidacion("El Password no puede contener palabras reservadas o mas", false);
		} else if (!mat.matches()) {
			return new MensajeValidacion("La contraseña debe de tener por lo menos una letra Mayúscula, una letra minúscula, un número, un caracter especial"
					+ " y minimo " + length + " caracteres.", false);
		}
		else {
			return new MensajeValidacion("Contraseña Valida", true);
		}
	}

	public static boolean numeroSecuenciales(String cadena) {
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

	private static boolean numerosRepetidos(String cadena) {
		String[] secuencias = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		for (int i = 0; i < secuencias.length; i++) {
			int search = cadena.indexOf(secuencias[i] + secuencias[i] + secuencias[i]);
			if (search != -1) {
				return true;
			}
		}
		return false;
	}

	private static boolean secuenciaLetras(String cadena) {
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

	private static boolean letrasRepetidas(String cadena) {
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

	static boolean validarDiccionario(String cadena) {
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

