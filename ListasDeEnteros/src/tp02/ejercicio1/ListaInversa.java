package tp02.ejercicio1;

public class ListaInversa {
	
	public void invertir(ListaDeEnteros lista, int pos) {
		if (pos == lista.tamanio()) {
			System.out.println(lista.elemento(pos));
		} else {
			invertir(lista, pos+1);
			System.out.println(lista.elemento(pos));
		}
	}
}
