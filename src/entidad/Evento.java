package entidad;

public class Evento {
    private String tipo;
    private Object datos;

    // Constructor
    
    public Evento(String tipo, Object datos) {
        this.tipo = tipo;
        this.datos = datos;
    }

    // Getters y Setters
    
    public String getTipo() {
        return tipo;
    }

    public Object getDatos() {
        return datos;
    }
}

