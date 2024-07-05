package appUsuario;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import puntoDeVenta.PuntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;

import sem.RegistroEstacionamiento;
import sem.SEM;



class AppUsuarioTest {

	SEM sem;
	AppUsuario appT;
	ModoApp modoAutomatico;
	ModoApp modoManual;
	PuntoDeVenta puntoDeVenta;
	Mensaje mensaje;
	Mensaje mensajeSaldo;
	RegistroEstacionamiento estacionamiento;
	
	
	@BeforeEach
	public void setUp() {
		sem = mock(SEM.class);
		appT = new AppUsuario(sem, 1167648255, "ABC 123");
		modoAutomatico = mock(ModoAutomatico.class);
		modoManual =  mock(ModoManual.class);
		puntoDeVenta = mock(PuntoDeVenta.class);
		
		estacionamiento = mock(RegistroEstacionamiento.class);

		
		when(sem.horaCierreHoy()).thenReturn(LocalDateTime.of(2024, 6, 8, 20, 00));
		when(sem.getValorHora()).thenReturn(40.00);
		when(sem.getHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 8, 17, 00));
	}

	@Test
	void seEstaEnModoManualYNoSeHaceNada() {
		appT.setModo(modoManual);

		assertFalse(appT.isSensorActivo());
		appT.driving(); 
		appT.walking();
		
		verify(modoManual).sensor(appT);
		verifyNoMoreInteractions(modoManual);
	}
	
	@Test 
	void seEstaEnModoManualYSePasaAWalking() {
		appT.setModo(modoAutomatico);
		
		verify(modoAutomatico, times(1)).sensor(appT); 
		appT.setSensorActivo(true);
		assertTrue(appT.isSensorActivo()); // Se enciende el sensor 
		
		appT.walking();
		assertTrue(appT.getState() instanceof Walking); // Se detecta que se esta caminando
		
		appT.walking();
		verifyNoMoreInteractions(modoAutomatico); // el mensaje Walking no volvio a ser llamado		
		
		appT.driving();
		verify(modoAutomatico, times(1)).drivingMSG(appT);
		assertTrue(appT.getState() instanceof Driving);
	}
	
	@Test
	public void alEstarEnModoAutomaticoElEstacionamientoSeIniciaAutomaticamente() {

		modoAutomatico = new ModoAutomatico();
		appT.setModo(modoAutomatico);

		appT.driving();
		appT.walking();
		
		
		appT.driving();
		assertTrue(appT.getState() instanceof Driving, "El estado debe ser Driving.");
	}
	
	
	@Test 
	public void seActivaYDesactivaElSensorAlCambiarDeModo() {
		modoAutomatico = new ModoAutomatico();
		modoManual =  new ModoManual();
		
		assertFalse(appT.isSensorActivo());
		appT.setModo(modoAutomatico);
		assertTrue(appT.isSensorActivo());
		appT.setModo(modoManual);
		assertFalse(appT.isSensorActivo());
	}
	

	@Test
	public void testDeGetters() {
		appT.setModo(modoAutomatico);
		assertEquals(modoAutomatico,appT.getModo());
		
		assertEquals(1167648255, appT.getNumero());
	}
	
	@Test
    public void sonLas05PMYElSaldoDaHastaLas7() {
		when(sem.getHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 8, 17, 00));
		appT.cargarSaldo(80);
		assertEquals(appT.getSaldo(), 80.00);		
		assertEquals(LocalDateTime.of(2024, 6, 8, 19, 00), appT.calcularHoraFin());
	}
	
	@Test
    public void sonLas06PMYElSaldoAlcanzaPeroElEstacionamientoCierraALas20() {
		when(sem.getHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 8, 18, 00));
		appT.cargarSaldo(800);
		appT.consultarSaldo();
		
		assertEquals(appT.getSaldo(), 800.00);	
		assertEquals(LocalDateTime.of(2024, 6, 8, 20, 00), appT.calcularHoraFin());
	
	}

	@Test 
	public void avisoDeFinalizacion() {
		modoManual = new ModoManual();
		appT.setModo(modoManual);
		when(estacionamiento.horaInicio()).thenReturn(LocalDateTime.of(2024, 6, 8, 17, 00));
		when(estacionamiento.horaFin()).thenReturn(LocalDateTime.of(2024, 6, 8, 19, 00));
		when(estacionamiento.cantidadHoras()).thenReturn(2);
		
	}
	
	@Test 
	public void finalizarEstacionamientoAvisaAlSem() {
		modoManual = new ModoManual();
		appT.setModo(modoManual);
		appT.iniciarEstacionamiento();
		appT.finalizarEstacionamiento();
		verify(sem).finalizarEstacionamiento(1167648255);
	}
	
	
	
	
}
