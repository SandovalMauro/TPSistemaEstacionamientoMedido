package inspector;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import sem.SEM;

public class AppInspectorTest {

	private SEM sem;
	private AppInspector appInspector;
	private Inspector inspector;

	@BeforeEach
	public void setUp() {
		sem = mock(SEM.class);
		inspector = mock(Inspector.class);
		appInspector = new AppInspector(sem, inspector);
	}

	@Test
	public void testTieneEstacionamientoVigente() {
		when(sem.estaVigente("abc123")).thenReturn(true);
		boolean res = appInspector.tieneEstacionamientoVigente("abc123");

		verify(sem).estaVigente("abc123");
		assertTrue(res);
	}

	@Test
	public void testAltaDeInfraccion() {
		appInspector.altaDeInfraccion("abc123");

		// Prepara para capturar los datos de Infraccion
		ArgumentCaptor<Infraccion> captor = ArgumentCaptor.forClass(Infraccion.class);
		verify(sem).agregarInfraccion(captor.capture());
		// Genera una copia con los mismos valores de Infraccion
		Infraccion infraccionCapturada = captor.getValue();
		// Verifica que los datos sean iguales
		assertEquals("abc123", infraccionCapturada.getPatente());
		assertEquals(inspector, infraccionCapturada.getInspector());
	}

	@Test
	public void testGetInspector() {
		assertEquals(inspector, appInspector.getInspector());
	}
}
