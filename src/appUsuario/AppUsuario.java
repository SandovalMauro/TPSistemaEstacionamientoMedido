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
	private MovementState state;
	private boolean sensorActivo;

	public AppUsuario(SEM sem, int numero, String patente) {
		this.saldo = 0;
		this.sem = sem;
		this.sem.agregarAppUsuario(this);
		this.modo = new ModoManual();
		this.numero = numero;
		this.patente = patente;
		this.state = new Walking(); // Estado inicial
		this.sensorActivo = false;
	}

	public void consultarSaldo() {
		this.sem.consultarSaldoDe(this);
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void cargarSaldo(double cantidad) {
		this.saldo += cantidad;
	}

	public void gastarSaldo(double cantidad) {
		this.saldo -= cantidad;
	}

	public void iniciarEstacionamiento() {
		this.sem.agregarEstacionamiento(new EstacionamientoAppUsuario(this.sem.getHoraActual(), this.calcularHoraFin(),
				this.patente, this.numero));

	}

	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(this.numero); // este queda igual.
	}

	public LocalDateTime calcularHoraFin() {
		return this.horaMin(this.horaMaximaConSaldo(), this.sem.horaCierreHoy());
	}

	private LocalDateTime horaMin(LocalDateTime hora1, LocalDateTime hora2) {
		if (hora1.isBefore(hora2)) {
			return hora1;
		} else
			return hora2;
	}

	private LocalDateTime horaMaximaConSaldo() {
		return sem.getHoraActual().plusHours(this.horasDivSaldo());
	}

	private int horasDivSaldo() {
		return (int) (this.getSaldo() / sem.getValorHora());
	}

	@Override
	public void driving() {
		if (this.sensorActivo) {
			state.handleDriving(this);
		}
	}

	@Override
	public void walking() {
		if (this.sensorActivo) {
			state.handleWalking(this);
		}
	}

	public void setModo(ModoApp modo) {
		this.modo = modo;
		this.modo.sensor(this);
	}

	public ModoApp getModo() {
		return modo;
	}

	public boolean isSensorActivo() {
		return sensorActivo;
	}

	public void setSensorActivo(boolean sensorActivo) {
		this.sensorActivo = sensorActivo;
	}

	public int getNumero() {
		return this.numero;
	}

	public SEM getSem() {
		return sem;
	}

	public void drivingMSG() {
		this.modo.drivingMSG(this);
	}

	public void walkingMSG() {
		this.modo.walkingMSG(this);
	}

	// Nota:
	public void recibirMensaje(Mensaje mensaje, RegistroEstacionamiento estacionamiento) {
		mensaje.mostrar(estacionamiento, this);
	}

	public String getMensajeDeModo() {
		return this.modo.mensajeDeModo();
	}

	public void setState(MovementState state) {
		this.state = state;
	}

	public MovementState getState() {
		return state;
	}

}
