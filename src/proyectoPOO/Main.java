package proyectoPOO;
import java.util.Scanner;// para inputs
import java.util.Iterator;
import java.util.Random;

public class Main {
	
	// global //
	
	
	static Cola colaClientes = new Cola();
	static ColaProduccion colaProduc = new ColaProduccion();
	static Combo combos = new Combo();
	//static Menu ListaMenu = new Menu();//ListaMenu.items contiene arrayList con todos los alimentos del restaurante
	
	static int ordenesCompletadas =0;
	static int ganancias = 0;
	static int clientesImpacientes = 0;
	
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
		Menu menuCliente = new Menu();//ListaMenu.items contiene arrayList con todos los alimentos del restaurante
		JSONReader fileJSON = new JSONReader(menuCliente); // cada cliente tendrá su propio menu, para no repetir objetos en memoria entre clientes
		
		boolean[] opciones = {true,false};
		Random r = new Random();
		int ran = r.nextInt(2);//una opcion aleatoria entre 0 y 1 para el indice de opciones
		pedido.impaciente = opciones[ran];
		
		Random r1 = new Random();
		int aleatorio = r1.nextInt(5);//cuantos productos como maximo? puse 5 (cuenta aun cuando llega a 0)
		
		while(aleatorio>=0) {
			Random r2 = new Random();
			int r3 = r2.nextInt(12);//cualquier objeto <Alimento> dentro de ListaMenu estara en este indice
			pedido.items.add(menuCliente.items.get(r3));
			//System.out.println(r3);
			aleatorio--;
		}
		System.out.println(pedido.items);
		System.out.println("impaciente: "+pedido.impaciente);
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
		
		//4. reducir contadores de impaciencia y sacar pedido de colaClientes si llegó a 0 (sin sumar ganancias)
		
		Iterator<Pedido>it = colaClientes.pedidosTotales.iterator();
		while(it.hasNext()) {
			Pedido pedido3 = (Pedido)it.next();
			if(pedido3.impaciente&&pedido3.contadorPaciencia==0) {
				for(Alimento alimento4 : pedido3.items) {
					alimento4.impaciencia=true;
				}
				it.remove();
				System.out.println("Cliente impaciente se ha cansado de esperar...");
				clientesImpacientes+=1;
			}
			if(pedido3.impaciente) {
				pedido3.contadorPaciencia--;
				//System.out.println(pedido3.contadorPaciencia);
			}	
	}	
		//Sacar alimentos de colaProduc si el pedidoImpaciente asociado ya se fue de la cola
		Iterator<Alimento> it2 = colaProduc.produccion.iterator(); 
		while(it2.hasNext()) {
			Alimento alimento5 = (Alimento)it2.next();
			if(alimento5.impaciencia==true) {
				it2.remove();
			}
		}
		
		
		// 5. revisar si algun pedido en colaClientes ya tiene todos los alimentos en inactivos,
		//ordenesCompletas += 1 , sumar precio productos y agregar a ganancias completas.
		Iterator<Pedido>it1 = colaClientes.pedidosTotales.iterator();
		while(it1.hasNext()) {
			Pedido pedido4 = (Pedido)it1.next();
			if(todosInactivos(pedido4)==true) {
				
				ganancias += combos.comparar(pedido4); // Las ganancias son calculadas dentro de la clase Combo
				
				it1.remove();
				ordenesCompletadas+=1;
			}
		}
		int sizePedidos = colaClientes.pedidosTotales.size();
		int sizeProduccion = colaProduc.produccion.size();
		if(sizePedidos == 0 && sizeProduccion ==0) {
			
			//Ventana.pantallaFinal(ordenesCompletadas,ganancias);
			System.out.println("\n ------ Cola produccion terminada -------- \n");
			System.out.println("\n Alimentos en produccion:");
			System.out.println(colaProduc.produccion);
			System.out.println("\nEspacio ocupado: "+colaProduc.espacioOcupado());
			System.out.println("\nOrdenes completadas: "+ordenesCompletadas);
			System.out.println("\n Ganancias totales: "+ganancias);
			System.out.println("\n ----  Adios! -------- \n");
			
			
			//popUp pantallaFinal = new popUp(ordenesCompletadas,ganancias);
			//System.exit(0);
			
			
			
		}
	}//fin de avanzar()

	
	public static void info() {
		System.out.println("\n ---------------------- \n");
		System.out.println("\nOrdenes totales:");
		System.out.println(colaClientes.pedidosTotales);
		System.out.println("\n Alimentos en produccion:");
		System.out.println(colaProduc.produccion);
		System.out.println("\nEspacio ocupado: "+colaProduc.espacioOcupado());
		System.out.println("\nOrdenes completadas: "+ordenesCompletadas);
		System.out.println("\n Ganancias: "+ganancias);
	}
	
	public static void main(String[] args) {
		//luego de crear instancias de JSON, se meten en array (ListaMenu)
		// de ese array agarramos esos objetos <Alimento> para meterlos a instancias Pedido.
		
		//JSONReader fileJSON = new JSONReader(ListaMenu);
		
		System.out.println("Digite la cantidad de clientes por crear: ");
		Scanner scan = new Scanner(System.in);
		int cantidad = scan.nextInt();
		
		Menu menuCombos = new Menu();
		JSONReader lector = new JSONReader(menuCombos);
		combos.llenar(menuCombos);
		
		while (cantidad>0) {
			crearPedido();
			cantidad--;
		}
		
		Ventana v1 = new Ventana(colaClientes,colaProduc,ordenesCompletadas,ganancias,clientesImpacientes);
		//System.out.println(ListaMenu.items);
	}
}