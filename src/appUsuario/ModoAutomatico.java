package appUsuario;

public class ModoAutomatico extends ModoApp{
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

}
