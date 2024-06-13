package sem;

import java.time.LocalDateTime;
import java.util.ArrayList;

import appUsuario.AppUsuario;

public class EstacionamientoAppUsuario extends RegistroEstacionamiento{
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private int celular;

	
	public EstacionamientoAppUsuario(LocalDateTime horaInicio, LocalDateTime horaFin, String patente, int celular) {
		super(patente);
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.celular = celular;
	}


	
	@Override
	public LocalDateTime horaIncio() {
		// TODO Auto-generated method stub
		return this.horaInicio;
	}

	@Override
	public LocalDateTime horaFin() {
		// TODO Auto-generated method stub
		return this.horaFin;
	}

	@Override
	public int getCelular() {
		// TODO Auto-generated method stub
		return this.celular;
	}

	@Override
	public void horaFin(LocalDateTime nuevaHora) {
		// TODO Auto-generated method stub
		this.horaFin = nuevaHora;
	}

}
