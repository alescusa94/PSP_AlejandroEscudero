package PSP.UD01.programacionMultiproceso;

import java.io.IOException;
/**
 * Crea una clase Java cuyo método main lance la aplicación de Firefox
 * haciendo uso de ProcessBuilder y pasándole una URL como parámetro.
 * @author Alejandro Escudero Sánchez
 * 2º DAM
 *
 */
public class Ejercicio07 {

	public static void main(String[] args) {
		String comandoLinux ="firefox";
		String comandoWindows="C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		String comando = comandoWindows;
		String url ="iescristobaldemonroy.es";

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(comando, url );
			processBuilder.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
