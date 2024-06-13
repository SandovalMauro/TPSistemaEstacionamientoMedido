package appUsuario;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sem.EstacionamientoAppUsuario;
import sem.SEM;



class MensajeInicioTest {
	
	Mensaje mensajeInicio;
	AppUsuario appT;
	EstacionamientoAppUsuario estacionamiento;
	SEM sem;
	
	@BeforeEach
	void setUp() {
		mensajeInicio = new MensajeInicio();
		sem = mock(SEM.class);
		appT = mock(AppUsuario.class);
		estacionamiento = mock(EstacionamientoAppUsuario.class);
		when(appT.getSem()).thenReturn(sem);
		when(sem.getValorHora()).thenReturn(40.00);
		when(estacionamiento.horaInicio()).thenReturn(LocalDateTime.of(2024, 6, 8, 16, 00));
		when(estacionamiento.horaFin()).thenReturn(LocalDateTime.of(2024, 6, 8, 18, 00));

		when(appT.getMensajeDeModo()).thenReturn("Esta Accion ha sido tomada de maner manual.");
	}
	
	@Test
	void elSaldoAlcanza() {
		when(appT.getSaldo()).thenReturn(300.00);
		mensajeInicio.mostrar(estacionamiento, appT);

	}
	
	@Test
	void elSaldoNoAlcanza() {
		when(appT.getSaldo()).thenReturn(30.00);
		mensajeInicio.mostrar(estacionamiento, appT);
	}
	
	
}


