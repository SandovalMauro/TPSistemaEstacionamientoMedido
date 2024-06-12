package sem;



import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidad.Evento;
import entidad.Observador;
import entidad.Sujeto;
import inspector.Infraccion;
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
	}
	
	public List<Compra> compras() {
		return this.compras;
	}
		
	public List<RegistroEstacionamiento> estacionados(){
		return this.estacionados;
	}

	public void finalizarEstacionamiento(int num) { 
		// TODO Auto-generated method stub ---- el numero es para saber a quien hay que fletar
		
	}

	public void nuevoEstacionamiento(int numero, String patente){
		
	}
	
	public boolean estaVigente(String patente) {
		// TODO Auto-generated method stub
		RegistroEstacionamiento estacionamiento = this.buscarEstacionamiento(patente);
		if(estacionamiento!=null) {
			return estacionamiento.estaVigente(this.getHoraActual());
		}
		return false;
	}

	
	public RegistroEstacionamiento buscarEstacionamiento(String patente) {
		//VER elige la primera en aparecer creo que deberia ser la ultima en aparecer
		// List<RegistroEstacionamiento> listaInvertida = new ArrayList<RegistroEstacionamiento>(this.estacionados);
		//Collect.reverse(listaInvertida);
		return this.estacionados.stream().filter(compra -> compra.getPatente().equals(patente)).findFirst().orElse(null);
	}
	
	public LocalDateTime getHoraActual() {
		return this.horaActual;
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

	@Override
    public void notificar(Evento e) {
        for (Observador o : observadores) {
            o.actualizar(e);
        }
    }

	
	/*
	AGREGAR "notificar(new Evento("InicioEstacionamiento", null));" al método iniciarEstacionamiento
	AGREGAR "notificar(new Evento(\"FinEstacionamiento\", null));" al método finalizarEstacionamiento
	AGREGAR "notificar(new Evento("RecargaCredito", null));" al método recargarCredito
	*/


}
