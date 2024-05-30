package puntoDeVenta;

import java.time.LocalDate;

public class CompraPuntual extends Compra{
	private int hsCompradas;

	public CompraPuntual(PuntoDeVenta puntoDeVenta, LocalDate fechaYHora, int hsCompradas) {
		super(puntoDeVenta, fechaYHora);
		// TODO Auto-generated constructor stub
		this.hsCompradas = hsCompradas;
	}

}
