package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial1 {
	ListaGenerica<String> caminoConPresupuesto(Grafo<String> ciudades, String origen, String destino, int montoMaximo) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		int suma = 0;
		
		Vertice<String> vOrigen = buscar(ciudades, origen);
		
		if (vOrigen != null)
			caminoConPresupuesto(ciudades, destino, montoMaximo, camino, temporal, marca, vOrigen.getPosicion(), suma);
		
		return camino;
	}

	private void caminoConPresupuesto(Grafo<String> ciudades, String destino, int montoMaximo,
			ListaGenerica<String> camino, ListaGenerica<String> temporal, boolean[] marca, int i, int suma) {
		
		marca[i] = true;
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
		
		temporal.agregarFinal(v.dato());
		
		if (v.dato().equals(destino) && (suma < montoMaximo)) {
			clonar(camino, temporal);
		} else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if ((suma+=arista.peso()) < montoMaximo)
					if (!marca[j])
						caminoConPresupuesto(ciudades, destino, montoMaximo, camino, temporal, marca, j, suma+=arista.peso());
			}
			marca[i] = false;
			temporal.eliminarEn(temporal.tamanio());
		}
		
	}

	private void clonar(ListaGenerica<String> camino, ListaGenerica<String> temporal) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminarEn(camino.tamanio());
			camino.proximo();
		}
		
		temporal.comenzar();
		while(!temporal.fin()) {
			camino.agregarFinal(temporal.proximo());
		}
		
	}

	private Vertice<String> buscar(Grafo<String> ciudades, String lugar) {
		Vertice<String> v = null;
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()) {
			v = vertices.proximo();
			if (v.dato().equals(lugar))
				return v;
		}
		return v;
	}
}
