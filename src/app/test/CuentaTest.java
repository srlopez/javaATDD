package app.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import app.core.Cuenta;

/*
@Test
@DisplayName("")
void test() {
	fail("Not yet implemented");
	//assertEquals(0, 0);
}
*/

class CuentaTest {

	@Nested
	class CreacionCta {
		@Test
		@DisplayName("#1 Al crear una Cuenta el Saldo debe ser Cero")
		void test01() {
			Cuenta c = new Cuenta();
			assertEquals(0, c.getSaldo());
		}
	}

	@Nested
	class Ingresos {
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

		@Test
		@DisplayName("#5 Al ingresar -100 en Cuenta nueva el Saldo es 0")
		void test05() {
			Cuenta c = new Cuenta();
			c.ingreso(-100);
			assertEquals(0, c.getSaldo());
		}

		@Test
		@DisplayName("#6 Al Ingresar 100.45 en CtaNueva saldo 100.45")
		void test06() {
			// preparacion
			Cuenta c = new Cuenta();
			// ejecucion
			c.ingreso(100.45);
			// asercion/Confirmacion
			assertEquals(100.45, c.getSaldo());
		}

		@Test
		@DisplayName("#7 Ingreso de Cantidad de más de 2 Decimales No EsValido")
		void test07() {
			Cuenta c = new Cuenta();
			c.ingreso(100.457);
			assertEquals(0, c.getSaldo());
		}

		@Test
		@DisplayName("#8 Ingreso Máximo de 6000")
		void test08() {
			Cuenta c = new Cuenta();
			c.ingreso(6000);
			assertEquals(6000, c.getSaldo());
		}

		@Test
		@DisplayName("#9 Ingreso de más de 6000 No Es Valido")
		void test09() {
			Cuenta c = new Cuenta();
			c.ingreso(6000.01);
			assertEquals(0, c.getSaldo());
		}
	}

	@Nested
	class Retiradas {

		@Test
		@DisplayName("#10 Al retirar 100 en cuenta con 500 el saldo es 400")
		void test10() {
			Cuenta c = new Cuenta();
			c.ingreso(500);
			c.retirada(100);
			assertEquals(400, c.getSaldo());
		}

		@Test
		@DisplayName("#11 Si retiro 500 en cuenta con 200 no ocurre nada y el saldo sigue siendo 200")
		void test11() {
			Cuenta c = new Cuenta();
			c.ingreso(200);
			c.retirada(500);
			assertEquals(200, c.getSaldo());
		}

		@Test
		@DisplayName("#12 Si retiro -100 en cuenta con 500 no ocurre nada y el saldo sigue siendo 500")
		void test12() {
			Cuenta c = new Cuenta();
			c.ingreso(500);
			c.retirada(-100);
			assertEquals(500, c.getSaldo());
		}

		@Test
		@DisplayName("#13 Al retirar 100.45 en cuenta con 500 el saldo es 399.55")
		void test13() {
			Cuenta c = new Cuenta();
			c.ingreso(500);
			c.retirada(100.45);
			assertEquals(399.55, c.getSaldo());
		}

		@Test
		@DisplayName("#14 Al retirar 100.457 en cuenta con 500 con 500 no ocurre nada y el saldo sigue siendo 500")
		void test14() {
			Cuenta c = new Cuenta();
			c.ingreso(500);
			c.retirada(100.457);
			assertEquals(500, c.getSaldo());
		}

		@Test
		@DisplayName("#15 Si retiro 6000.00 en una cuenta con 7000, el saldo es de 1000")
		void test15() {
			Cuenta c = new Cuenta();
			c.ingreso(6000);
			c.ingreso(1000);
			c.retirada(6000);
			assertEquals(1000, c.getSaldo());
		}

		@Test
		@DisplayName("#16 Si retiro 6000.01 en una cuenta con 7000, no ocurre nada y el saldo sigue siendo 7000")
		void test16() {
			Cuenta c = new Cuenta();
			c.ingreso(6000);
			c.ingreso(1000);
			c.retirada(6000.01);
			assertEquals(7000, c.getSaldo());
		}

	}

	@Nested
	class Transferencias {

		@Test
		@DisplayName("#17  Al hacer una transferencia de 100 desde una cuenta con 500 a una con 50, en la primera cuenta el saldo se quedará en 400 y en la segunda se quedará en 150.")
		void test17() {
			// Preparacion
			Cuenta c1 = new Cuenta();
			c1.ingreso(500);
			Cuenta c2 = new Cuenta();
			c2.ingreso(50);
			// Ejecucición
			c1.transferencia(100, c2);
			// Aserción
			assertAll("Saldos de 400 y 150", 
			() -> assertEquals(400, c1.getSaldo()),
			() -> assertEquals(150, c2.getSaldo())
			);
		}

		@Test
		@DisplayName("#18 Al hacer una transferencia de -100 desde una cuenta con 500 a una con 50, los saldos se quedan en 500 y 50 respectivamente")
		void test18() {
			Cuenta c1 = new Cuenta();
			c1.ingreso(500);
			Cuenta c2 = new Cuenta();
			c2.ingreso(50);

			c1.transferencia(-100, c2);
			
			assertAll("Saldos de 500 y 50", 
			() -> assertEquals(500, c1.getSaldo()),
			() -> assertEquals(50, c2.getSaldo())
			);
		}

		@Test
		@DisplayName("#19 Al hacer una transferencia de 3000 desde una cuenta con 3500 a una con 50, en la primera cuenta el saldo se quedará en 500 y en la segunda se quedará en 3050.")
		void test19() {
			// Este Test Npo Aporta NADA está mal planteado == test17
			Cuenta c1 = new Cuenta();
			c1.ingreso(3500);
			Cuenta c2 = new Cuenta();
			c2.ingreso(50);

			c1.transferencia(3000, c2);
			
			assertAll("Saldos de 500 y 3050", 
			() -> assertEquals(500, c1.getSaldo()),
			() -> assertEquals(3050, c2.getSaldo())
			);
		}

		@Test
		@DisplayName("#20 Al hacer una transferencia de 3000.01 desde una cuenta con 3500 a una con 50, en la primera cuenta el saldo se quedará en 3500 y en la segunda se quedará en 50.")
		void test20() {
			Cuenta c1 = new Cuenta();
			c1.ingreso(3500);
			Cuenta c2 = new Cuenta();
			c2.ingreso(50);

			c1.transferencia(3000.01, c2);
			
			assertAll("Saldos de 3500 y 50", 
			() -> assertEquals(3500, c1.getSaldo()),
			() -> assertEquals(50, c2.getSaldo())
			);
		}

		@Test
		@DisplayName("#21 Al hacer una transferencia de 2000 desde una cuenta con 3500 a una con 50, y justo después otra de 1200, en la primera cuenta el saldo se quedará en 1500 y en la segunda se quedará en 2050.")
		void test21() {
			Cuenta c1 = new Cuenta();
			c1.ingreso(3500);
			Cuenta c2 = new Cuenta();
			c2.ingreso(50);

			c1.transferencia(2000, c2);
			c1.transferencia(1200, c2);
			
			assertAll(
			() -> assertEquals(1500, c1.getSaldo()),
			() -> assertEquals(2050, c2.getSaldo())
			);
		}
	}
}
