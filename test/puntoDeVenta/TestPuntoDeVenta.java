package puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.SEM;


class TestPuntoDeVenta {
	private PuntoDeVenta punto;
	private LocalDate fecha;
	private SEM sem;
	private Recarga compra1;
	//private Usuario usuario;
	private Compra compra2;
	
	@BeforeEach
	void SetUp() throws Exception{
		
		fecha = mock(LocalDate.class);
		sem = new SEM();//mock(SEM.class);
		//usuario = mock(Usuario.class);
		compra1 = mock(Recarga.class);
		punto = new PuntoDeVenta(sem);

	}

	@Test
	void testCargaCredito() {
		//punto.cargarCredito(usuario, 100, fecha);
		assertEquals(1,sem.compras().size());
	}
	
	@Test
	void testEstacionamiento() {
	//	punto.iniciarEstacionamiento(usuario, 0, fecha);
		assertEquals(1,sem.compras().size());
		assertEquals(1,sem.estacionados().size());
	}
}
