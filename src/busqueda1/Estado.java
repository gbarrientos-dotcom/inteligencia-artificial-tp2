package busqueda1;

public class Estado {
	
	// posición actual
	private int posicion;
	
	// movimiento que hizo llegar a la posición actual
	private String movimiento;
	
	// estado anterior
	private Estado predecesor;
		
	// constructor
	public Estado(int posicion, String movimiento, Estado predecesor) {
		this.posicion=posicion;
		this.predecesor=predecesor;
		this.movimiento=movimiento;
	}
	
	// métodos getters y setters
	
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	public Estado getPredecesor() {
		return predecesor;
	}

	public void setPredecesor(Estado predecesor) {
		this.predecesor = predecesor;
	}

	// método para mover hacia la izquierda
	public Estado moverIzquierda(int lim_inferior, int cm) {
		Estado izquierda = null;
		int posicionMovimiento = this.posicion;
		if((posicionMovimiento - cm) >= lim_inferior) {
			int posicionResultado = posicionMovimiento - cm;
			izquierda = new Estado(posicionResultado,"MOVER_IZQUIERDA_"+cm, this);
		}
		return izquierda;
	}

	// método para mover hacia la derecha
	public Estado moverDerecha(int lim_superior, int cm) {
		Estado derecha = null;
		int posicionMovimiento = this.posicion;
		if( posicionMovimiento + cm <= lim_superior ) {
			int posicionResultado = posicionMovimiento + cm;
			derecha=new Estado(posicionResultado,"MOVER_DERECHA_"+cm, this);
		}
		return derecha;
	}

	@Override
	public String toString() {
		return "Estado [posicion=" + posicion + ", movimiento=" + movimiento + ", predecesor=" + predecesor + "]";
	}

}
