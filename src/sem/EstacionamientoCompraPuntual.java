package sem;


import java.time.LocalDateTime;

import puntoDeVenta.CompraPuntual;

public class EstacionamientoCompraPuntual extends RegistroEstacionamiento{
	private CompraPuntual compra;
	
	public EstacionamientoCompraPuntual(CompraPuntual compra, String patente) {
		super(patente);
		this.compra = compra;
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
	public int getCelular() {
		// TODO Auto-generated method stub
		return 0;
	}

}
