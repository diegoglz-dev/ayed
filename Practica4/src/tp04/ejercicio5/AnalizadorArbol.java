package tp04.ejercicio5;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	
	public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		int sumaNivel = 0;
		int cantNodos = 0;
		int promNivel = 0;
		int maxProm = 0;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		
		cola.encolar(arbol);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			ArbolGeneral<AreaEmpresa> aux = cola.desencolar();
			
			if (aux != null) {
				sumaNivel = sumaNivel + aux.getDato().getTardanza();
				cantNodos = cantNodos + 1;
				
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
				promNivel = sumaNivel / cantNodos;
				
				if (promNivel > maxProm) {
					maxProm = promNivel;
				}
				
				cantNodos = 0;
				promNivel = 0;
				sumaNivel = 0;
			}

		}
		
		return maxProm;
	}
}
