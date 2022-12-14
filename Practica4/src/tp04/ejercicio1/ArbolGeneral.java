package tp04.ejercicio1;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		Altura altura = new Altura();
		if (!this.esVacio())
			altura(this, altura);
		return altura.getAlturaMaxima();
	}

	private void altura(ArbolGeneral<T> arbol, Altura altura) {
		altura.setAlturaActual(altura.getAlturaActual() + 1);
		if (altura.getAlturaActual() > altura.getAlturaMaxima())
			altura.setAlturaMaxima(altura.getAlturaActual());
		
		if (arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				altura(hijos.proximo(), altura);
				altura.setAlturaActual(altura.getAlturaActual() - 1);
			}
		}
		
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		int nivel = 0;
		boolean encontrado = false;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while(!cola.esVacia() && !encontrado) {
			ArbolGeneral<T> aux = cola.desencolar();
			if (aux != null) {
				if (aux.getDato().equals(dato)) {
					encontrado = true;
				} else {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel = nivel + 1;
				}
			}
		}
		
		if (encontrado)
			return nivel;
		else
			return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		int cant = 0;
		int cantMax = 0;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			ArbolGeneral<T> aux = cola.desencolar();
			if (aux != null) {
				cant = cant + 1;
				
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					if (cant > cantMax) {
						cantMax = cant;
						cant = 0;
					}
				}
			}
		}
		return cantMax;
	}
	
	public Boolean esAncestro(T a, T b) {
		ListaGenerica<T> camino = new ListaEnlazadaGenerica<T>();
		ListaGenerica<T> caminoActual = new ListaEnlazadaGenerica<T>();
		esAncestro(camino, caminoActual, a, b, this);
		if (camino.incluye(a) && camino.incluye(b)) {
			return true;
		} else {
			return false;
		}
	}

	private void esAncestro(ListaGenerica<T> camino, ListaGenerica<T> caminoActual, T a, T b,
			ArbolGeneral<T> arbol) {
		
		caminoActual.agregarFinal(arbol.getDato());
		
		if (arbol.getDato().equals(b)) {
			clonarCaminos(camino, caminoActual);
		}
		
		if (arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				esAncestro(camino, caminoActual, a, b, hijos.proximo());
				caminoActual.eliminarEn(caminoActual.tamanio());
			}
		}
		
	}

	private void clonarCaminos(ListaGenerica<T> camino, ListaGenerica<T> caminoActual) {
		caminoActual.comenzar();
		while(!caminoActual.fin()) {
			camino.agregarFinal(caminoActual.proximo());
		}
		
	}

	

}