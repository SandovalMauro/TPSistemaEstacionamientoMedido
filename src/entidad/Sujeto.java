package entidad;

public interface Sujeto {
    void subscribir(Observador o);
    void desuscribir(Observador o);
    void notificar(Evento e);
}

