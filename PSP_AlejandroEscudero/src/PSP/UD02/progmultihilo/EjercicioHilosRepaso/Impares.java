package PSP.UD02.progmultihilo.EjercicioHilosRepaso;

public class Impares extends Thread {
	public void run() {
		int numero, c = 0;
		int suma = 0;
		//Recorremos los números del 1 al 10
		for (numero = 1; numero <= 10; numero++) {
			c = numero % 2;
			//Si no es par, al dividirlo entre 2 no da 0
			if (c != 0) {
				suma = suma + numero;
				System.out.println(" " + numero);
			}
		}
		//Mostramos el resultado de la suma de todos los impares
		System.out.print("La suma de los impares es : " + suma + "\n");
	}
}
