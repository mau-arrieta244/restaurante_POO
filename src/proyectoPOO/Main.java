package proyectoPOO;
import java.util.Scanner;// para inputs
import java.util.Iterator;
import java.util.Random;

public class Main {
	
	// global //
	
	static Cola colaClientes = new Cola();
	static ColaProduccion colaProduc = new ColaProduccion();
	static Menu ListaMenu = new Menu();//ListaMenu.items contiene arrayList con todos los alimentos del restaurante
	
	static int ordenesCompletadas =0;
	
	public static boolean todosInactivos(Pedido pedido) {//revisa si algun pedido de la cola total tiene todo en inactivo
		boolean condicion = true;
		for(Alimento alimento4 : pedido.items) {
			if (alimento4.activo == true) {
				condicion = false;
			}
		}
	return condicion;
	}
	
	public static void crearPedido() {
		Pedido pedido = new Pedido();
		Random r1 = new Random();
		int aleatorio = r1.nextInt(5);//cuantos productos como maximo? puse 5 (cuenta aun cuando llega a 0)
		
		while(aleatorio>=0) {
			Random r2 = new Random();
			int r3 = r2.nextInt(12);//cualquier objeto <Alimento> dentro de ListaMenu estara en este indice
			pedido.items.add(ListaMenu.items.get(r3));
			//System.out.println(r3);
			aleatorio--;
		}
		System.out.println(pedido.items);
		colaClientes.pedidosTotales.add(pedido);
	}
	
	public static void avanzar() {
		// 1. Ir metiendo productos de cola hasta que no haya espacio
		int disponible = (10-colaProduc.espacioOcupado());
		for(Pedido pedido : colaClientes.pedidosTotales) {
			for(Alimento alimento : pedido.items) {
				if(alimento.usado==false) {
					if(disponible >= alimento.espacio) {
						colaProduc.produccion.add(alimento);
						alimento.usado=true;//ya fue usado,  no se volvera a agregar.
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
		Iterator<Alimento> itr = colaProduc.produccion.iterator(); 
		while(itr.hasNext()) {
			Alimento alimento3 = (Alimento)itr.next();
			//System.out.println(alimento3);
			if(alimento3.tiempoProduccion==0) {
				alimento3.activo=false;
				itr.remove();
			}
		}
		
		
		// 4. revisar si algun pedido en colaClientes ya tiene todos los alimentos en inactivos,
		//ordenesCompletas += 1 , sumar precio productos y agregar a ganancias completas.
		Iterator<Pedido>it1 = colaClientes.pedidosTotales.iterator();
		while(it1.hasNext()) {
			Pedido pedido4 = (Pedido)it1.next();
			if(todosInactivos(pedido4)==true) {
				it1.remove();
				ordenesCompletadas+=1;
			}
		}
		int sizePedidos = colaClientes.pedidosTotales.size();
		int sizeProduccion = colaProduc.produccion.size();
		if(sizePedidos == 0 && sizeProduccion ==0) {
			System.out.println("adios!");
			System.exit(0);
		}
	}//fin de avanzar()

	public static void main(String[] args) {
		//luego de crear instancias de JSON, se meten en array (ListaMenu)
		// de ese array agarramos esos objetos <Alimento> para meterlos a instancias Pedido.
		
		JSONReader fileJSON = new JSONReader(ListaMenu);
		//System.out.println(ListaMenu.items);
		
		System.out.println("Digite la cantidad de clientes por crear: ");
		Scanner scan = new Scanner(System.in);
		int cantidad = scan.nextInt();
		
		while (cantidad>0) {
			crearPedido();
			cantidad--;
		}
		
	}

}