package PSP.UD01.programacionMultiproceso;

import java.io.IOException;
/**
 * Crea una clase Java cuyo método main lance la aplicación de Firefox.
 * @author Alejandro Escudero Sánchez
 * 2º DAM
 *
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "firefox iescristobaldemonroy.es";
		String comandoWindows = "C:\\Program Files\\Mozilla Firefox\\firefox.exe iescristobaldemonroy.es";
		String comando = comandoWindows;

		//Para ejecutar el proceso de cualquier programa, en este caso firefox,
		//tenemos que poner la ruta de donde esté el ejecutable.exe y a continuación la página indicada, con su dominio
		try {
			rt.exec(comando); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
