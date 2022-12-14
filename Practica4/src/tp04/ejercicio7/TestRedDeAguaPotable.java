package tp04.ejercicio7;

import tp04.ejercicio1.ArbolGeneral;

public class TestRedDeAguaPotable {

	public static void main(String[] args) {
		ArbolGeneral<Character> a = new ArbolGeneral<Character>('A');

		ArbolGeneral<Character> b = new ArbolGeneral<Character>('B');
		ArbolGeneral<Character> c = new ArbolGeneral<Character>('C');
		ArbolGeneral<Character> d = new ArbolGeneral<Character>('D');
		ArbolGeneral<Character> e = new ArbolGeneral<Character>('E');
		
		ArbolGeneral<Character> f = new ArbolGeneral<Character>('F');
		ArbolGeneral<Character> g = new ArbolGeneral<Character>('G');
		
		ArbolGeneral<Character> h = new ArbolGeneral<Character>('H');
		ArbolGeneral<Character> i = new ArbolGeneral<Character>('I');
		ArbolGeneral<Character> j = new ArbolGeneral<Character>('J');
		ArbolGeneral<Character> k = new ArbolGeneral<Character>('K');
		
		ArbolGeneral<Character> l = new ArbolGeneral<Character>('L');
		
		ArbolGeneral<Character> m = new ArbolGeneral<Character>('M');
		ArbolGeneral<Character> n = new ArbolGeneral<Character>('N');
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		a.agregarHijo(e);
		
		c.agregarHijo(f);
		c.agregarHijo(g);
		
		d.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);
		d.agregarHijo(k);
		
		g.agregarHijo(l);
		
		j.agregarHijo(m);
		j.agregarHijo(n);
		
		RedDeAguaPotable<Character> red = new RedDeAguaPotable<Character>(a);
		System.out.println("El minimo caudal de la red es: " + red.minimoCaudal(1000));
	}

}
