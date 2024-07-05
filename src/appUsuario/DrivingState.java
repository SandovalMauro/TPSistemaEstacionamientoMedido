package appUsuario;

public interface DrivingState {
	void handleDriving(AppUsuario appUsuario);

	void handleWalking(AppUsuario appUsuario);

	void siguienteEstado(AppUsuario appUsuario);
}
