package appUsuario;

public class ModoManual extends ModoApp{

	@Override
	public void sensor(AppUsuario app) {
		app.setSensorActivo(false);
		
	}

}


