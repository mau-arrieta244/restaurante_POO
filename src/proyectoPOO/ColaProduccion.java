package proyectoPOO;
import java.util.ArrayList;

public class ColaProduccion {
	ArrayList<Alimento> produccion = new ArrayList<Alimento>();
	
	int espacioOcupado() {
		int espacio = 0;
		
		for(Alimento alimento : produccion) {
			espacio+=alimento.espacio;
		}
		return espacio;
	}
}
