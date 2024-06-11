package sem;

import java.time.LocalDateTime;

public abstract class RegistroEstacionamiento {
	
	public abstract LocalDateTime horaIncio();
	
	public abstract LocalDateTime horaFin();
	
	public abstract boolean estaVigente(LocalDateTime horaActual);
}
