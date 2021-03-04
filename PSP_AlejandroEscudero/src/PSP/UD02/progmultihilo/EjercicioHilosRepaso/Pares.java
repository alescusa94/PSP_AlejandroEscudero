package PSP.UD02.progmultihilo.EjercicioHilosRepaso;


public class Pares extends Thread {
	public void run() {
		int numero;
		int suma = 0;
		//Recorremos los números del 1 al 10
		for (numero = 1; numero <= 10; numero++) {
			//Si el número es par, lo muestra
			if (numero % 2 == 0) {
				System.out.print(" " + numero + "\n");
				suma = suma + numero;
			}
		}
		//Mostramos el resultado de la suma de todos los pares
		System.out.print("La suma de los pares es : " + suma + "\n");
		System.out.print(" ******************** \n");
	}

}
