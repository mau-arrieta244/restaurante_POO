package proyectoPOO;

import java.util.ArrayList;
import java.util.Random;

public class Pedido {

	ArrayList<Alimento> items = new ArrayList<Alimento>();
	//boolean activo = true;
	//boolean impaciente determina si pedido es de tipo impaciente o no.
	//todos los pedidos van a tener contadorPaciencia pero no todos tienen el booleano en true.
	//para eliminar, verificar ambas condiciones con un &&, si cumple ambas, es impaciente y llego a 0, se saca.
	boolean impaciente = false;
	
	Random r = new Random();
	int low = 5; // incluido
	int high = 10;//excluido
	int result = r.nextInt(high-low) + low;
	int contadorPaciencia = result; // numero arbitrario
}
