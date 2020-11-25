package PSP.UD01.programacionMultiproceso;

import java.io.IOException;

/**
 * Crea una clase Java cuyo método main lance un comando que provoque
 * errores y pinta por pantalla el valor devuelto por el error.
 * @author Alejandro Escudero Sánchez
 * 2º DAM
 *
 */
public class Ejercicio04 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process proceso = null;
		String comandoLinux = "ls --help";
		String comandoWindows ="CMD /C DIRRRR"; //comando para Windows
		String comando = comandoWindows;
		int estado;
		try {
			proceso = rt.exec(comando);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			//El estado espera hasta que termine el proceso por completo
			/*
			 * Este método devuelve el valor de salida del proceso representado 
			 * por este objeto de proceso.
			 */
			estado = proceso.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + estado);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
