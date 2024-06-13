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
		this.sem.agregarAppUsuario(this);
		this.modo = new ModoManual();
		this.numero = numero;
		this.patente = patente;
		this.flagDriving = true;
		this.sensorActivo = false;
	}
	
	public double saldo() { return this.saldo; }
	public void cargarSaldo(double cantidad) { this.saldo += cantidad; }
	public void gastarSaldo(double cantidad) { this.saldo -= cantidad; } 
	public void iniciarEstacionamiento() {
		this.sem.agregarEstacionamiento(new EstacionamientoAppUsuario(this.sem.getHoraActual(), this.calcularHoraFin(), this.patente, this.numero));

	}
	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(this.numero); // este queda igual.
	}
	public LocalDateTime calcularHoraFin() {
		return this.horaMin(this.horaMaximaConSaldo(),this.sem.horaCierreHoy()); }
	private LocalDateTime horaMin(LocalDateTime hora1, LocalDateTime hora2) {
		if (hora1.isBefore(hora2)) {return hora1;} else return hora2;
	}
	private LocalDateTime horaMaximaConSaldo() {	
		return sem.getHoraActual().plusHours(this.horasDivSaldo());
	}
	private int horasDivSaldo() {
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
	public int getNumero() {
		return this.numero;
	}
	
	public SEM getSem() {
		return sem;
	}
	
	public void recibirMensajeFin(RegistroEstacionamiento estacionamiento) {
		System.out.print("EstacionamientoFinalizado.");
		System.out.print("Hora Fin: "+ estacionamiento.horaIncio().toString());
		System.out.print("Hora Fin: "+ estacionamiento.horaFin().toString());
		System.out.print("Horas Estacionadas: "+ estacionamiento.cantidadHoras());
		System.out.print("Monto Final $" + (estacionamiento.cantidadHoras() * this.sem.getValorHora()));
		System.out.print("---------------------------");
		System.out.print(modo.mensajeDeModo()); 
	}

	public String getMensajeDeModo() {
		// TODO Auto-generated method stub
		return this.modo.mensajeDeModo();
	}
	
	
}


