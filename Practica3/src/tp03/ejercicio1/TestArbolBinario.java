package tp03.ejercicio1;

public class TestArbolBinario {
	
	public static void preOrden(ArbolBinario<Integer> arbolBinario) {
		if (!arbolBinario.esVacio()) {
			System.out.println(arbolBinario.getDato());
			if (arbolBinario.tieneHijoIzquierdo())
				preOrden(arbolBinario.getHijoIzquierdo());
			if (arbolBinario.tieneHijoDerecho())
				preOrden(arbolBinario.getHijoDerecho());
		}
	}

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
		
		System.out.println("La cantidad de hojas que tiene el árbol es: " + a40.contarHojas());

		System.out.println();
		System.out.println("Arbol original:");
		a40.recPre();
		System.out.println();
		System.out.println("Arbol espejo:");
		ArbolBinario<Integer> arbolEspejo40 = a40.espejo();
		preOrden(arbolEspejo40);
		System.out.println();
		System.out.println("Entre niveles:");
		a40.entreNiveles(0, 1);
	}

}
