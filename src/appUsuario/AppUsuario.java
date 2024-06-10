package appUsuario;
import sem.SEM;


public class AppUsuario implements MovementSensor {
	private double saldo;
	private int numero;
	private SEM sem;
	private ModoApp modo;
	private String patente;
	private boolean flagDriving;
	private boolean sensorActivo;


	public AppUsuario(SEM sem, int numero, String patente) {
		this.saldo = 0;
		this.sem = sem;
		this.modo = new ModoManual();
		this.numero = numero;
		this.patente = patente;
		this.flagDriving = true;
		this.sensorActivo = false;
	}

	
	public double saldo() { return this.saldo; }
	
	public void cargarSaldo(double cantidad) { this.saldo += cantidad; }
	
	public void pasarAAutomatico(){this.modo = new ModoAutomatico();}
	public void pasarAManual(){this.modo = new ModoManual();}	
	
	public void iniciarEstacionamiento() {;
		this.sem.nuevoEstacionamiento(this.numero, this.patente);
	}

	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(this.numero);
	}

	private void duracion() { /*???????????????????????????????????????????*/}

	@Override
	public void driving() {
		if (this.sensorActivo && !this.flagDriving) {
			this.modo.driving(this); this.flagDriving = true;
	}   }

	@Override
	public void walking() {
		if (this.sensorActivo && this.flagDriving) {
			this.modo.walking(this); this.flagDriving = false;
	}	}

	public void setModoAutomatico() { this.modo = new ModoAutomatico(); this.sensorActivo = true ;}
	public void     setModoManual() { this.modo = new ModoManual();     this.sensorActivo = false;}


	public boolean isFlagDriving() { return flagDriving;}
	public boolean isSensorActivo() { return sensorActivo;}
	public ModoApp getModo() {return modo;}
	
}
