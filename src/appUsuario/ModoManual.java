package appUsuario;

public class ModoManual implements ModoApp{

	@Override
	public void sensor(AppUsuario app) {
		app.setSensorActivo(false);}

	@Override
	public void drivingMSG(AppUsuario app) {}

	@Override
	public void walkingMSG(AppUsuario app) {}

	@Override
	public String mensajeDeModo() {
		return " Esta acción ha sido realizada de manera manual.";
	}

}


