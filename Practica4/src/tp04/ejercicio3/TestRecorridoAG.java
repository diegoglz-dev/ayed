package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class TestRecorridoAG {

	public static void main(String[] args) {
		/*
		 *               10
		 *          /      |   \
		 *         4       2    5
		 *       / | \    /
		 *      9  8  7  44
		 *     /
		 *    77
		 */
		
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(5);
		
		ListaGenerica<ArbolGeneral<Integer>> hijos_a10 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_a10.agregarFinal(a4);
		hijos_a10.agregarFinal(a2);
		hijos_a10.agregarFinal(a5);
		
		a10.setHijos(hijos_a10);
		
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a8 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(7);
		
		ListaGenerica<ArbolGeneral<Integer>> hijos_a4 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_a4.agregarFinal(a9);
		hijos_a4.agregarFinal(a8);
		hijos_a4.agregarFinal(a7);
		
		a4.setHijos(hijos_a4);
		
		ArbolGeneral<Integer> a44 = new ArbolGeneral<Integer>(44);
		
		ListaGenerica<ArbolGeneral<Integer>> hijos_a2 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		hijos_a2.agregarFinal(a44);
		
		a2.setHijos(hijos_a2);
		
		ArbolGeneral<Integer> a77 = new ArbolGeneral<Integer>(77);
		
		ListaGenerica<ArbolGeneral<Integer>> hijos_a9 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_a9.agregarFinal(a77);
		
		a9.setHijos(hijos_a9);
		
		
		RecorridosAG recorridos = new RecorridosAG();
		
		System.out.println("---- Recorrido PreOrden ----");
		System.out.println(recorridos.numerosImparesMayoresQuePreOrden(a10, 1));
		
		System.out.println("---- Recorrido InOrden ----");
		System.out.println(recorridos.numerosImparesMayoresQueInOrden(a10, 1));
		
		System.out.println("---- Recorrido PostOrden ----");
		System.out.println(recorridos.numerosImparesMayoresQuePostOrden(a10, 1));
		
		System.out.println("---- Recorrido Por Niveles ----");
		System.out.println(recorridos.numerosImparesMayoresQuePorNiveles(a10, 1));
		
		System.out.println("---- Altura del ??rbol General ----");
		System.out.println(a10.altura());
		
		System.out.println("---- Dato encontrado en el nivel ----");
		System.out.println(a10.nivel(44));
		
		System.out.println("---- Ancho del ??rbol ----");
		System.out.println(a10.ancho());
		
		System.out.println("---- Es ancestro ----");
		System.out.println(a10.esAncestro(8, 4));
	}

}
