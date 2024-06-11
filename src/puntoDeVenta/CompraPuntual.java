package puntoDeVenta;


import java.time.LocalDateTime;

public class CompraPuntual extends Compra{
	private int hsCompradas;

	public CompraPuntual(PuntoDeVenta puntoDeVenta, LocalDateTime fechaYHora, int hsCompradas) {
		super(puntoDeVenta, fechaYHora);
		// TODO Auto-generated constructor stub
		this.hsCompradas = hsCompradas;
	}

	public int getHsCompradas() {
		return hsCompradas;
	}
	


}
