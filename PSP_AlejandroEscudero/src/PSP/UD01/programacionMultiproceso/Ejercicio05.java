package PSP.UD01.programacionMultiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Crea una clase Java cuyo m�todo main lance un comando que provoque
 * errores y pinte por pantalla la descripci�n del error.
 * @author Alejandro Escudero S�nchez 
 * 2� DAM
 *
 */
public class Ejercicio05 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process proceso = null;
		String comando ="CMD /C DIRRRR"; //comando para Windows
		int estado;
		try {
			proceso = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			estado = proceso.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + estado);
			System.out.println("Salida: ");
			
			//Devuelve el flujo de entrada conectado a la salida de error del proceso.
			InputStream flujoError = proceso.getErrorStream(); 
			BufferedReader flujoReader = new BufferedReader(new InputStreamReader(flujoError));
			
			String linea = "";
			while ((linea = flujoReader.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

}
