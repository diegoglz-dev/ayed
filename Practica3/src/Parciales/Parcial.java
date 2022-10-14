package Parciales;

import tp03.ejercicio1.ArbolBinario;

public class Parcial {
	// Solución 1 (Mia)
	/*
	public Integer resolver(ArbolBinario<Integer> ab) {
		Resultado resultado = new Resultado();
		if (!ab.esVacio())
			resolver(ab, resultado);
		return resultado.getResultado();
	}

	private void resolver(ArbolBinario<Integer> ab, Resultado resultado) {
		
		if (ab.tieneHijoIzquierdo()) {
			resolver(ab.getHijoIzquierdo(), resultado);
		}
		
		if (ab.tieneHijoDerecho()) {
			resolver(ab.getHijoDerecho(), resultado);
		}
		
		if (!ab.esHoja()) {
			if (ab.getDato() % 2 == 0) {
				resultado.setResultado(resultado.getResultado() + ab.getDato());
			}
		} else {
			if (ab.getDato() % 2 != 0) {
				resultado.setResultado(resultado.getResultado() - ab.getDato());
			}
		}
	} */
	
	// Solución 2
	public Integer resolver(ArbolBinario<Integer> ab) {
		Integer resultado = 0;
		if (!ab.esVacio()) {
			if (ab.tieneHijoIzquierdo()) {
				resultado += resolver(ab.getHijoIzquierdo());
			}
			
			if (ab.tieneHijoDerecho()) {
				resultado += resolver(ab.getHijoDerecho());
			}
			
			if (ab.esHoja()) {
				if (ab.getDato() % 2 == 1)
					resultado -= ab.getDato();
			} else {
				if (ab.getDato() % 2 == 0)
					resultado += ab.getDato();
			}
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
		/*
		 * 				40		-> Nivel 0
		 * 			   /	  \
		 * 			 25	   78	-> Nivel 1
		 * 			/  \
		 * 		  3		32		-> Nivel 2
		 */
		
		ArbolBinario<Integer> a40 = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> a25 = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> a3 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> a32 = new ArbolBinario<Integer>(32);
		ArbolBinario<Integer> a78 = new ArbolBinario<Integer>(78);
		
		a40.agregarHijoIzquierdo(a25);
		a40.agregarHijoDerecho(a78);
		
		a25.agregarHijoIzquierdo(a3);
		a25.agregarHijoDerecho(a32);
		
		Parcial parcial = new Parcial();
		
		System.out.println(parcial.resolver(a40));
	}
}
