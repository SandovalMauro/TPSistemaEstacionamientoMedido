package appUsuario;

import sem.RegistroEstacionamiento;

public abstract class Mensaje {

	public abstract String mensaje(RegistroEstacionamiento estacionamiento, AppUsuario app);
	
	public void mostrar(RegistroEstacionamiento estacionamiento, AppUsuario app) {
		System.out.print(this.mensaje(estacionamiento,app));
	}
}
