package inspector;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inspector.AppInspector;
import inspector.Inspector;

public class InspectorTest {

    private AppInspector appInspector;
    private Inspector inspector;

    @BeforeEach
    public void setUp() {
        appInspector = mock(AppInspector.class); 
        inspector = new Inspector("Jose", 12345, appInspector); 
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
}

