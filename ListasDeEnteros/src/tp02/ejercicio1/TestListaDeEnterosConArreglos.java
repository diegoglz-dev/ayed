package tp02.ejercicio1;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		
		for (int i = 0; i < args.length; i++) {
			lista.agregarFinal(Integer.parseInt(args[i]));
		}
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}

	}

}
