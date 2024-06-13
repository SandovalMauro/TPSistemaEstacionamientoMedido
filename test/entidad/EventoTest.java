package entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventoTest {

	private String tipo;
	private Object datos;
    private Evento evento;

    @BeforeEach
    public void setUp() {
    	tipo = "TipoDeDatos";
    	datos = mock(Object.class);
    	evento = new Evento(tipo, datos);
    }

    @Test
    public void testGetTipo() {
        assertEquals("TipoDeDatos", evento.getTipo());
    }

    @Test
    public void testGetDatos() {
        assertEquals(datos, evento.getDatos());
    }
}

