package sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appUsuario.AppUsuario;

class SEMTest {
	private SEM sem;
	private AppUsuario app;
	private RegistroEstacionamiento estacionamiento;
	private LocalDateTime horaActual;
	private int celular;
	private String patente;

	@BeforeEach
	void SetUp() throws Exception{
		app = mock(AppUsuario.class);
		estacionamiento = mock(RegistroEstacionamiento.class);
		celular = 1510010010;
		patente = "AA123ZZ";
		horaActual = LocalDateTime.of(2024, 6, 10, 15, 30);
		sem = new SEM();
		sem.setHoraActual(horaActual);
		sem.agregarEstacionamiento(estacionamiento);
		sem.agregarAppUsuario(app);
	}
	
	@Test
	void testFinalizarEstacionamiento() {
		when(app.getNumero()).thenReturn(celular);
		when(estacionamiento.estaVigente(horaActual)).thenReturn(true);
		when(estacionamiento.getCelular()).thenReturn(celular);
		sem.finalizarEstacionamiento(celular);
		verify(estacionamiento).setHoraFin(horaActual);
		verify(estacionamiento).cantidadHoras();
	}

	@Test
	void testBuscarEstacionamientoVigenteConPatente() {
		when(estacionamiento.getPatente()).thenReturn(patente);
		when(estacionamiento.estaVigente(horaActual)).thenReturn(true);
		
		assertTrue(sem.estaVigente(patente));
		assertEquals(estacionamiento, sem.buscarEstacionamiento(patente));
	}
	
	@Test
	void testBuscarEstacionamientoNoVigenteConPatente() {
		when(estacionamiento.getPatente()).thenReturn(patente);
		when(estacionamiento.estaVigente(horaActual)).thenReturn(false);
		
		assertFalse(sem.estaVigente(patente));
		assertEquals(null, sem.buscarEstacionamiento(patente));
	}
	
	@Test
	void testCargarCredito() {
		sem.cargarCredito(app, 100);
		verify(app).cargarSaldo(100);
	}
	
}
