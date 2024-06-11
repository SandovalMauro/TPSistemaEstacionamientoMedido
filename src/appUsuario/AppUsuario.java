package appUsuario;
import java.time.LocalDateTime;

import sem.EstacionamientoAppUsuario;
import sem.RegistroEstacionamiento;
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

	
	
	/*
	 * Hacer el registro de estacionamiento en esta clase y enviarsela al SEM. 
	 * 
	 * 
	 * */
	
	public double saldo() { return this.saldo; }
	
	public void cargarSaldo(double cantidad) { this.saldo += cantidad; }
	
	
	public void iniciarEstacionamiento() {;
	    //Hacer el registro de estacionamiento en esta clase y enviarsela al SEM. 
		this.sem.agregarEstacionamiento(new EstacionamientoAppUsuario(this.sem.getHoraActual(), this.calcularHoraFin(), this.patente, this.numero));
	//this.sem.nuevoEstacionamiento(this.numero, this.patente);    // IMPLEMENTAR !!!!!!
	}

	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(this.numero); // este queda igual.
	}

	private LocalDateTime calcularHoraFin() {
		return null; /* VER iniciarEstacionamiento()*/}

	@Override
	public void driving() {
		if (this.sensorActivo && !this.flagDriving) {
			this.modo.drivingMSG(this); this.flagDriving = true;
	}   }

	@Override
	public void walking() {
		if (this.sensorActivo && this.flagDriving) {
			this.modo.walkingMSG(this); this.flagDriving = false;
	}	}

	public void setModo(ModoApp modo) {
			this.modo = modo;     
			this.modo.sensor(this);
		}
	

	public boolean isFlagDriving() { return flagDriving;}
	public ModoApp getModo() {return modo;}



	public boolean isSensorActivo() { return sensorActivo;}
	public void setSensorActivo(boolean sensorActivo) {
		this.sensorActivo = sensorActivo;
	}
	
}
