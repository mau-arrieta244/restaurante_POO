package proyectoPOO;
import java.util.ArrayList;

public  class Alimento {
		String nombre = "";
		int precio = 0;
		int tiempoProduccion = 0;
		int espacio = 0;
		boolean activo = true;
		
		//activo funciona para revisar dentro de colaProduccion
		//si tiempoProduccion llega a 0, activo = false y ya no
		//se vuelve a agregar a la colaProduccion desde colaClientes.
		
		boolean usado = false; 
		// para que aun si no ha llegado a tiempo 0,
		//no se vuelva a incluir en colaProduccion ya que estaria repitiendo
		
		boolean impaciencia = false; 
		// si un pedidoImpaciente de colaClientes llega contador impaciencia a 0,
		//impaciencia = true, y dentro de cola revisamos si productos tienen este true y los sacamos
		
		public ArrayList<String> info() {
			ArrayList<String> informacion = new ArrayList<String>();
			informacion.add(nombre);
			informacion.add(String.valueOf(precio));
			informacion.add(String.valueOf(tiempoProduccion));
			return informacion;
		}
}
