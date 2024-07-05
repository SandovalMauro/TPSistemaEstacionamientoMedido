package appUsuario;

public class Driving implements DrivingState {
	@Override
	public void handleDriving(AppUsuario appUsuario) {
		// Ya está manejando, no hacer nada
	}

	@Override
	public void handleWalking(AppUsuario appUsuario) {
		appUsuario.walkingMSG();
		siguienteEstado(appUsuario);
	}

	@Override
	public void siguienteEstado(AppUsuario appUsuario) {
		appUsuario.setState(new Walking());
	}

}
