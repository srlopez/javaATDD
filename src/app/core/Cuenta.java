package app.core;

public class Cuenta {

	private int saldo;
	
	public Cuenta() { this.saldo=0;}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public void ingreso(int cantidad){
        this.saldo += cantidad;
	}

}
