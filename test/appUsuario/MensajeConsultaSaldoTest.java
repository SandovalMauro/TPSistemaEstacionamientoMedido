package appUsuario;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class MensajeConsultaSaldoTest {

	Mensaje mensajeSaldo;
	AppUsuario appT;
	
	
	@Test
	void alpreguntarElSaldoEsteLoMuestraEnConsola() {
		mensajeSaldo = new MensajeConsultaSaldo();
		appT = mock(AppUsuario.class);
		when(appT.getSaldo()).thenReturn(300.00);
		mensajeSaldo.mostrar(null, appT);
		

	}

}
