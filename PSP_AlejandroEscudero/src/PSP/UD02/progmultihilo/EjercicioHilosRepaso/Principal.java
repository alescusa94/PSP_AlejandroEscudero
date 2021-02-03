package PSP.UD02.progmultihilo.EjercicioHilosRepaso;

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
