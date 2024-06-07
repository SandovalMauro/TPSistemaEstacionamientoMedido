package entidad;

public class Entidad implements Observador {

    @Override
    public void actualizar(Evento e) {
        // lógica para manejar las actualizaciones según el evento
        if (e.getTipo().equals("InicioEstacionamiento")) {
            // manejar el inicio del estacionamiento
            System.out.println("Estacionamiento iniciado.");
        } else if (e.getTipo().equals("FinEstacionamiento")) {
            // manejar el fin del estacionamiento
            System.out.println("Estacionamiento finalizado.");
        } else if (e.getTipo().equals("RecargaCredito")) {
            // manejar la recarga de crédito
            System.out.println("Credito recargado.");
        }
    }
}

