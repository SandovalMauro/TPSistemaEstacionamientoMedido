package puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestCompra {
	private PuntoDeVenta punto;
	private LocalDate fecha;
	private Compra compra1;
	private Compra compra2;
	
	@BeforeEach
	void SetUp() throws Exception{
		punto = mock(PuntoDeVenta.class);
		fecha = mock(LocalDate.class);
		compra1 = new Compra(punto,fecha);
		compra2 = new Compra(punto,fecha);
		
	}

	@Test
	void compras() {
		assertEquals(1,compra1.numControl());
		assertEquals(2,compra2.numControl());
	}

}
