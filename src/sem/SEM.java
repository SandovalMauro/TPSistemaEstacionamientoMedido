package sem;

import java.util.ArrayList;
import java.util.List;

import entidad.Evento;
import entidad.Observador;
import entidad.Sujeto;

public class SEM implements Sujeto {
	private List<Observador> observadores = new ArrayList<>();

	@Override
    public void subscribir(Observador o) {
        observadores.add(o);
    }

	@Override
    public void desuscribir(Observador o) {
        observadores.remove(o);
    }

	@Override
    public void notificar(Evento e) {
        for (Observador o : observadores) {
            o.actualizar(e);
        }
    }
	
	
	/*
	AGREGAR "notificar(new Evento("InicioEstacionamiento", null));" al método iniciarEstacionamiento
	AGREGAR "notificar(new Evento(\"FinEstacionamiento\", null));" al método finalizarEstacionamiento
	AGREGAR "notificar(new Evento("RecargaCredito", null));" al método recargarCredito
	*/

}
