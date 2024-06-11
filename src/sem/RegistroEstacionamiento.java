package sem;

import java.time.LocalDateTime;

public abstract class RegistroEstacionamiento {
	private String patente;
	
	public RegistroEstacionamiento(String patente) {
		this.patente = patente;
	}
	
	public abstract int getCelular();
	
	public abstract LocalDateTime horaIncio();
	
	public abstract LocalDateTime horaFin();
	
	public boolean estaVigente(LocalDateTime horaActual) {
		//Ver si lanzar Excepcion si la horaActual es menor a la hora de inicio
		return horaActual.isAfter(this.horaIncio()) && horaActual.isBefore(this.horaFin());
	}
	
	public String getPatente() {
		return this.patente;
	}
	
}
