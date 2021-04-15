package proyectoPOO;

import java.util.ArrayList;

public class Acompannamiento extends Alimento {
	
	String tipo = "";
	//int espacio = 2;
	
	public ArrayList<String> info() {
		ArrayList<String> infoGeneral = super.info();
		infoGeneral.add(tipo);
		return infoGeneral;
	}
}
