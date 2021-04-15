package proyectoPOO;

import java.util.ArrayList;

public class Bebida extends Alimento {

		String tipo="";
		int tamanno = 0;
		//int espacio = 1;
		
		public ArrayList<String> info() {
			ArrayList<String> infoGeneral = super.info();
			infoGeneral.add(tipo);
			infoGeneral.add(String.valueOf(tamanno));
			return infoGeneral;
		}
}
