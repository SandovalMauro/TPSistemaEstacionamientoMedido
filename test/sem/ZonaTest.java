package sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import puntoDeVenta.PuntoDeVenta;

class ZonaTest {
	
	private Zona zona;
	private PuntoDeVenta punto;


	@BeforeEach
	void SetUp() throws Exception{
		zona = new Zona();
		punto = mock(PuntoDeVenta.class);
	}
	
	@Test
	void testAgregadoDePunto() {
		assertEquals(0, zona.getPuntosDeVenta().size());
		zona.agregarPuntoDeVenta(punto);
		assertEquals(1, zona.getPuntosDeVenta().size());
	}

}
