package appUsuario;

import sem.SEM;
import usuario.Celular;

public class AppUsuario implements MovementSensor {
	private double saldo;
	private SEM sem;
	private ModoApp modo;
	private Celular celular;

	public double saldo() {
		return saldo;
	}

	protected AppUsuario() {
	}

	protected AppUsuario(SEM sem, Celular celular) {
		this.saldo = 0;
		this.sem = sem;
		this.modo = new ModoManual();
		this.celular = celular;
	}
	
	public void pasarAAutomatico(){this.modo = new ModoAutomatico();}
	public void pasarAManual(){this.modo = new ModoManual();}	
	
	public void iniciarEstacionamiento() {
		this.sem.iniciarEstacionamiento(patente);
	}

	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(celular.numero());
	}

	private void duracion() {

	}

	@Override
	public void driving() {
		this.modo.driving(this);
	}

	@Override
	public void walking() {
		this.modo.walking(this);
	}

}
