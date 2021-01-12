package app.core;

public class Cuenta {
	static final double CANTIDAD_MAXIMA = 6000.00;
	static final double CANTIDAD_MAXIMA_TRANSFERENCIA = 3000.00;

	private double saldo;
	private int nTransferencias;

	public Cuenta() {
		this.saldo = 0;
		this.nTransferencias = 0;
	}

	public double getSaldo() {
		return this.saldo;
	}	
	
	public double setSaldo(double cantidad) {
		// Siempre con 2 decimales
		this.saldo = Math.floor(cantidad * 100) / 100d;
		return this.saldo;
	}

	public Boolean ingreso(double cantidad) {
		Boolean cantidadaEsValida = validarCantidad(cantidad);
		if (cantidadaEsValida) {
			this.saldo = setSaldo(this.saldo + cantidad);
			return true;
		}

		return false;
	}

	public Boolean retirada(double cantidad) {
		Boolean cantidadaEsValida = validarCantidadRetirada(cantidad);
		if (cantidadaEsValida) {
			this.saldo = setSaldo(this.saldo - cantidad);
			return true;
		}

		return false;
	}

	public Boolean transferencia(double cantidad, Cuenta ctaDestino) {
		Boolean cantidadaEsValida = validarCantidadTranferida(cantidad);
		Boolean transferenciaPermitida = (nTransferencias == 0);
		if ( transferenciaPermitida && cantidadaEsValida && retirada(cantidad) && ctaDestino.ingreso(cantidad)) {
			nTransferencias++;
			return true;
		}

		return false;
	}

	private Boolean validarCantidad(double cantidad) {
		double c2dec = Math.floor(cantidad * 100) / 100d;
		if (c2dec != cantidad)
			return false;
		if (cantidad < 0)
			return false;
		if (cantidad > CANTIDAD_MAXIMA)
			return false;

		return true;
	}

	private Boolean validarCantidadRetirada(double cantidad) {
		if (cantidad > this.saldo)
			return false;

		return validarCantidad(cantidad);
	}

	private Boolean validarCantidadTranferida(double cantidad) {
		if (cantidad > CANTIDAD_MAXIMA_TRANSFERENCIA)
			return false;

		return true;
	}

}
