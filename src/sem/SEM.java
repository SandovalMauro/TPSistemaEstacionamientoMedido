package sem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import puntoDeVenta.Compra;
import usuario.Usuario;

public class SEM {
	
	private List<Compra> compras;
	private List<RegistroEstacionamiento> estacionados;
	
	public SEM() {
		this.compras = new ArrayList<Compra>();
		this.estacionados = new ArrayList<RegistroEstacionamiento>();
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
}
