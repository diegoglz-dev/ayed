package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class CiudadesCovid {
	ListaGenerica<Ciudad> resolver (Grafo<Ciudad> ciudades, String origen, String destino) {
		ListaGenerica<Ciudad> camino = new ListaEnlazadaGenerica<Ciudad>();
		ListaGenerica<Ciudad> temporal = new ListaEnlazadaGenerica<Ciudad>();
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		Vertice<Ciudad> vOrigen = buscar(ciudades, origen);
		if ((vOrigen != null) && (vOrigen.dato().getFase() != 1)) {
			resolver(ciudades, destino, camino, temporal, marca, vOrigen.getPosicion());
		}
		return camino;
	}

	private void resolver(Grafo<Ciudad> ciudades, String destino, ListaGenerica<Ciudad> camino,
			ListaGenerica<Ciudad> temporal, boolean[] marca, int i) {
		
		marca[i] = true;
		Vertice<Ciudad> v = ciudades.listaDeVertices().elemento(i);
		
		temporal.agregarFinal(v.dato());
		if (v.dato().getNombre().equals(destino))
			clonar(camino, temporal);
		else {
			ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<Ciudad> arista = ady.proximo();
				if (arista.verticeDestino().dato().getFase() != 1) {
					int j = arista.verticeDestino().getPosicion();
					if (!marca[j]) {
						resolver(ciudades, destino, camino, temporal, marca, j);
					}
				}
			}
			temporal.eliminarEn(temporal.tamanio());
		}
		
	}

	private void clonar(ListaGenerica<Ciudad> camino, ListaGenerica<Ciudad> temporal) {
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

	private Vertice<Ciudad> buscar(Grafo<Ciudad> ciudades, String origen) {
		Vertice<Ciudad> v = null;
		ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()) {
			v = vertices.proximo();
			if (v.dato().getNombre().equals(origen)) {
				return v;
			}
		}
		return null;
	}
}
