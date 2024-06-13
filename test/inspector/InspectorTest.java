package inspector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.Zona;

public class InspectorTest {

    private AppInspector appInspector;
    private Inspector inspector;
    private Zona zona;

    @BeforeEach
    public void setUp() {
        appInspector = mock(AppInspector.class); 
        zona = mock(Zona.class);
        inspector = new Inspector("Jose", 12345, appInspector, zona); 
    }

    @Test
    public void testTieneEstacionamientoValido() {
        when(appInspector.tieneEstacionamientoVigente("abc123")).thenReturn(true);
        inspector.tieneEstacionamientoValido("abc123");

        verify(appInspector, never()).altaDeInfraccion("abc123");
        verify(appInspector).tieneEstacionamientoVigente("abc123");
    }

    @Test
    public void testNOTieneEstacionamientoValido() {
        when(appInspector.tieneEstacionamientoVigente("abc123")).thenReturn(false);
        inspector.tieneEstacionamientoValido("abc123");

        verify(appInspector).altaDeInfraccion("abc123");
        verify(appInspector).tieneEstacionamientoVigente("abc123");
    }
    
    @Test
    public void testGetNombreInspector() {
    	assertEquals("Jose", inspector.getNombreInspector());
    }
    
    @Test
    public void testGetIDinspector() {
    	assertEquals(12345, inspector.getIDinspector());
    }
    
    @Test
    public void testGetZona() {
    	assertEquals(zona, inspector.getZona());
    }
}

