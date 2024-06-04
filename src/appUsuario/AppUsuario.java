package appUsuario;

public class AppUsuario implements MovementSensor{
      private double saldo;
      private Sem sem;
      
      public double saldo() {return saldo;}
      protected AppUsuario() {}
      
      protected AppUsuario(Sem sem) {
    	  this.saldo = 0;
    	  this.sem = sem;
      }
      
      public void iniciarEstacionamiento() {
    	  
      }

      public void finalizarEstacionamiento() {
    	  
      }
      
      private void duracion() {
    	  
      }
      
}


