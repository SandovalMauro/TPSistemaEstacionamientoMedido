package appUsuario;

public class ModoAutomatico extends ModoApp{
	@Override
	public void driving(AppUsuario app) {
		app.finalizarEstacionamiento();
	}

	@Override
	public void walking(AppUsuario app) {
		app.iniciarEstacionamiento();		
	}
}
