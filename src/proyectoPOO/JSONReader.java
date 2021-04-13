package proyectoPOO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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
			System.out.println(menu);
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
		System.out.println(plato);
		for (int i = 0; i < plato.size(); i++) {
			JSONObject platillo = (JSONObject) plato.get(i);
			System.out.println(platillo.get("Nombre"));
			System.out.println(platillo.get("Precio"));
			System.out.println(platillo.get("Duracion"));
			JSONArray tamano = (JSONArray) platillo.get("Tamano");
			for (int i2 = 0; i2 < tamano.size(); i2++) {
				System.out.println(tamano.get(i2));
			}
		}
		// Extrae la información de todos los acompañamientos
		JSONArray plato2 = (JSONArray) m.get("Acompanamientos");
		System.out.println(plato2);
		for (int i = 0; i < plato.size(); i++) {
			JSONObject platillo = (JSONObject) plato2.get(i);
			System.out.println(platillo.get("Nombre"));
			System.out.println(platillo.get("Precio"));
			System.out.println(platillo.get("Duracion"));
			JSONArray tipo = (JSONArray) platillo.get("Tipo");
			for (int i2 = 0; i2 < tipo.size(); i2++) {
				System.out.println(tipo.get(i2));
			}
		}
		// Extrae la información de todas las bebidas
		JSONArray plato3 = (JSONArray) m.get("Bebidas");
		System.out.println(plato3);
		for (int i = 0; i < plato.size(); i++) {
			JSONObject platillo = (JSONObject) plato3.get(i);
			System.out.println(platillo.get("Nombre"));
			System.out.println(platillo.get("Precio"));
			System.out.println(platillo.get("Duracion"));
			JSONArray tipo = (JSONArray) platillo.get("Tipo");
			for (int i2 = 0; i2 < tipo.size(); i2++) {
				System.out.println(tipo.get(i2));
			}
			JSONArray tamano = (JSONArray) platillo.get("Tamano");
			for (int i2 = 0; i2 < tamano.size(); i2++) {
				System.out.println(tamano.get(i2));
			}
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
