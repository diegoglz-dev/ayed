package tp02.ejercicio2;

import tp01.ejercicio3.Estudiante;

public class TestListaEnlazadaGenerica {
	
	public static void main(String args[]) {
		Estudiante hanamichi = new Estudiante("Hanamichi", "Sakuragi", "hanamichi@gmail.com", "Comisión 1", "Informatica");
		Estudiante ryota = new Estudiante("Ryota", "Miyagi", "ryotamiyagi@gmail.com", "Comisión 2", "Informatica");
		Estudiante mitsui = new Estudiante("Hisashi", "Mitsui", "hisashi@gmail.com", "Comisión 3", "Informatica");
		Estudiante takenori = new Estudiante("Takenori", "Akagi", "takenori@gmail.com", "Comisión 3", "Informatica");
		
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
		lista.agregarFinal(hanamichi);
		lista.agregarFinal(ryota);
		lista.agregarFinal(mitsui);
		lista.agregarFinal(takenori);
		
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
		}
	}
}
