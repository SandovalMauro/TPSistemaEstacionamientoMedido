package appUsuario;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sem.SEM;



class AppUsuarioTest {

	SEM sem;
	AppUsuario appT;
	ModoApp modoAutomatico;
	ModoApp modoManual;
	
	
	
	@BeforeEach
	public void setUp() {
		sem = mock(SEM.class);
		appT = new AppUsuario(sem, 1167648255, "ABC 123");
		modoAutomatico = mock(ModoAutomatico.class);
		modoManual =  mock(ModoManual.class);
	}

	@Test
	void seEstaEnModoManualYNoSeHaceNada() {
		appT.setModo(modoManual);
		
		assertTrue(appT.isFlagDriving());
		assertFalse(appT.isSensorActivo());
		appT.driving(); 
		assertTrue(appT.isFlagDriving());
		appT.walking();
		assertTrue(appT.isFlagDriving());

		//verify(appT, never()).getModo();
		
		
	}
	
	@Test 
	void a() {
		appT.setModo(modoAutomatico);
		
		assertTrue(appT.isFlagDriving());
		verify(modoAutomatico, times(1)).sensor(appT); 
		appT.setSensorActivo(true);
		assertTrue(appT.isSensorActivo()); // Se enciende el sensor 
		
		appT.walking();
		
		verify(modoAutomatico, times(1)).walkingMSG(appT); // el mensaje Walking fue enviado una vez
		assertFalse(appT.isFlagDriving()); // Se detecta que se esta caminando
		
		appT.walking();
		verify(modoAutomatico, times(1)).walkingMSG(appT); // el mensaje Walking no volvio a ser llamado		
		
		appT.driving();
		assertTrue(appT.isFlagDriving());
		verify(modoAutomatico, times(1)).drivingMSG(appT);
	}

	
	
	
}
