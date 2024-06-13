package sem;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidad.Observador;

import java.util.List;

public class EstacionamientoEntidadTest {

    private SEM sem;
    private Observador observador;

    @BeforeEach
    public void setUp() {
        sem = new SEM();
        observador = mock(Observador.class);
    }

    @Test
    public void testSubscribir() {
        List<Observador> observadores = sem.getObservadores();
        assertEquals(0, observadores.size());

        sem.subscribir(observador);
        assertEquals(1, observadores.size());
        assertTrue(observadores.contains(observador));
    }

    @Test
    public void testDesuscribir() {
        sem.subscribir(observador);

        List<Observador> observadores = sem.getObservadores();
        assertEquals(1, observadores.size());

        sem.desuscribir(observador);
        assertEquals(0, observadores.size());
        assertFalse(observadores.contains(observador));
    }
}

