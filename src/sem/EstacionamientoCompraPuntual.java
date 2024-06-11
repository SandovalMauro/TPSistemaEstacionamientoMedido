package sem;


import java.time.LocalDateTime;

import puntoDeVenta.CompraPuntual;

public class EstacionamientoCompraPuntual extends RegistroEstacionamiento{
	private CompraPuntual compra;
	private String patente;
	
	public EstacionamientoCompraPuntual(CompraPuntual compra, String patente) {
		this.compra = compra;
		this.patente = patente;
	}

	@Override
	public LocalDateTime horaIncio() {
		// TODO Auto-generated method stub
		return this.compra.getFechaYHora();
	}

	@Override
	public LocalDateTime horaFin() {
		// TODO Auto-generated method stub
		return this.compra.getFechaYHora().plusHours(this.compra.getHsCompradas());
	}

	@Override
	public boolean estaVigente(LocalDateTime horaActual) {
		// TODO Auto-generated method stub
		return horaActual.isAfter(this.horaIncio()) && horaActual.isBefore(this.horaFin());
	}

}
