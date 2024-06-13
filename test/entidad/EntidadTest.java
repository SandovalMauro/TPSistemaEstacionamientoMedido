package entidad;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntidadTest {
	
	private Entidad entidad;
	private Evento evento;
	
	@BeforeEach
    public void setUp() {
		entidad = new Entidad();
        evento = mock(Evento.class);
	}
	
	@Test
	public void testActualizarInicioEstacionamiento() {
		when(evento.getTipo()).thenReturn("InicioEstacionamiento");
		//Debe salir por consola "Estacionamiento iniciado."
		 entidad.actualizar(evento);
		 verify(evento, times(1)).getTipo();
		 
	}
	
	@Test
	public void testActualizarFinEstacionamiento() {
		when(evento.getTipo()).thenReturn("FinEstacionamiento");
		//Debe salir por consola "Estacionamiento finalizado."
		 entidad.actualizar(evento);
		 verify(evento, times(2)).getTipo();
		 
	}
	
	@Test
	public void testActualizarRecargaCredito() {
		when(evento.getTipo()).thenReturn("RecargaCredito");
		//Debe salir por consola "Credito recargado."
		 entidad.actualizar(evento);
		 verify(evento, times(3)).getTipo();
		 
	}

}
