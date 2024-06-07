package appUsuario;

import sem.SEM;
import usuario.Celular;

public class AppUsuario implements MovementSensor {
	private double saldo;
	private int numero;
	private SEM sem;
	private ModoApp modo;
	private String patente;

	protected AppUsuario(SEM sem, int numero, String patente) {
		this.saldo = 0;
		this.sem = sem;
		this.modo = new ModoManual();
		this.numero = numero;
		this.patente = patente;
		
	}

	public double saldo() {
		return saldo;
	}

	
	
	
	public void pasarAAutomatico(){this.modo = new ModoAutomatico();}
	public void pasarAManual(){this.modo = new ModoManual();}	
	
	public void iniciarEstacionamiento() {}

	public void finalizarEstacionamiento() {}

	private void duracion() {}

	@Override
	public void driving() {}

	@Override
	public void walking() {}

}
