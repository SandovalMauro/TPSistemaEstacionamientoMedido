package appUsuario;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sem.SEM;



class AppUsuarioTest {

	SEM sem;
	AppUsuario appT;
	
	@BeforeEach
	public void setUp() {
		sem = mock(SEM.class);
		appT = new AppUsuario(sem, 1167648255, "ABC 123");
	}
/*
	@Test
	void testAppUsuariohfytggls() {
		assertTrue(appT.isFlagDriving());
		assertFalse(appT.isSensorActivo());
		appT.driving(); 
		assertTrue(appT.isFlagDriving());
		appT.walking();
		assertTrue(appT.isFlagDriving());
	
		verifyZeroInteractions(appT.getModo());
		
		appT.setModoAutomatico();
		
		assertTrue(appT.isFlagDriving());
		assertTrue(appT.isSensorActivo()); // Se enciende el sensor
		appT.walking();
		verify(appT.getModo(), times(1)).appT.getModo().walking(); // el mensaje Walking fue enviado una vez
		assertFalse(appT.isFlagDriving()); // Se detecta que se esta caminando
		
		appT.walking();
		verify(appT.getModo(), times(1)).appT.getModo().walking(); // el mensaje Walking no volvio a ser llamado		
		
		appT.driving();
		assertTrue(appT.isFlagDriving());
	}*/

}
