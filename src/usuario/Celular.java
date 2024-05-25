package usuario;

public class Celular {
     public int numero;
     private AppUsuario appUsuario;
     
     protected Celular() {}
     
     protected Celular(int num) {
    	 this.numero = num;
    	 this.appUsuario = new AppUsuario();
     }
     
     public int numero() { return this.numero; }
     
}
