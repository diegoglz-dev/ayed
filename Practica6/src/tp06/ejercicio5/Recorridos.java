package tp06.ejercicio5;

import tp02.ejercicio2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos<T> {
	
	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> lista = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		for (int i = 1; i < grafo.listaDeVertices().tamanio(); i++)
			if (!marca[i]) // Si no está marcado
				this.dfs(i, grafo, marca, lista);
				
		return lista;
	}

	private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lista.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!marca[j])
				dfs(j, grafo, marca, lista);
		}
	}
	
	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> lista = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		for (int i = 1; i < grafo.listaDeVertices().tamanio(); i++)
			if (!marca[i])
				this.bfs(i, grafo, marca, lista);
		return lista;
	}

	private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista) {
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		cola.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while(!cola.esVacia()) {
			Vertice<T> v = cola.desencolar();
			lista.agregarFinal(v);
			ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					cola.encolar(w);
				}
			}
		}
	}
}
