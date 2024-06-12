package puntoDeVenta;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appUsuario.AppUsuario;
import sem.SEM;

class CompraTest {
	
	private CompraPuntual compraPuntual;
	private Recarga recarga;
	private PuntoDeVenta punto;
	private LocalDateTime fechaYHora;
	private LocalDateTime fechaYHoraFinalizacion;
	private int cantidadHs;
	private double monto;
	private int celular;
	
	@BeforeEach
	void SetUp() throws Exception{
		cantidadHs = 3;
		monto = 100;
		celular = 1510101010;
		fechaYHora = LocalDateTime.of(2024, 6, 10, 15,25);
		fechaYHoraFinalizacion = fechaYHora.plusHours(cantidadHs);
		punto = mock(PuntoDeVenta.class);
		compraPuntual = new CompraPuntual(punto, fechaYHora, cantidadHs);
		recarga = new Recarga(punto,fechaYHora,monto,celular);
		
	}

	@Test
	void testNumeroDeControl() {
		assertNotEquals(compraPuntual.numControl(),recarga.numControl());
		//como se instancio primero compraPuntual su numero de control debe ser menor al de recarga
		assertTrue(compraPuntual.numControl()< recarga.numControl());
		assertFalse(compraPuntual.numControl()>= recarga.numControl());
	}
	
	@Test
	void testCalculoConGettersHsCompradasYFechaYHora() {
		assertEquals(fechaYHoraFinalizacion,compraPuntual.getFechaYHora().plusHours(compraPuntual.getHsCompradas()));
	}

	@Test
	void test() {
		//testear mock de sem. finalizando estacionamiento para ver si 
		// el sem llama a la subtarea que buscaria el estacionamiento
		assertEquals(celular, recarga.getCelular());
	}
}
