package PSP.UD01.programacionMultiproceso;

import java.io.IOException;
/**
 * Crea una clase Java cuyo m�todo main lance la aplicaci�n de Firefox.
 * @author Alejandro Escudero S�nchez
 * 2� DAM
 *
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		//Para ejecutar el proceso de cualquier programa, en este caso firefox,
		//tenemos que poner la ruta de donde est� el ejecutable.exe
		try {
			rt.exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
