package appUsuario;

import sem.SEM;

public class AppUsuario implements MovementSensor {
	private double saldo;
	private SEM sem;
	private ModoApp modo;

	public double saldo() {
		return saldo;
	}

	protected AppUsuario() {
	}

	protected AppUsuario(SEM sem) {
		this.saldo = 0;
		this.sem = sem;
		this.modo = new ModoManual();
	}
	
	public void pasarAAutomatico(){this.modo = new ModoAutomatico();}
	public void pasarAManual(){this.modo = new ModoManual();}	
	
	public void iniciarEstacionamiento() {
		this.sem.iniciarEstacionamiento(patente);
	}

	public void finalizarEstacionamiento(int num) {
		this.sem.finalizarEstacionamiento(num);
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
