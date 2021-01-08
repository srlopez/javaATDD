package app.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import app.core.Cuenta;

class CuentaTest {

	@Test
	@DisplayName("#1 Al crear una Cuenta el Saldo debe ser Cero")
	void test01() {
		Cuenta c = new Cuenta();
		assertEquals(0, c.getSaldo());
	}

	@Test
	@DisplayName("#2 Al ingresar 100 en Cuenta nueva el Saldo es 100")
	void test02() {
		Cuenta c = new Cuenta();
		c.ingreso(100);
		assertEquals(100, c.getSaldo());
	}

	@Test
	@DisplayName("#3 Al ingresar 3000 en Cuenta nueva el Saldo es 3000")
	void test03() {
		Cuenta c = new Cuenta();
		c.ingreso(3000);
		assertEquals(3000, c.getSaldo());
	}

	@Test
	@DisplayName("#4 Al ingresar 3000 en Cuenta con 100 el Saldo es 3100")
	void test04() {
		Cuenta c = new Cuenta();
		c.ingreso(100);
		c.ingreso(3000);
		assertEquals(3100, c.getSaldo());
	}

	// ======
	@Test
	@DisplayName("#5 Al ingresar -100 en Cuenta nueva el Saldo es 0")
	void test05() {
		Cuenta c = new Cuenta();
		c.ingreso(-100);
		assertEquals(0, c.getSaldo());
	}

	@Test
    @DisplayName("Al Ingresar 100.45 en CtaNueva saldo 100.45")
    void test06(){
        //preparacion
        Cuenta c = new Cuenta();
        //ejecucion
        c.ingreso(100.45);
        // asercion/Confirmacion
        assertEquals(100.45, c.getSaldo());
    }

    @Test
    @DisplayName("Ingreso de Cantidad de más de 2 Decimales No EsValido")
    void test07(){
        Cuenta c = new Cuenta();
        c.ingreso(100.457);
        assertEquals(0, c.getSaldo());
	}
	
	@Test
    @DisplayName("Ingreso Máximo de 6000")
    void test08(){
        Cuenta c = new Cuenta();
        c.ingreso(6000);
        assertEquals(6000, c.getSaldo());
    }
 
    @Test
    @DisplayName("Ingreso de más de 6000 No Es Valido")
    void test09(){
        Cuenta c = new Cuenta();
        c.ingreso(6000.01);
        assertEquals(0, c.getSaldo());
    }
 
}
