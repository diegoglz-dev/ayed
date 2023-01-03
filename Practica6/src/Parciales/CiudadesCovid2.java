package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class CiudadesCovid2 {
	ListaGenerica<String> resolver (Grafo<String> ciudades, String origen, String destino, ListaGenerica<String> pasandoPor) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> temporal = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		Vertice<String> vOrigen = buscar(ciudades, origen);
		if (vOrigen != null) {
			resolver(ciudades, destino, pasandoPor, camino, temporal, marca, vOrigen.getPosicion());
		}
		return camino;
	}

	private boolean resolver(Grafo<String> ciudades, String destino, ListaGenerica<String> pasandoPor,
			ListaGenerica<String> camino, ListaGenerica<String> temporal, boolean[] marca, int i) {
		marca[i] = true;
		boolean encontre = false;
		Vertice<String> v = ciudades.listaDeVertices().elemento(i);
		temporal.agregarFinal(v.dato());
		if (v.dato().equals(destino)) {
			pasandoPor.comenzar();
			while(!pasandoPor.fin() && !encontre) {
				encontre = temporal.incluye(pasandoPor.proximo());
			}
			clonar(camino, temporal);
		} else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !encontre) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					encontre = resolver(ciudades, destino, pasandoPor, camino, temporal, marca, j);
				}
			}
			if (!encontre) {
				marca[i] = false;
				temporal.eliminarEn(temporal.tamanio());
			}
		}
		
		return encontre;
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
		return null;
	}
}
