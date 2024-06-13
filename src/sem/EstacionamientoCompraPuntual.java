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
	public LocalDateTime horaInicio() {
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

	@Override
	public void setHoraFin(LocalDateTime nuevaHora) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cantidadHoras() {
		// TODO Auto-generated method stub
		return this.compra.getHsCompradas();
	}

}
