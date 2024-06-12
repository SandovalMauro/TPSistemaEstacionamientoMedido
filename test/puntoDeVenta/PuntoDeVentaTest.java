package puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appUsuario.AppUsuario;
import sem.SEM;


class PuntoDeVentaTest {
	private PuntoDeVenta punto;
	private LocalDateTime fecha;
	private SEM sem;
	private Recarga compra1;
	private AppUsuario app;
	private String patente;

	//private Usuario usuario;

	private Compra compra2;
	
	@BeforeEach
	void SetUp() throws Exception{
		
		fecha = mock(LocalDateTime.class);
		sem = new SEM();//mock(SEM.class);
		app = mock(AppUsuario.class);
		patente = "BB123XX";

		compra1 = mock(Recarga.class);
		punto = new PuntoDeVenta(sem);

	}

	@Test
	void testCargaCredito() {
		punto.cargarCredito(app, 100, fecha);
		verify(app).cargarSaldo(100);
		assertEquals(1,sem.compras().size());
	}
	
	@Test
	void testIniciarEstacionamiento() {
		punto.iniciarEstacionamiento(3, fecha, patente);
		assertEquals(1,sem.compras().size());
		assertEquals(1,sem.estacionados().size());
	}
}
