package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class TestContadorArbol {

	public static void main(String[] args) {
		/*
		 * 				40		-> Nivel 0
		 * 			   /	  \
		 * 			 25	   78	-> Nivel 1
		 * 			/  \
		 * 		  10	32		-> Nivel 2
		 */
		
		ArbolBinario<Integer> a40 = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> a25 = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> a10 = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> a32 = new ArbolBinario<Integer>(32);
		ArbolBinario<Integer> a78 = new ArbolBinario<Integer>(78);
		
		a40.agregarHijoIzquierdo(a25);
		a40.agregarHijoDerecho(a78);
		
		a25.agregarHijoIzquierdo(a10);
		a25.agregarHijoDerecho(a32);
		
		ContadorArbol contadorArbol = new ContadorArbol(a40);
		ListaEnlazadaGenerica<Integer> lista = contadorArbol.numerosPares();
		
		System.out.println("Lista de números pares: " + lista.toString());
	}

}
