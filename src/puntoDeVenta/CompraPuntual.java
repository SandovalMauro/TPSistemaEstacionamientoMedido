package puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CompraPuntual extends Compra{
	private int hsCompradas;

	public CompraPuntual(PuntoDeVenta puntoDeVenta, LocalDateTime fechaInicio, int hsCompradas) {
		super(puntoDeVenta, fechaInicio);
		// TODO Auto-generated constructor stub
		this.hsCompradas = hsCompradas;
	}
	


}
