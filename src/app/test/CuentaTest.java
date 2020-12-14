package app.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import app.core.Cuenta;

class CuentaTest {

	@Test
	@DisplayName("Al crear una Cuenta el Saldo debe ser Cero")
	void alCrearCuentaElSaldoEsCero() {
		Cuenta c = new Cuenta();
		assertEquals(0, c.getSaldo());
	}

	@Test
	@DisplayName("Al ingresar 100 en Cuenta nueva el Saldo es 100")
	void alIngresar100EnCuentaNuevaElSaldoEs100() {
		Cuenta c = new Cuenta();
		c.ingreso(100);
		assertEquals(100, c.getSaldo());
	}

	@Test
	@DisplayName("Al ingresar 3000 en Cuenta nueva el Saldo es 3000")
	void alIngresar3000EnCuentaNuevaElSaldoEs3000() {
		Cuenta c = new Cuenta();
		c.ingreso(3000);
		assertEquals(3000, c.getSaldo());
	}

	@Test
	@DisplayName("Al ingresar 3000 en Cuenta con 100 el Saldo es 3100")
	void alIngresar3000EnCuentaCon100ElSaldoEs3100() {
		Cuenta c = new Cuenta();
		c.ingreso(100);
		c.ingreso(3000);
		assertEquals(3100, c.getSaldo());
	}

	
}
