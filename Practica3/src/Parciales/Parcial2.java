package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial2 {
	public ListaGenerica<Integer> resolver (ArbolBinario<Integer> ab, int min) {
		ListaGenerica<Integer> caminoActual = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<Integer>();
		
		if (!ab.esVacio()) {
			resolver(ab, min, caminoActual, resultado);
		}
		
		return resultado;
	}

	/*private boolean resolver(ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> caminoActual,
			ListaGenerica<Integer> resultado) {
		boolean encontrado = false;
		caminoActual.agregarFinal(ab.getDato());
		
		if ((!ab.esHoja())) {
			if (ab.tieneHijoIzquierdo() && (!encontrado))
				encontrado = resolver(ab.getHijoIzquierdo(), min, caminoActual, resultado);
			if (ab.tieneHijoDerecho() && (!encontrado))
				encontrado = resolver(ab.getHijoDerecho(), min, caminoActual, resultado);
			caminoActual.eliminarEn(caminoActual.tamanio());
		} else {
			if (ab.esHoja()) {
				if (caminoActual.tamanio() >= min) {
					clonar(caminoActual, resultado);
					return true;
				}
			}
		}
		return encontrado;
	} */
	
	private boolean resolver(ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> caminoActual,
			ListaGenerica<Integer> resultado) {
		boolean encontrado = false;
		caminoActual.agregarFinal(ab.getDato());
		
		if (ab.esHoja() && (!encontrado)) {
			if (caminoActual.tamanio() > min) {
				clonar(caminoActual, resultado);
				return true;
			}
		} else {
			if (ab.tieneHijoIzquierdo() && (!encontrado))
				encontrado = resolver(ab.getHijoIzquierdo(), min, caminoActual, resultado);
			
			if (ab.tieneHijoDerecho() && (!encontrado))
				encontrado = resolver(ab.getHijoDerecho(), min, caminoActual, resultado);
				
			caminoActual.eliminarEn(caminoActual.tamanio());
		}
		return encontrado;
	}

	private void clonar(ListaGenerica<Integer> caminoActual, ListaGenerica<Integer> resultado) {
		caminoActual.comenzar();
		while(!caminoActual.fin()) {
			resultado.agregarFinal(caminoActual.proximo());
		}
		
	}
}
