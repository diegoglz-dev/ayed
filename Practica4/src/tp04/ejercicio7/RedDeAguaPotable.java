package tp04.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable<T> {
	private ArbolGeneral<T> arbol;
	
	public RedDeAguaPotable(ArbolGeneral<T> arbol) {
		setArbol(arbol);
	}
	
	public ArbolGeneral<T> getArbol() {
		return arbol;
	}
	
	public void setArbol(ArbolGeneral<T> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		return minimoCaudal(caudal, this.getArbol());
	}

	private double minimoCaudal(double caudal, ArbolGeneral<T> ag) {
		double min = 9999.99;
		if (ag.esHoja()) {
			System.out.println("Nodo (" + ag.getDato() + ") su caudal es: " + caudal);
			return caudal;
		}
		if (ag.tieneHijos()) {
			System.out.println("Nodo (" + ag.getDato() + ") su caudal es: " + caudal);
			ListaGenerica<ArbolGeneral<T>> hijos = ag.getHijos();
			caudal = caudal / (double) hijos.tamanio();
			hijos.comenzar();
			while(!hijos.fin()) {
				min = Math.min(min, this.minimoCaudal(caudal, hijos.proximo()));
			}
		}
		return min;
	}
}
