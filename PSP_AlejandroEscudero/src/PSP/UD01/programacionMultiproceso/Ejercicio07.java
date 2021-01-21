package PSP.UD01.programacionMultiproceso;

import java.io.IOException;
/**
 * Crea una clase Java cuyo m�todo main lance la aplicaci�n de Firefox
 * haciendo uso de ProcessBuilder y pas�ndole una URL como par�metro.
 * @author Alejandro Escudero S�nchez
 * 2� DAM
 *
 */
public class Ejercicio07 {

	public static void main(String[] args) {
		String comandoLinux ="firefox";
		String comandoWindows="C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		String comando = comandoWindows;
		String url ="iescristobaldemonroy.es";

		try {
			//Crea el proceso
			ProcessBuilder processBuilder = new ProcessBuilder(comando, url );
			//lo inicia
			processBuilder.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
