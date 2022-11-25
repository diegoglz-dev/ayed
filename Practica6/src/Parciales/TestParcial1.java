package Parciales;

import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.VerticeImplListAdy;

public class TestParcial1 {

	public static void main(String[] args) {
		VerticeImplListAdy<String> lincoln = new VerticeImplListAdy<String>("Lincoln");
		VerticeImplListAdy<String> chascomus = new VerticeImplListAdy<String>("Chascomus");
		VerticeImplListAdy<String> canuelas = new VerticeImplListAdy<String>("Cañuelas");
		VerticeImplListAdy<String> dolores = new VerticeImplListAdy<String>("Dolores");
		VerticeImplListAdy<String> veronica = new VerticeImplListAdy<String>("Veronica");
		VerticeImplListAdy<String> villaUrquiza = new VerticeImplListAdy<String>("Villa Urquiza");
		VerticeImplListAdy<String> ranchos = new VerticeImplListAdy<String>("Ranchos");
		VerticeImplListAdy<String> berisso = new VerticeImplListAdy<String>("Berisso");
		
		GrafoImplListAdy<String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(lincoln);
		ciudades.agregarVertice(chascomus);
		ciudades.agregarVertice(canuelas);
		ciudades.agregarVertice(dolores);
		ciudades.agregarVertice(veronica);
		ciudades.agregarVertice(villaUrquiza);
		ciudades.agregarVertice(ranchos);
		ciudades.agregarVertice(berisso);
		
		ciudades.conectar(lincoln, chascomus, 70);
		ciudades.conectar(lincoln, canuelas, 50);
		ciudades.conectar(lincoln, dolores, 90);
		
		ciudades.conectar(chascomus, lincoln, 70);
		ciudades.conectar(chascomus, veronica, 80);
		ciudades.conectar(chascomus, villaUrquiza, 60);
		
		ciudades.conectar(canuelas, lincoln, 50);
		ciudades.conectar(canuelas, veronica, 85);
		ciudades.conectar(canuelas, ranchos, 90);
		
		ciudades.conectar(dolores, lincoln, 90);
		ciudades.conectar(dolores, villaUrquiza, 70);
		ciudades.conectar(dolores, ranchos, 70);
		
		ciudades.conectar(veronica, chascomus, 80);
		ciudades.conectar(veronica, canuelas, 85);
		ciudades.conectar(veronica, berisso, 60);
		
		ciudades.conectar(villaUrquiza, chascomus, 60);
		ciudades.conectar(villaUrquiza, dolores, 70);
		ciudades.conectar(villaUrquiza, berisso, 90);
		
		ciudades.conectar(ranchos, canuelas, 90);
		ciudades.conectar(ranchos, dolores, 70);
		ciudades.conectar(ranchos, berisso, 75);
		
		ciudades.conectar(berisso, veronica, 60);
		ciudades.conectar(berisso, villaUrquiza, 90);
		ciudades.conectar(berisso, ranchos, 75);
		
		Parcial1 parcial1 = new Parcial1();
		System.out.println(parcial1.caminoConPresupuesto(ciudades, "Lincoln", "Berisso", 200));
		
		// Recorridos rec = new Recorridos();
		// System.out.println(rec.buscarCamino(ciudades, "Lincoln", "Berisso"));

	}

}
