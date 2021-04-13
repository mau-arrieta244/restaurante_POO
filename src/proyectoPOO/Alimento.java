package proyectoPOO;


public  class Alimento {
		String nombre = "";
		int precio = 0;
		int tiempoProduccion = 0;
		int espacio = 0;
		boolean activo = true;
		//activo funciona para revisar dentro de colaProduccion
		//si tiempoProduccion llega a 0, activo = false y ya no
		//se vuelve a agregar a la colaProduccion desde colaClientes.
		
		boolean usado = false; // para que aun si no ha llegado a tiempo 0,
		//no se vuelva a incluir en colaProduccion ya que estaria repitiendo
		
}
