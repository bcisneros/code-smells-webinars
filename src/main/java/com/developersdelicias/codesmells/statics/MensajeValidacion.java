package com.developersdelicias.codesmells.statics;

public class MensajeValidacion {

	private String mensaje;
	private boolean valido;

	public MensajeValidacion(String mensaje, boolean valido) {
		this.mensaje = mensaje;
		this.valido = valido;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	@Override
	public String toString() {
		return "MensajeValidacion{" + "mensaje=" + mensaje + ", valido=" + valido + '}';
	}

}
