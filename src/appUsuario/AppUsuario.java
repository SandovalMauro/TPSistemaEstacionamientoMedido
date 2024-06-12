package appUsuario;
import java.time.Duration;
import java.time.LocalDateTime;

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
		this.sem.agregarEstacionamiento(new RegistroEstacionamiento(this.sem.horaActual(), this.calcularHoraFin(), this.patente));
	//this.sem.nuevoEstacionamiento(this.numero, this.patente);    // IMPLEMENTAR !!!!!!
	}

	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(this.numero); // este queda igual.
	}

	LocalDateTime calcularHoraFin() {
		return this.horaMin(this.horaMaximaConSaldo(),this.sem.horaCierreHoy()); }

	
	private LocalDateTime horaMin(LocalDateTime hora1, LocalDateTime hora2) {
		if (hora1.isBefore(hora2)) {return hora1;} else return hora2;
	}
	
	
	private LocalDateTime horaMaximaConSaldo() {	
		return sem.horaActual().plusHours(this.horasDivSaldo());
	}

	protected int horasDivSaldo() {
		return (int) (this.saldo() / sem.getValorHora());
	}
	
	
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
