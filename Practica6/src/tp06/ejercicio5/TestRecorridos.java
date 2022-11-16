package tp06.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class TestRecorridos {

	public static void main(String[] args) {
		VerticeImplListAdy<String> buenosAires = new VerticeImplListAdy<String>("Buenos Aires");
		VerticeImplListAdy<String> santiago = new VerticeImplListAdy<String>("Santiago");
		VerticeImplListAdy<String> lima = new VerticeImplListAdy<String>("Lima");
		VerticeImplListAdy<String> montevideo = new VerticeImplListAdy<String>("Montevideo");
		VerticeImplListAdy<String> asuncion = new VerticeImplListAdy<String>("Asunción");
		VerticeImplListAdy<String> caracas = new VerticeImplListAdy<String>("Caracas");
		VerticeImplListAdy<String> habana = new VerticeImplListAdy<String>("La Habana");
		
		GrafoImplListAdy<String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(buenosAires);
		ciudades.agregarVertice(santiago);
		ciudades.agregarVertice(lima);
		ciudades.agregarVertice(montevideo);
		ciudades.agregarVertice(asuncion);
		ciudades.agregarVertice(caracas);
		ciudades.agregarVertice(habana);
		
		ciudades.conectar(buenosAires, santiago);
		ciudades.conectar(buenosAires, lima);
		ciudades.conectar(buenosAires, montevideo);
		ciudades.conectar(buenosAires, asuncion);
		ciudades.conectar(santiago, asuncion);
		ciudades.conectar(santiago, habana);
		ciudades.conectar(lima, asuncion);
		ciudades.conectar(montevideo, asuncion);
		ciudades.conectar(caracas, asuncion);
		ciudades.conectar(caracas, habana);
		
		Recorridos<String> rec = new Recorridos<String>();
		
		System.out.println("- Recorrido DFS -");
		System.out.println();
		
		ListaGenerica<Vertice<String>> lisCiudadesDfs = rec.dfs(ciudades);
		lisCiudadesDfs.comenzar();
		while(!lisCiudadesDfs.fin())
			System.out.println(lisCiudadesDfs.proximo().dato());
		
		System.out.println();
		System.out.println("- Recorrido BFS -");
		System.out.println();
		
		ListaGenerica<Vertice<String>> lisCiudadesBfs = rec.bfs(ciudades);
		lisCiudadesBfs.comenzar();
		while(!lisCiudadesBfs.fin())
			System.out.println(lisCiudadesBfs.proximo().dato());
	}

}
