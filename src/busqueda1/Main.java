package busqueda1;

public class Main {
	
	public static void main(String args []) {
		
		final int LIM_INFERIOR = 0;
		final int LIM_SUPERIOR = 10;
		final int MAGNITUD = 1;
		
		int inicio = 2;
		int objetivo = 5;
		
		BusquedaAnchura bfs = new BusquedaAnchura(inicio, objetivo, LIM_INFERIOR, LIM_SUPERIOR, MAGNITUD);
		
		System.out.println("Positición inicio: " + inicio);
		System.out.println("Positición objetivo: " + objetivo);
		
		bfs.busqueda();
		
		bfs.imprimirHistorialEstados();
		
	}

}

