package appUsuario;

import sem.RegistroEstacionamiento;

public class MensajeFin extends Mensaje{

	@Override
	public String mensaje(RegistroEstacionamiento estacionamiento, AppUsuario app) {
		
		return "Hora Fin: "+ estacionamiento.horaIncio().toString() + "\n" +
				"Hora Fin: "+ estacionamiento.horaIncio().toString()+ "\n" +
				"Horas Estacionadas: "+ estacionamiento.cantidadHoras() + "\n" +
				"Monto Final $" + (estacionamiento.cantidadHoras() * app.getSem().getValorHora())+ "\n" +
				"---------------------------" + "\n" +
				app.getMensajeDeModo();
	}

}
