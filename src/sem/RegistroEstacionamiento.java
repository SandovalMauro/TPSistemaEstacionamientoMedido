package sem;

import java.time.LocalDateTime;


public abstract class RegistroEstacionamiento {
	private String patente;
	
	public RegistroEstacionamiento(String patente) {
		this.patente = patente;
	}
	
	public abstract int getCelular();
	
	public abstract LocalDateTime horaInicio();
	
	public abstract LocalDateTime horaFin();
	
	public boolean estaVigente(LocalDateTime horaActual) {
		//Ver si lanzar Excepcion si la horaActual es menor a la hora de inicio
		return horaActual.isAfter(this.horaInicio()) && horaActual.isBefore(this.horaFin());
	}
	
	public String getPatente() {
		return this.patente;
	}

	public abstract void setHoraFin(LocalDateTime nuevaHora);

	public abstract int cantidadHoras();
}
