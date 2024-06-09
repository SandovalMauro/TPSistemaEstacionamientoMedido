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
		
	}

	@Test
	void testSaldo() {
		when(this.sem.nuevoEstacionamiento(1167648255, "ABC 123"))
		fail("Not yet implemented");
	}

	@Test
	void testCargarSaldo() {
		fail("Not yet implemented");
	}

	@Test
	void testPasarAAutomatico() {
		fail("Not yet implemented");
	}

	@Test
	void testPasarAManual() {
		fail("Not yet implemented");
	}

	@Test
	void testIniciarEstacionamiento() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalizarEstacionamiento() {
		fail("Not yet implemented");
	}

	@Test
	void testDriving() {
		fail("Not yet implemented");
	}

	@Test
	void testWalking() {
		fail("Not yet implemented");
	}

	@Test
	void testSetModoAutomatico() {
		fail("Not yet implemented");
	}

	@Test
	void testSetModoManual() {
		fail("Not yet implemented");
	}

}
