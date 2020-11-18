package PSP.UD01.programacionMultiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Crea una clase Java cuyo método main liste los ficheros del directorio actual
 * y los pinte por pantalla.
 * @author Alejandro Escudero Sánchez
 * 2º DAM
 *
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process proceso = null;
		try {
			proceso = rt.exec("CMD /C DIR"); //comando Windows para ejecutar el proceso
			
			InputStream is = proceso.getInputStream(); //flujo de entrada de bytes del proceso
			//Creamos el flujo para poder leer ese proceso como texto
			BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
			String linea;
			//Mientras se lea una línea, las irá mostrando
			while ((linea = buffer.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
