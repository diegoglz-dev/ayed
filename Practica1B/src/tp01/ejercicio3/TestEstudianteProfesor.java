package tp01.ejercicio3;

import java.util.ArrayList;

public class TestEstudianteProfesor {
	
	public static void main(String[] args) {
		// Estudiantes
		Estudiante juan = new Estudiante();
		juan.setNombre("Juan");
		juan.setApellido("Gomez");
		juan.setEmail("juan.gomez@gmail.com");
		juan.setDireccion("Calle 2, 543, La Plata");
		juan.setComision("Comisión 1");
		
		Estudiante jose = new Estudiante();
		jose.setNombre("Jose");
		jose.setApellido("Perez");
		jose.setEmail("jose.perez@gmail.com");
		jose.setDireccion("Calle 44, 1532, La Plata");
		jose.setComision("Comisión 2");
		
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudiantes.add(juan);
		estudiantes.add(jose);
		
		for (int i = 0; i < estudiantes.size(); i++) {
			System.out.println(estudiantes.get(i).tusDatos());
		}
		
		// Profesores
		Profesor natalia = new Profesor();
		natalia.setNombre("Natalia");
		natalia.setApellido("Castro");
		natalia.setEmail("natalia.castro@gmail.com");
		natalia.setCatedra("Algoritmos y Estructura de Datos");
		natalia.setFacultad("Informatica");
		
		Profesor oscar = new Profesor();
		oscar.setNombre("Oscar");
		oscar.setApellido("San Valiente");
		oscar.setEmail("oscar.san.valiente@gmail.com");
		oscar.setCatedra("Arquitectura de computadoras");
		oscar.setFacultad("Informatica");
		
		Profesor nacho = new Profesor();
		nacho.setNombre("Ignacio");
		nacho.setApellido("Gonzalez");
		nacho.setEmail("nacho.gonzalez@gmail.com");
		nacho.setCatedra("Diseño de interfaces");
		nacho.setFacultad("Bellas Artes");
		
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		profesores.add(natalia);
		profesores.add(oscar);
		profesores.add(nacho);
		
		for (Profesor profesor : profesores) {
			System.out.println(profesor.tusDatos());
		}
	}
}
