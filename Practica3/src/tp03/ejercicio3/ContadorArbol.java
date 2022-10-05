package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol;

	public ContadorArbol(ArbolBinario<Integer> ab) {
		setArbol(ab);
	}
	
	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosPares() {
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		numerosParesInOrden(arbol, lista);
		// numerosParesPostOrden(arbol, lista);
		return lista;
	}

	private void numerosParesInOrden(ArbolBinario<Integer> ab, ListaEnlazadaGenerica<Integer> lista) {
		if (!ab.esVacio()) {
			if (ab.tieneHijoIzquierdo())
				numerosParesInOrden(ab.getHijoIzquierdo(), lista);
			if (ab.getDato() % 2 == 0)
				lista.agregarFinal(ab.getDato());
			if (ab.tieneHijoDerecho())
				numerosParesInOrden(ab.getHijoDerecho(), lista);
		}
	}
	
	/* private void numerosParesPostOrden(ArbolBinario<Integer> ab, ListaEnlazadaGenerica<Integer> lista) {
		if (!ab.esVacio()) {
			if (ab.tieneHijoIzquierdo())
				numerosParesPostOrden(ab.getHijoIzquierdo(), lista);
			if (ab.tieneHijoDerecho())
				numerosParesPostOrden(ab.getHijoDerecho(), lista);
			if (ab.getDato() % 2 == 0)
				lista.agregarFinal(ab.getDato());
		}
	} */
}
