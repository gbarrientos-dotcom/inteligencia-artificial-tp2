package busqueda1;

import java.util.ArrayList;
import java.util.HashMap;


public class BusquedaAnchura {
	
	int lim_inf;
	int lim_sup;
	int cm;
	
	// lista de estados abiertos donde se almacenan los estados no expandidos
	public ArrayList<Estado> listaEstados;
	
	// lista de estados cerrados donde se almacenan los estados ya expandidos
	public HashMap<Integer,Estado> historialEstados;
	
	// estado inicial
	public Estado inicio;
	
	// estado objetivo
	public Estado objetivo;
	
	// estado actual
	public Estado actual;
		
	// flag que indica si se alcanzó el estado objetivo
	public boolean encontrada;

	// constructor
	public BusquedaAnchura(int origen, int destino, int inf, int sup, int mag) {
		listaEstados = new ArrayList<>();
		historialEstados = new HashMap<>();
		encontrada = false;
		inicio = new Estado(origen, "INICIO", null);
		objetivo = new Estado(destino, "OBJETIVO", null);
		lim_inf = inf;
		lim_sup = sup;
		cm = mag;
	}

	// método que realiza la búsqueda
	public void busqueda() {	
		//introduce el estado inicial en la lista de estados abiertos
		listaEstados.add(inicio);
		//mientras existen estados abiertos y encontrada no es verdadero
		while (!listaEstados.isEmpty() && !encontrada){
			actual = listaEstados.get(0); // tomar el primero en la lista de estados abiertos
			listaEstados.remove(0); // eliminar el primero en la lista de estados abiertos
			if (actual.getPosicion() == objetivo.getPosicion()) {
				objetivo.setMovimiento(actual.getMovimiento());
				objetivo.setPredecesor(actual.getPredecesor());
				construirSolucion();
				encontrada=true;
			} else {
			//si no es el estado objetivo expandir el nodo
			expandirEstado(actual);
			historialEstados.put(actual.hashCode(), actual);
			}
		}
	}

	private void expandirEstado(Estado e) {
		desplazarIzquierda(e);
		desplazarDerecha(e);
	}
	
	private void desplazarIzquierda(Estado e) {
		Estado izquierda = e.moverIzquierda(lim_inf, cm);
		if (izquierda !=null) {
			insertarEstado(izquierda);
		}
	}

	private void desplazarDerecha(Estado e) {
		Estado derecha = e.moverDerecha(lim_sup, cm);
		if (derecha !=null) {
			insertarEstado(derecha);
		}
	}

	
	private void insertarEstado(Estado nuevo){
		// comprobar si el estado no está en el historial de estados cerrados
		if (!historialEstados.containsValue(nuevo)) {
			historialEstados.put(nuevo.hashCode(), nuevo);
			listaEstados.add(nuevo);
		}
	}


	private void construirSolucion() {
		ArrayList<Estado> solucion = new ArrayList<>();
		solucion.add(objetivo);
		Estado predecesor = objetivo.getPredecesor();
		while (predecesor != null){
			solucion.add(predecesor);
			predecesor=predecesor.getPredecesor();
		}
		System.out.println("\nSolucion con búsqueda en anchura: " + "\n");
		for (int i = solucion.size()-1 ; i >= 0 ; i--) {
			System.out.print("Paso " + solucion.get(i).getMovimiento() + ": ");
			System.out.println(solucion.get(i).toString());
		}
	}
	
	// método para imprimir el historial de estados expandidos
	public void imprimirHistorialEstados() {
		System.out.println("\nHistorial de Estados:" + "\n");
		for (Integer key : historialEstados.keySet()) {
		     System.out.println(key + " = " + historialEstados.get(key));
		}
	}
	
}
