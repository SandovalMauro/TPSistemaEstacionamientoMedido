package sem;

import java.util.ArrayList;

import puntoDeVenta.PuntoDeVenta;

public class Zona {
	private ArrayList<PuntoDeVenta> puntosDeVenta;
	
	public Zona() {
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
	}
	
	public void agregarPuntoDeVenta(PuntoDeVenta punto) {
		this.puntosDeVenta.add(punto);
	}

	public ArrayList<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}
}
