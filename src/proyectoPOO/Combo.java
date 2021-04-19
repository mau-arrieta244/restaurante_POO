package proyectoPOO;

import java.util.Random;

public class Combo {
	/*Esta clase verifica si algun pedido tiene alimentos que son candidatos para
	 * aplicar un descuento, por lo que tiene alimentos predefinidos que van a ser
	 * comparados con el pedido ingresado.
	 * 
	 * La clase escoge alimentos al azar del menu, y crea combos a partir de ellos,
	 * luego, si los alimentos del pedido coinciden con los de los combos, se aplica
	 * la oferta, que en este caso, la bebida, sin importar cual sea, será gratis.
	 * 
	 * Existirán tres combos aplicables, los cuales contienen: un plato fuerte en específico,
	 * un acompañamiento en específico, y una bebida cualquiera.
	 * 
	 * Todos los combos tendrán esta estructura.
	 * 
	 * Como todos los combos tienen un plato fuerte incluido, se buscará este para su comparación,
	 * si el pedido no incluye ninguno, entonces no aplica.
	 */
	
	// Combos aplicables a los pedidos
	PlatoFuerte platoCombo1;
	Acompannamiento acompannamientoCombo1;
	PlatoFuerte platoCombo2;
	Acompannamiento acompannamientoCombo2;
	PlatoFuerte platoCombo3;
	Acompannamiento acompannamientoCombo3;
	
	// Elige los alimentos que van a participar en los combos
	public void llenar(Menu alimentos) {
		Random rnd = new Random();
		Alimento aux;
		int cont = 0;
		while (cont < 3) {  // Lee alimentos que son de tipo Plato Fuerte
			int i = rnd.nextInt(alimentos.items.size());
			aux = alimentos.items.get(i);
			if (aux.espacio == 3) {
				if (platoCombo1 == null) // En caso de que no haya ningún Plato Fuerte almacenado
					platoCombo1 = (PlatoFuerte) aux;
				else {
					if (platoCombo2 == null) // En caso de que el Plato Fuerte del primer combo ya haya sido seleccionado
						platoCombo2 = (PlatoFuerte) aux;
					else // En caso de que ya se hayan seleccionado los Platos Fuertes en los otros combos
						platoCombo3 = (PlatoFuerte) aux;
				}
				cont++;
			}
		}
		cont = 0;
		while (cont < 3) {	// Lee alimentos que son de tipo Acompañamiento
			int i = rnd.nextInt(alimentos.items.size());
			aux = alimentos.items.get(i);
			if (aux.espacio == 2) {
				if (acompannamientoCombo1 == null)	// En caso de que no haya ningún Acompañamiento almacenado
					acompannamientoCombo1 = (Acompannamiento) aux;
				else {
					if (acompannamientoCombo2 == null) // En caso de que el Acompañamiento del primer combo ya haya sido seleccionado
						acompannamientoCombo2 = (Acompannamiento) aux;
					else	// En caso de que ya se hayan seleccionado los Acompañamientos en los otros combos
						acompannamientoCombo3 = (Acompannamiento) aux;
				}
				cont++;
			}
		}
	}
	
	public int comparar(Pedido orden) {
		int precioDescontar = 0;
		for (Alimento subOrden : orden.items) { 	// Revisa todos los alimentos del pedido en busca de un Plato Fuerte
			if (subOrden.nombre == platoCombo1.nombre) {	// Si coincide con el Plato Fuerte del combo 1
				for (Alimento subOrden2 : orden.items) {	// Revisa todos los alimentos del pedido en busca de un Acompañamiento
					if (subOrden2.nombre == acompannamientoCombo1.nombre) {	// Si coincide con el Acompañamiento del combo 1
						for (Alimento subOrden3 : orden.items) {	// Revisa todos los alimentos del pedido en busca de una Bebida
							if (subOrden3.espacio == 1) {	// Si exista una bebida en el pedido
								precioDescontar += subOrden3.precio;	// Se guarda el precio de la bebida para retirarla después
								System.out.println("Descuento aplicado para: " + subOrden.nombre + ", " + subOrden2.nombre + ", " + subOrden3.nombre + ", ");
							}
						}
					}
				}
			}
			else {
				if (subOrden.nombre == platoCombo2.nombre) {	// Si coincide con el Plato Fuerte del combo 2
					for (Alimento subOrden2 : orden.items) {	// Revisa todos los alimentos del pedido en busca de un Acompañamiento
						if (subOrden2.nombre == acompannamientoCombo2.nombre) {	// Si coincide con el Acompañamiento del combo 2
							for (Alimento subOrden3 : orden.items) {	// Revisa todos los alimentos del pedido en busca de una Bebida
								if (subOrden3.espacio == 1) {	// Si exista una bebida en el pedido
									precioDescontar += subOrden3.precio;
									System.out.println("Descuento aplicado para: " + subOrden.nombre + ", " + subOrden2.nombre + ", " + subOrden3.nombre + ", ");
								}
							}
						}
					}
				}
				else {
					if (subOrden.nombre == platoCombo3.nombre) {	// Si coincide con el Plato Fuerte del combo 3
						for (Alimento subOrden2 : orden.items) {	// Revisa todos los alimentos del pedido en busca de un Acompañamiento
							if (subOrden2.nombre == acompannamientoCombo2.nombre) {	// Si coincide con el Acompañamiento del combo 3
								for (Alimento subOrden3 : orden.items) {	// Revisa todos los alimentos del pedido en busca de una Bebida
									if (subOrden3.espacio == 1) {	// Si exista una bebida en el pedido
										precioDescontar += subOrden3.precio;
										System.out.println("Descuento aplicado para: " + subOrden.nombre + ", " + subOrden2.nombre + ", " + subOrden3.nombre + ", ");
									}
								}
							}
						}
					}
					else {
						continue;
					}
				}
			}
		}
		int totalPrecio = 0;
		for (Alimento subOrden : orden.items) {	// Calcula el precio de todo el pedido
			totalPrecio += subOrden.precio;
		}
		return (totalPrecio - precioDescontar); // Se retorna el precio con la bebida descontada
	}
}
