package app.core;

public class Cuenta {

	private double saldo;

	public Cuenta() {
		this.saldo = 0;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void ingreso(double cantidad){
        Boolean esValida = validarCantidadIngresada(cantidad);
        if(esValida){ 
            this.saldo += cantidad;
        } else {
            this.saldo = 0;
        } 
    }
    
    private Boolean validarCantidadIngresada(double cantidad){
        
		double c2dec = Math.floor(cantidad * 100) / 100d;
		if (c2dec != cantidad) return false;
		if (cantidad < 0) return false;
		if (cantidad > 6000.00) return false;
     
        return true;
    }
}
