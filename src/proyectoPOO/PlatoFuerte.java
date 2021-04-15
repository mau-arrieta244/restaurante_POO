package proyectoPOO;

import java.util.ArrayList;

public class PlatoFuerte extends Alimento {
	
	String tamanno = "";
	//int espacio = 3;
	
	public ArrayList<String> info() {
		ArrayList<String> infoGeneral = super.info();
		infoGeneral.add(String.valueOf(tamanno));
		return infoGeneral;
	}
	
}
