package tp04.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class TestAnalizadorArbol {

	public static void main(String[] args) {
		/*
		 *                           M-14
		 *               /           |               \
		 *          J-13             K-25             L-10
		 *        /   |   \       /    |    \       /   |    \
		 *      A-4  B-7  C-5   D-6  E-10  F-18   G-9  H-12  I-19
		 * 
		 */

		ArbolGeneral<AreaEmpresa> m14 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("M", 14));
		ArbolGeneral<AreaEmpresa> j13 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("J", 13));
		ArbolGeneral<AreaEmpresa> k25 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("K", 25));
		ArbolGeneral<AreaEmpresa> l10 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("L", 10));
		
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos_m14 = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		
		hijos_m14.agregarFinal(j13);
		hijos_m14.agregarFinal(k25);
		hijos_m14.agregarFinal(l10);
		
		m14.setHijos(hijos_m14);
		
		ArbolGeneral<AreaEmpresa> a4 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("A", 4));
		ArbolGeneral<AreaEmpresa> b7 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("B", 7));
		ArbolGeneral<AreaEmpresa> c5 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("C", 5));
		
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos_j13 = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		
		hijos_j13.agregarFinal(a4);
		hijos_j13.agregarFinal(b7);
		hijos_j13.agregarFinal(c5);
		
		j13.setHijos(hijos_j13);
		
		ArbolGeneral<AreaEmpresa> d6 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("D", 6));
		ArbolGeneral<AreaEmpresa> e10 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("E", 10));
		ArbolGeneral<AreaEmpresa> f18 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("F", 18));
		
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos_k25 = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		
		hijos_k25.agregarFinal(d6);
		hijos_k25.agregarFinal(e10);
		hijos_k25.agregarFinal(f18);
		
		k25.setHijos(hijos_k25);
		
		ArbolGeneral<AreaEmpresa> g9 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("G", 9));
		ArbolGeneral<AreaEmpresa> h12 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("H", 12));
		ArbolGeneral<AreaEmpresa> i19 = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("I", 19));
		
		ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos_l10 = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		
		hijos_l10.agregarFinal(g9);
		hijos_l10.agregarFinal(h12);
		hijos_l10.agregarFinal(i19);
		
		l10.setHijos(hijos_l10);
		
		AnalizadorArbol analizador = new AnalizadorArbol();
		
		System.out.println("El m??ximo promedio es:");
		System.out.println(analizador.devolverMaximoPromedio(m14));
	}

}
