package tp04.ejercicio3;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {
	/*
	 * Recorrido Pre Orden
	 */
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if (!a.esVacio())
			numerosImparesMayoresQuePreOrden(a, n, lista);
		return lista;
	}

	private void numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
		if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
			lista.agregarFinal(a.getDato());
		}
		
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				numerosImparesMayoresQuePreOrden(hijos.proximo(), n, lista);
			}
		}
	}
	
	/*
	 * Recorrido In Orden
	 */
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if (!a.esVacio())
			numerosImparesMayoresQueInOrden(a, n, lista);
		return lista;
	}
	
	private void numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		if (!hijos.esVacia()) {
			hijos.comenzar();
			numerosImparesMayoresQueInOrden(hijos.proximo(), n, lista);
		}
		if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
			lista.agregarFinal(a.getDato());
		}
		
		while(!hijos.fin()) {
			numerosImparesMayoresQueInOrden(hijos.proximo(), n, lista);
		}
		
	}

	/*
	 * Recorrido Post Orden
	 */
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if (!a.esVacio())
			numerosImparesMayoresQuePostOrden(a, n, lista);
		return lista;
	}

	private void numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				numerosImparesMayoresQuePostOrden(hijos.proximo(), n, lista);
			}
		}
		
		if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
			lista.agregarFinal(a.getDato());
		}
	}
	
	/*
	 * Recorrido por niveles
	 */
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		
		cola.encolar(a);
		
		while(!cola.esVacia()) {
			ArbolGeneral<Integer> aux = cola.desencolar();
			
			if ((aux.getDato() % 2 != 0) && (aux.getDato() > n))
				lista.agregarFinal(aux.getDato());
			
			if (aux.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = aux.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		
		return lista;
		
	}
}
