package inspector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.Zona;

public class InfraccionTest {

    private Zona zona;
    private Inspector inspector;
    private Infraccion infraccion;

    @BeforeEach
    public void setUp() {
        zona = mock(Zona.class);
        inspector = mock(Inspector.class);
        when(inspector.getZona()).thenReturn(zona);
        infraccion = new Infraccion("ABC123", inspector);
    }

    @Test
    public void testGetZona() {
        assertEquals(zona, infraccion.getZona());
    }
    
    @Test
    public void testGetHoraActual() {
        assertNotNull(infraccion.getHoraActual());
    }
}

