package proyectoPOO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.json.simple.parser.*;
import org.json.simple.*;

public class JSONReader {
	
	JSONParser parser;
	List fuertes;
	List acompanamientos;
	List bebidas;
	
	public JSONReader() {
		parser = new JSONParser();
		
		try {
			// Crea un objeto tipo JSON que contiene toda la información
			JSONObject menu = (JSONObject) parser.parse(new FileReader("Menu.json"));
			//System.out.println(menu);
			extraerInfo(menu); // Extrae toda la información del JSON
		}
		// En caso se que se encuentre algun error
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
	}
	
	private static void extraerInfo(JSONObject m) {
		// Extrae la información de todos los platos fuertes
		JSONArray plato = (JSONArray) m.get("Plato fuerte"); // Cuando en el JSON tiene paréntesis cuadrados, se usan los JSONArrays
		//System.out.println(plato);
		for (int i = 0; i < plato.size(); i++) {
			PlatoFuerte f1 = new PlatoFuerte();
			f1.espacio = 3;//siempre ocupan 3 espacios...
			JSONObject platillo = (JSONObject) plato.get(i);
			
			//System.out.println(platillo.get("Nombre"));
			f1.nombre = platillo.get("Nombre").toString();
			System.out.println(f1.nombre);
			
			//System.out.println(platillo.get("Precio"));
			f1.precio = Integer.valueOf(platillo.get("Precio").toString());
			System.out.println(f1.precio);
			
			//System.out.println(platillo.get("Duracion"));
			f1.tiempoProduccion = Integer.valueOf(platillo.get("Duracion").toString());
			System.out.println(f1.tiempoProduccion);
			
			JSONArray tamano = (JSONArray) platillo.get("Tamano");
			Random random = new Random();
			int aleatorio = random.nextInt(2);
			f1.tamanno = tamano.get(aleatorio).toString();
			System.out.println(f1.tamanno);
			
			//for (int i2 = 0; i2 < tamano.size(); i2++) {
				//System.out.println(tamano.get(i2));
			//}
			
		System.out.println("\n -------- \n ");
		}
		// Extrae la información de todos los acompañamientos
		
		JSONArray plato2 = (JSONArray) m.get("Acompanamientos");
		//System.out.println(plato2);
		for (int i = 0; i < plato.size(); i++) {
			Acompannamiento a1 = new Acompannamiento();
			a1.espacio = 2;//siempre ocupan 2 espacios...
			JSONObject platillo = (JSONObject) plato2.get(i);
			
			//System.out.println(platillo.get("Nombre"));
			a1.nombre = platillo.get("Nombre").toString();
			System.out.println(a1.nombre);
			
			//System.out.println(platillo.get("Precio"));
			a1.precio = Integer.valueOf(platillo.get("Precio").toString());
			System.out.println(a1.precio);
			
			//System.out.println(platillo.get("Duracion"));
			a1.tiempoProduccion = Integer.valueOf(platillo.get("Duracion").toString());
			System.out.println(a1.tiempoProduccion);
			
			JSONArray tipo = (JSONArray) platillo.get("Tipo");
			Random random1 = new Random();
			int indice = random1.nextInt(2);
			a1.tipo = tipo.get(indice).toString();
			System.out.println(a1.tipo);
			/*
			for (int i2 = 0; i2 < tipo.size(); i2++) {
				System.out.println(tipo.get(i2));
			}*/
			System.out.println(" \n ------- \n ");
		}
		// Extrae la información de todas las bebidas
		JSONArray plato3 = (JSONArray) m.get("Bebidas");
		//System.out.println(plato3);
		for (int i = 0; i < plato.size(); i++) {
			Bebida b1 = new Bebida();
			b1.espacio = 1;//siempre ocupan 1 espacio...
			JSONObject platillo = (JSONObject) plato3.get(i);
			
			//System.out.println(platillo.get("Nombre"));
			b1.nombre = platillo.get("Nombre").toString();
			System.out.println(b1.nombre);
			
			//System.out.println(platillo.get("Precio"));
			b1.precio = Integer.valueOf(platillo.get("Precio").toString());
			System.out.println(b1.precio);
			
			//System.out.println(platillo.get("Duracion"));
			b1.tiempoProduccion = Integer.valueOf(platillo.get("Duracion").toString());
			System.out.println(b1.tiempoProduccion);
			
			JSONArray tipo = (JSONArray) platillo.get("Tipo");
			Random random2 = new Random();
			int indice = random2.nextInt(2);
			b1.tipo = tipo.get(indice).toString();
			System.out.println(b1.tipo);
			
			JSONArray tamano = (JSONArray) platillo.get("Tamano");
			Random random3 = new Random();
			int indice1 = random3.nextInt(3);
			b1.tamanno = Integer.valueOf(tamano.get(indice1).toString());
			System.out.println(b1.tamanno);
			
			System.out.println(" \n -------- \n");
		}
		
	}
	
	public List platosFuerte() {
		return fuertes;
	}
	
	public List acompanamientos() {
		return acompanamientos;
	}
	
	public List bebidas() {
		return bebidas;
	}
}
