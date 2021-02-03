package PSP.UD02.progmultihilo.EjercicioHilosRepaso;

/**
 * Implemente un programa en java que use hilos independientes, en clases diferentes. 
 * Un hilo imprime números pares del 1 al 10 y la suma de dichos números, y otro hilo 
 * que imprime números impares del 1 al 10. Cree dos instancias (hilos) de cada uno y muestre la salida. 
 * Realice el programa utilizando herencia en otra clase
 * @author aleja
 *
 */
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
