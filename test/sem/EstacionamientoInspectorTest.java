package sem;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inspector.Infraccion;
import inspector.Inspector;

public class EstacionamientoInspectorTest {

    private SEM sem;
    private Infraccion infraccion;
    private Inspector inspector;

    @BeforeEach
    public void setUp() {
        sem = new SEM();
        inspector = mock(Inspector.class); 
        infraccion = new Infraccion("ABC123", inspector);
    }

    @Test
    public void testAgregarInfraccion() {
        sem.agregarInfraccion(infraccion);

        Infraccion result = sem.obtenerInfraccion("ABC123");
        assertNotNull(result); 
        assertEquals(infraccion, result); 
    }
}
