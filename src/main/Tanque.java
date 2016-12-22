package main;

public class Tanque {
	private int capacidad;
	private int actual;
	private TanqueApp main;
	
	public Tanque (int valor, int inicial, TanqueApp main) {
		this.main = main;
		this.capacidad = valor;
		this.actual = inicial;		
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		if (actual >= capacidad)
			this.actual = capacidad;
		else if (actual <= 0)
			this.actual = 0;
		else this.actual = actual;
		main.refresh(this.actual);
	}
}