package inspectorTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import inspector.AppInspector;
import inspector.Inspector;


public class InspectorTest {
	
	@BeforeEach
	public void setUp() {
	}
    
	@Test
	public void testTieneEstacionamientoValido() {
		//Se testea que un auto tenga estacionamiento valido.
		AppInspector appInspector = mock(AppInspector.class);
		Inspector inspector = new Inspector("Jose", 123, appInspector);
		
		when(appInspector.tieneEstacionamientoVigente("abcc123")).thenReturn(true);
		inspector.tieneEstacionamientoValido("abcc123");

		 assertTrue(appInspector.tieneEstacionamientoVigente("abcc123"));
	}

}

