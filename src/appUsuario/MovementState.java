package appUsuario;

public interface MovementState {
	void handleDriving(AppUsuario appUsuario);

	void handleWalking(AppUsuario appUsuario);

	void siguienteEstado(AppUsuario appUsuario);
}
