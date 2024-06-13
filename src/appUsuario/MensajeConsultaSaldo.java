package appUsuario;

import sem.RegistroEstacionamiento;

public class MensajeConsultaSaldo extends Mensaje {

	@Override
	public String mensaje(RegistroEstacionamiento estacionamiento, AppUsuario app) {
		// TODO Auto-generated method stub
		return "#############################" + "\n" +
				"Su saldo actual es de $" + app.saldo()  + "\n" +
				"#############################";
	}

}
