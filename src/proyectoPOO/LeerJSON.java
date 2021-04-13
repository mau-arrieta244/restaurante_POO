package JSONReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.*;
import org.json.simple.*;

public class LeerJSON {
	
	JSONParser parser;
	List fuertes;
	List acompanamientos;
	List bebidas;
	
	public LeerJSON() {
		parser = new JSONParser();
		
		try {
			JSONObject menu = (JSONObject) parser.parse(new FileReader("Menu.json"));
			System.out.println(menu);
			extraerInfo(menu);
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
	}
	
	private static void extraerInfo(JSONObject m) {
		JSONArray plato = (JSONArray) m.get("Plato fuerte");
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

	public static void main(String[] args) {
		LeerJSON objeto = new LeerJSON();
	}
}
