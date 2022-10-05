package tp02.ejercicio1;

public class TestListaDeEnterosEnlazada {

	public static void main(String[] args) {
		
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		
		for (int i = 0; i < args.length; i++) {
			lista.agregarFinal(Integer.parseInt(args[i]));
		}
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
		
		System.out.println("---- · ----");
		
		ListaInversa listaInversa = new ListaInversa();
		listaInversa.invertir(lista, 1);

	}

}
