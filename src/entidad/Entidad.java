package entidad;

public class Entidad implements Observador {

    @Override
    public void actualizar(Evento e) {
    	// Mensaje para el inicio del estacionamiento.
        if (e.getTipo().equals("InicioEstacionamiento")) {
            System.out.println("Estacionamiento iniciado.");
            
        // Mensaje para el finalizado del estacionamiento.
        } else if (e.getTipo().equals("FinEstacionamiento")) {
            System.out.println("Estacionamiento finalizado.");
            
        // Mensaje para las recargas de crédito.
        } else if (e.getTipo().equals("RecargaCredito")) {
            System.out.println("Credito recargado.");
        }
    }
}

