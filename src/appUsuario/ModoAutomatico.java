package appUsuario;

public class ModoAutomatico implements ModoApp{
	@Override
	public void drivingMSG(AppUsuario app) {
		app.finalizarEstacionamiento();
	}

	@Override
	public void walkingMSG(AppUsuario app) {
		app.iniciarEstacionamiento();		
	}
	
	@Override
	public void sensor(AppUsuario app) {
		app.setSensorActivo(true);
		
	}
	
	@Override
	public String mensajeDeModo() {
		return " Esta acción ha sido realizada de manera automática.";
	}

}
