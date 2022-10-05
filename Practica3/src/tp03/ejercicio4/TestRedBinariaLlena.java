package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class TestRedBinariaLlena {
	
	/*
	 * 				          10
	 * 			         /         \
	 * 			       40           33
	 * 			    /      \	       /   \
	 * 		       14       7      8    11
	 * 		      /  \    /  \   /  \  /  \
	 * 			 20  32  12  22  3  100  18  77
	 * 
	 */

	public static void main(String[] args) {
		ArbolBinario<Integer> a10 = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> a40 = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> a33 = new ArbolBinario<Integer>(33);
		ArbolBinario<Integer> a14 = new ArbolBinario<Integer>(14);
		ArbolBinario<Integer> a7 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> a8 = new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> a11 = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> a20 = new ArbolBinario<Integer>(20);
		ArbolBinario<Integer> a32 = new ArbolBinario<Integer>(32);
		ArbolBinario<Integer> a12 = new ArbolBinario<Integer>(12);
		ArbolBinario<Integer> a22 = new ArbolBinario<Integer>(22);
		ArbolBinario<Integer> a3 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> a2 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> a18 = new ArbolBinario<Integer>(18);
		ArbolBinario<Integer> a77 = new ArbolBinario<Integer>(77);
		
		a10.agregarHijoIzquierdo(a40);
		a10.agregarHijoDerecho(a33);
		
		a40.agregarHijoIzquierdo(a14);
		a40.agregarHijoDerecho(a7);
		
		a14.agregarHijoIzquierdo(a20);
		a14.agregarHijoDerecho(a32);
		
		a7.agregarHijoIzquierdo(a12);
		a7.agregarHijoDerecho(a22);
		
		a33.agregarHijoIzquierdo(a8);
		a33.agregarHijoDerecho(a11);
		
		a8.agregarHijoIzquierdo(a3);
		a8.agregarHijoDerecho(a2);
		
		a11.agregarHijoIzquierdo(a18);
		a11.agregarHijoDerecho(a77);
		
		RedBinariaLlena red = new RedBinariaLlena(a10);
		System.out.println("El retardo de envío es: " + red.retardoReenvio());
	}

}
