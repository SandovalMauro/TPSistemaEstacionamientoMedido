package sem;

import inspector.Infraccion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidad.Evento;
import entidad.Observador;
import entidad.Sujeto;
import puntoDeVenta.Compra;

public class SEM implements Sujeto {
	private List<Observador> observadores = new ArrayList<>();
	private Map<String, Infraccion> infracciones;
	private List<Compra> compras;
	private List<RegistroEstacionamiento> estacionados;
	private LocalDateTime horaActual;

	public SEM() {
		this.compras = new ArrayList<Compra>();
		this.estacionados = new ArrayList<RegistroEstacionamiento>();
		this.infracciones = new HashMap<>();
	}

	public void agregarCompra(Compra compra) {
		this.compras.add(compra);
	}

	public void agregarEstacionamiento(RegistroEstacionamiento estacionamiento) {
		this.estacionados.add(estacionamiento);

		// Notifica a las entidades
		Evento evento = new Evento("InicioEstacionamiento", estacionamiento);
		notificar(evento);
	}

	public List<Compra> compras() {
		return this.compras;
	}

	public List<RegistroEstacionamiento> estacionados() {
		return this.estacionados;
	}

	public void finalizarEstacionamiento(int num) {
		// TODO Auto-generated method stub ---- el numero es para saber a quien hay que
		// fletar

		Evento evento = new Evento("FinEstacionamiento", num);
		notificar(evento);
	}

	public boolean estaVigente(String patente) {
		// TODO Auto-generated method stub
		RegistroEstacionamiento estacionamiento = this.buscarEstacionamiento(patente);
		if (estacionamiento != null) {
			return estacionamiento.estaVigente(this.getHoraActual());
		}
		return false;
	}

	public RegistroEstacionamiento buscarEstacionamiento(String patente) {
		// VER elige la primera en aparecer creo que deberia ser la ultima en aparecer
		// List<RegistroEstacionamiento> listaInvertida = new
		// ArrayList<RegistroEstacionamiento>(this.estacionados);
		// Collect.reverse(listaInvertida);
		return this.estacionados.stream().filter(compra -> compra.getPatente().equals(patente)).findFirst()
				.orElse(null);
	}

	public LocalDateTime getHoraActual() {
		return this.horaActual;
	}

	public double getValorHora() {
		return 40.00;
	}

	public LocalDateTime horaCierreHoy() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cargarCredito() {

		// Evento evento = new Evento("RecargaCredito", Dato);
		// notificar(evento);
	}

	public void agregarInfraccion(Infraccion infraccion) {
		infracciones.put(infraccion.getPatente(), infraccion);
	}

	public Infraccion obtenerInfraccion(String patente) {
		return infracciones.get(patente);
	}

	@Override
	public void subscribir(Observador o) {
		observadores.add(o);
	}

	@Override
	public void desuscribir(Observador o) {
		observadores.remove(o);
	}

	public void notificar(Evento e) {
        for (Observador o : observadores) {
            o.actualizar(e);
        }
    }

	public List<Observador> getObservadores() {
		return observadores;
	}

}


