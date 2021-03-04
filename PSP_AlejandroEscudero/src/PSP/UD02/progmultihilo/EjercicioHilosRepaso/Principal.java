package PSP.UD02.progmultihilo.EjercicioHilosRepaso;

/**
 * Implemente un programa en java que use hilos independientes, en clases diferentes. 
 * Un hilo imprime números pares del 1 al 10 y la suma de dichos números, y otro hilo 
 * que imprime números impares del 1 al 10. Cree dos instancias (hilos) de cada uno y muestre la salida. 
 * Realice el programa utilizando herencia en otra clase
 * @author aleja
 *
 */
public class Principal {

	public static void main(String[] args) {
		//Creamos los pares y lo iniciamos
		Pares eje1 = new Pares();
		eje1.start();
		//Creamos los impares y lo iniciamos
		Impares eje2 = new Impares();
		eje2.start();
	}

}
