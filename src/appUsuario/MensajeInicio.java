package appUsuario;

import sem.RegistroEstacionamiento;

public class MensajeInicio extends Mensaje{

	@Override
	public String mensaje(RegistroEstacionamiento estacionamiento, AppUsuario app) {
		
		if(app.saldo()>= app.getSem().getValorHora()) {
			
		
		return "#############################" + "\n" +
				"Inicio de estacionamiento " + "\n" +
				"Hora Inicio: "+ estacionamiento.horaInicio().toString() + "\n" +
				"Hora Fin Maxima: "+ estacionamiento.horaFin().toString()+ "\n" +
				"---------------------------" + "\n" +
				app.getMensajeDeModo() + "\n" +
				"#############################";
		}
		else {
			return "Saldo insuficiente. Estacionamiento no permitido.";
		}
	}
}
