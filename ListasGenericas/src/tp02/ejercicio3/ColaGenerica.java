package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class ColaGenerica<T> extends ListaEnlazadaGenerica<T> {
	private ListaEnlazadaGenerica<T> cola;
	
	public ColaGenerica() {
		cola = new ListaEnlazadaGenerica<T>();
	}
	
	public void encolar(T elem) {
		cola.agregarFinal(elem);
	}
	
	public T desencolar() {
		T elem = this.tope();
		cola.eliminarEn(1);
		return elem;
	}
	
	public T tope() {
		return cola.elemento(1);
	}
	
	public boolean esVacia() {
		return cola.esVacia();
	}
}
