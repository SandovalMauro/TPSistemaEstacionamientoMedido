package inspectorTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inspector.AppInspector;
import sem.SEM;

public class AppInspectorTest {

    private SEM sem;
    private AppInspector appInspector;

    @BeforeEach
    public void setUp() {
        sem = mock(SEM.class); 
        appInspector = new AppInspector(sem);
    }

    @Test
    public void testTieneEstacionamientoVigente() {
        when(sem.estaVigente("abc123")).thenReturn(true);
        boolean res = appInspector.tieneEstacionamientoVigente("abc123");

        verify(sem).estaVigente("abc123");
        assertTrue(res);
    }
    
    public void testAltaDeInfraccion() throws Exception {
    	appInspector.altaDeInfraccion("abc123");

        verify(sem).generarInfraccion("abc123");
    }
}

