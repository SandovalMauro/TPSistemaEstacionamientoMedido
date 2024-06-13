package appUsuario;

import sem.RegistroEstacionamiento;

public class MensajeFin extends Mensaje{

	@Override
	public String mensaje(RegistroEstacionamiento estacionamiento, AppUsuario app) {
		
		return "Hora Fin: "+ estacionamiento.horaInicio().toString() + "\n" +
				"Hora Fin: "+ estacionamiento.horaFin().toString()+ "\n" +
				"Horas Estacionadas: "+ estacionamiento.cantidadHoras() + "\n" +
				"Monto Final $" + (estacionamiento.cantidadHoras() * app.getSem().getValorHora())+ "\n" +
				"---------------------------" + "\n" +
				app.getMensajeDeModo();
	}

}
