package puntoDeVenta;

import java.time.LocalDate;

public class Recarga extends Compra{
	private double monto;
	private int celular;

	public Recarga(PuntoDeVenta puntoDeVenta, LocalDate fechaYHora, double monto, int celular) {
		super(puntoDeVenta, fechaYHora);
		// TODO Auto-generated constructor stub
		this.monto = monto;
		this.celular = celular;
		
	}

	public int getCelular() {
		return celular;
	}

}
