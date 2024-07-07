package appUsuario;

public class Walking implements MovementState {
	@Override
	public void handleDriving(AppUsuario appUsuario) {
		appUsuario.drivingMSG();
		siguienteEstado(appUsuario);
	}

	@Override
	public void handleWalking(AppUsuario appUsuario) {
		// Ya está caminando, no hacer nada
	}

	@Override
	public void siguienteEstado(AppUsuario appUsuario) {
		appUsuario.setState(new Driving());
	}

}
