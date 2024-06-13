package sem;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import puntoDeVenta.CompraPuntual;

class EstacionamientoCompraPuntualTest {
	
	private EstacionamientoCompraPuntual estacionamiento;
	private CompraPuntual compra;
	private String patente;
	private LocalDateTime horaDeInicio;
	private LocalDateTime horaDeFinalizacion;
	private LocalDateTime horaActual;
	
	@BeforeEach
	void SetUp() throws Exception{
		compra = mock(CompraPuntual.class);
		patente = "AA123XX";
		
		horaDeInicio = LocalDateTime.of(2024, 6, 10, 14, 30);
		horaDeFinalizacion = LocalDateTime.of(2024, 6, 10, 18, 30);
		horaActual = LocalDateTime.of(2024, 6, 10, 17, 31);
		
		estacionamiento = new EstacionamientoCompraPuntual(compra, patente);
	}

	@Test
	void testEstaVigente() {
		when(compra.getFechaYHora()).thenReturn(horaDeInicio);
		when(compra.getHsCompradas()).thenReturn(4);
		assertTrue(estacionamiento.estaVigente(horaActual));
		
	}
	
	@Test
	void testNoEstaVigente() {
		when(compra.getFechaYHora()).thenReturn(horaDeInicio);
		when(compra.getHsCompradas()).thenReturn(3);
		assertFalse(estacionamiento.estaVigente(horaActual));
		
	}
	
	@Test
	void testConsultaPatenteYCelularYHoras() {
		when(compra.getHsCompradas()).thenReturn(3);
		assertEquals(0, estacionamiento.getCelular());
		assertEquals(patente, estacionamiento.getPatente());
		assertEquals(3, estacionamiento.cantidadHoras());
		
	}
	
	@Test
	void testHoraFinalizacionEstacionamiento() {
		when(compra.getFechaYHora()).thenReturn(horaDeInicio);
		when(compra.getHsCompradas()).thenReturn(4);
		assertEquals(horaDeFinalizacion, estacionamiento.horaFin());
		
	}
	
	@Test
	void testSetHoraFinNoModificaHoraFin() {
		when(compra.getFechaYHora()).thenReturn(horaDeInicio);
		when(compra.getHsCompradas()).thenReturn(4);
		assertEquals(horaDeFinalizacion, estacionamiento.horaFin());
		estacionamiento.setHoraFin(horaDeInicio);
		assertEquals(horaDeFinalizacion, estacionamiento.horaFin());
		assertNotEquals(horaDeInicio,estacionamiento.horaFin());
	}

}
