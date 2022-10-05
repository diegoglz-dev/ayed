package tp03.ejercicio5;

import tp02.ejercicio2.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	ArbolBinario<Integer> arbol;
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		setArbol(arbol);
	}

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		int nivel = 0;
		int suma = 0;
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		while((!cola.esVacia()) && (p >= nivel)) {
			ArbolBinario<Integer> ab = cola.desencolar();
			
			if (ab != null) {
				if (p >= nivel)
					suma = suma + ab.getDato();
				
				if (ab.tieneHijoIzquierdo())
					cola.encolar(ab.getHijoIzquierdo());
				if (ab.tieneHijoDerecho())
					cola.encolar(ab.getHijoDerecho());
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel = nivel + 1;
				}
			}
		}
		
		return suma;
	}
}
