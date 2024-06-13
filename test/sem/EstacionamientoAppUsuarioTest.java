package sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import puntoDeVenta.CompraPuntual;

class EstacionamientoAppUsuarioTest {
	private EstacionamientoAppUsuario estacionamiento;
	private int celular;
	private String patente;
	private LocalDateTime horaDeInicio;
	private LocalDateTime horaDeFinalizacion;
	private LocalDateTime horaActual;
	
	@BeforeEach
	void SetUp() throws Exception{
		celular = 1560606060;
		patente = "AA123XX";
		
		horaDeInicio = LocalDateTime.of(2024, 6, 10, 14, 30);
		horaDeFinalizacion = LocalDateTime.of(2024, 6, 10, 18, 30);
		horaActual = LocalDateTime.of(2024, 6, 10, 17, 31);
		
		estacionamiento = new EstacionamientoAppUsuario(horaDeInicio,horaDeFinalizacion,patente,celular);
	}

	@Test
	void testEstaVigente() {
		assertTrue(estacionamiento.estaVigente(horaActual));
		
	}
	
	@Test
	void testNoEstaVigente() {
		horaActual = horaActual.plusHours(1); //suma una hora a la horaActual
		assertFalse(estacionamiento.estaVigente(horaActual));
		
	}
	
	@Test
	void testConsultaPatenteYCelular() {
		assertEquals(celular, estacionamiento.getCelular());
		assertEquals(patente, estacionamiento.getPatente());
		
	}
	
	@Test
	void testCantidadHoras() {
		assertEquals(4, estacionamiento.cantidadHoras());
		//setteo una nueva hora fin que es menor a la que estaba 
		estacionamiento.setHoraFin(horaDeFinalizacion.minusHours(1));
		assertEquals(3, estacionamiento.cantidadHoras());
	}
}
