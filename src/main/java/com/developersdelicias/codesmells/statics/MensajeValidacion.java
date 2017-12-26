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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MensajeValidacion that = (MensajeValidacion) o;

		return valido == that.valido && (mensaje != null ? mensaje.equals(that.mensaje) : that.mensaje == null);
	}

	@Override
	public int hashCode() {
		int result = mensaje != null ? mensaje.hashCode() : 0;
		result = 31 * result + (valido ? 1 : 0);
		return result;
	}

	public static MensajeValidacion invalidWithMessage(String message) {
		return new MensajeValidacion(message, false);
	}
}
