package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class PilaGenerica<T> extends ListaEnlazadaGenerica<T> {
	private ListaEnlazadaGenerica<T> pila;

	public PilaGenerica() {
		pila = new ListaEnlazadaGenerica<T>();
	}

	public void apilar(T elem) {
		pila.agregarInicio(elem);
	}

	public T desapilar() {
		T elem = this.tope();
		pila.eliminarEn(1);
		return elem;
	}

	public T tope() {
		return pila.elemento(1);
	}

	public boolean esVacia() {
		return pila.esVacia();
	}
}
