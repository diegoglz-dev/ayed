package Parciales;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos {
	/*
	 * Retorna una lista de nombres de ciudades partiendo de origen a un destiono
	 */
	public ListaGenerica<String> buscarCamino(Grafo<String> ciudades, String origen, String destino) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		
		Vertice<String> v = buscar(ciudades, origen);
		
		if (v != null)
			buscarCamino(ciudades, destino, camino, caminoActual, marca, v.getPosicion());
		return camino;
	}

	private boolean buscarCamino(Grafo<String> ciudades, String destino, ListaGenerica<String> camino, ListaGenerica<String> caminoActual, boolean[] marca, int i) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<String> vertice = ciudades.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(vertice.dato());
		if (vertice.dato().equals(destino)) {
			clonar(camino, caminoActual);
			return true;
		} else {
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vertice);
			ady.comenzar();
			while(!ady.fin() && !encontre) {
				/* Arista<String> arista = ady.proximo();
				Vertice<String> vDestino = arista.verticeDestino();
				int j = vDestino.getPosicion(); */
				int j = ady.proximo().verticeDestino().getPosicion();
				if (!marca[j]) {
					encontre = buscarCamino(ciudades, destino, camino, caminoActual, marca, j);
				}
			}
			caminoActual.eliminarEn(caminoActual.tamanio());
		}
		return encontre;
	}

	private void clonar(ListaGenerica<String> camino, ListaGenerica<String> caminoActual) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminarEn(camino.tamanio());
			camino.proximo();
		}
		
		caminoActual.comenzar();
		while(!caminoActual.fin()) {
			camino.agregarFinal(caminoActual.proximo());
		}
	}

	private Vertice<String> buscar(Grafo<String> ciudades, String lugar) {
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
		vertices.comenzar();
		Vertice<String> v = null;
		while(!vertices.fin()) {
			v = vertices.proximo();
			if (v.dato().equals(lugar))
				return v;
		}
		return null;
	}
}
