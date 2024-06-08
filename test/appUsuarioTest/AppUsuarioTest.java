package appUsuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.SEM;

import static org.mockito.Mockito.*
;
class AppUsuarioTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		SEM sem = mock(SEM.class);
		AppUsuario appT = new AppUsuario(sem, 1167648255, "ABC 123");
	}

	@Test
	void testAppUsuario() {
		assertTrue(this.appT.isFlagDriving());
		assertFalse(this.appT.isSensorActivo());
	
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
