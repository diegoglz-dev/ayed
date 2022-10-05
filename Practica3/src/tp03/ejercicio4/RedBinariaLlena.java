package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	
	ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol) {
		setArbol(arbol);
	}
	
	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	/*
	 * Forma recursiva pero calculando con un objeto
	 */
	public int retardoReenvio() {
		Retardo retardo = new Retardo();
		retardoReenvio(arbol, retardo);
		return retardo.getMayor();
	}

	private void retardoReenvio(ArbolBinario<Integer> arbol, Retardo retardo) {
		if (!arbol.esVacio()) {
			retardo.setActual(retardo.getActual() + arbol.getDato());
			
			if (arbol.esHoja())
				if (retardo.getActual() > retardo.getMayor())
					retardo.setMayor(retardo.getActual());
			
			if (arbol.tieneHijoIzquierdo())
				retardoReenvio(arbol.getHijoIzquierdo(), retardo);
			if (arbol.tieneHijoDerecho())
				retardoReenvio(arbol.getHijoDerecho(), retardo);
			
			retardo.setActual(retardo.getActual() - arbol.getDato());
		}
	}
	
	/*
	 * Forma recursiva calculando en cada recursión
	 */
	/* public int retardoReenvio () {
		return retardoReenvio(arbol);
	}
	
	private int retardoReenvio (ArbolBinario<Integer> arbol) {
		if (arbol.esVacio())
			return - 1;
		
		int cant = -1;
		
		if (arbol.esHoja())
			return arbol.getDato();
		
		else {
			if (arbol.tieneHijoIzquierdo()) 
				cant = Math.max(cant,retardoReenvio(arbol.getHijoIzquierdo()));
			if (arbol.tieneHijoDerecho())
				cant = Math.max (cant,retardoReenvio(arbol.getHijoDerecho()));
		}
		return cant + arbol.getDato();
	} */
}
