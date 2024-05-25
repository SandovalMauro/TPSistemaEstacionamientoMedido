package usuario;

public class Celular {
     private int numero;
     private AppUsuario appUsuario;
     private Zona ubicacion; 
     
     private Celular() {}
     
     protected Celular(int num, Zona ubicacion) {
    	 this.numero = num;
    	 this.appUsuario = new AppUsuario(/*Que necesita?*/); 
    	 this.ubicacion = ubicacion;
     }
     
     public int numero() {  return this.numero;}
     protected ubicacion(){ return this.gps.ubicacion();}
     
     
     
}


