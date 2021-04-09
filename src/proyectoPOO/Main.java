package proyectoPOO;
//import java.util.Scanner; para inputs


public class Main {
	
	//global
	static Cola colaClientes = new Cola();
	static ColaProduccion colaProduc = new ColaProduccion();
	
	public static void avanzar() {
		// 1. Ir metiendo productos de cola hasta que no haya espacio
		int disponible = (10-colaProduc.espacioOcupado());
		for(Pedido pedido : colaClientes.pedidosTotales) {
			for(Alimento alimento : pedido.items) {
				if(alimento.activo==true) {
					if(disponible >= alimento.espacio) {
						colaProduc.produccion.add(alimento);
						//ajustar el valor disponible para siguiente iteracion del ciclo
						disponible = (10-colaProduc.espacioOcupado());
					}
				}
			}
		}
		// 2. tiempoProduccion -=1 de productos en produccion
		for(Alimento alimento2 : colaProduc.produccion) {
			alimento2.tiempoProduccion-=1;
		}
		
		// 3. revisar si tiempoProduccion de algun producto ya llego a 0, y sacarlo
		for(Alimento alimento3 : colaProduc.produccion) {
			if(alimento3.tiempoProduccion==0) {
				colaProduc.produccion.remove(alimento3);
				alimento3.activo=false;
				//lo sacamos pero vuelve a aparecer, es porque cuando itera sobre clientes, vuelve a encontrarlo de primero y lo vuelve a meter a produccion
			}
		}
		
		// 4. revisar si algun pedido en colaClientes ya tiene todos los alimentos en inactivos,
		//ordenesCompletas += 1 , sumar precio productos y agregar a ganancias completas.
	}

	public static void main(String[] args) {
		
		Bebida b1 = new Bebida();
		b1.nombre = "Guanabana";
		b1.precio = 1000 ;
		b1.tiempoProduccion = 2;
		b1.tipo="Frio";
		b1.tamanno = 250;
		b1.espacio = 1;
		
		Bebida b2 = new Bebida();
		b2.nombre = "coca";
		b2.precio = 1000 ;
		b2.tiempoProduccion = 2;
		b2.tipo="Frio";
		b2.tamanno = 250;
		b2.espacio = 9;
		
		Bebida b3 = new Bebida();
		b3.nombre = "fresa_en_agua";
		b3.precio = 1000 ;
		b3.tiempoProduccion = 2;
		b3.tipo="Frio";
		b3.tamanno = 250;
		b3.espacio = 1;
		
		Pedido p1 = new Pedido();
		p1.items.add(b1);
		
		Pedido p2 = new Pedido();
		p2.items.add(b2);
		p2.items.add(b3);
		
		colaClientes.pedidosTotales.add(p1);
		colaClientes.pedidosTotales.add(p2);
		System.out.println(colaProduc.espacioOcupado());
		avanzar();
		System.out.println(colaProduc.espacioOcupado());
		System.out.println(colaProduc.produccion);
		System.out.println("\n //////////////////////////////// \n");
		avanzar();
		System.out.println(colaProduc.produccion);
		System.out.println("\n //////////////////////////////// \n");
		avanzar();
		System.out.println(colaProduc.produccion);
		
		
		//luego de crear instancias de JSON, se meten en array 
		// de ese array agarramos esos objetos para meterlos a instancias pedido.
		/*
		System.out.println("Digite la cantidad de clientes por crear: ");
		Scanner scan = new Scanner(System.in);
		int cantidad = scan.nextInt();
		*/
		
	}

}
