package appUsuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import appUsuario.*;
import sem.SEM;



class AppUsuarioTest {


	@BeforeEach
	public void setUp(){
		SEM sem = mock(SEM.class);
		AppUsuario appT = new AppUsuario(sem, 1167648255, "ABC 123");
	}

	@Test
	void testAppUsuarios() {
		assertTrue(appT.isFlagDriving());
		assertFalse(appT.isSensorActivo());
		appT.driving(); 
		assertTrue(appT.isFlagDriving());
		appT.walking();
		assertTrue(this.appT.isFlagDriving());
	
		verifyZeroInteractions(this.appT.getModo());
		
		this.appT.setModoAutomatico();
		
		
		assertTrue(this.appT.isFlagDriving());
		assertTrue(this.appT.isSensorActivo()); // Se enciende el sensor
		this.appT.walking();
		verify(this.appT.getModo(), times(1)).this.appT.getModo().walking(); // el mensaje Walking fue enviado una vez
		assertFalse(this.appT.isFlagDriving()); // Se detecta que se esta caminando
		
		this.appT.walking();
		verify(this.appT.getModo(), times(1)).this.appT.getModo().walking(); // el mensaje Walking no volvio a ser llamado		
		
		this.appT.driving();
		assertTrue(this.appT.isFlagDriving());
		
		
		
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
