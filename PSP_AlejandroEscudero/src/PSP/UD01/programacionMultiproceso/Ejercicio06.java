package PSP.UD01.programacionMultiproceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Crea una clase Java cuyo método main lance un comando que provoque errores y
 * genere un fichero con la descripción del error.
 * 
 * @author Alejandro Escudero Sánchez 2º DAM
 *
 */
public class Ejercicio06 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process proceso = null;
		String comandoLinux = "ls --help";
		String comandoWindows = "CMD /C DIRRRR"; // comando para Windows (mal puesto para que provoque error)
		String comando = comandoWindows;

		int estado;
		BufferedReader flujoLectura = null;
		BufferedWriter flujoEscritura = null;
		try {
			proceso = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			estado = proceso.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + estado);
			System.out.println("Consulte los ficheros de logs para más información.");

			// PARA GENERAR UN FICHERO CON LA INFORMACIÓN DEL ERROR
			InputStream errStream = proceso.getErrorStream();
			flujoLectura = new BufferedReader(new InputStreamReader(errStream));

			flujoEscritura = new BufferedWriter(new FileWriter(Ejercicio03.getCadenaFichero("log_err_ejercicio6.txt")));

			String linea;
			while ((linea = flujoLectura.readLine()) != null) {
				flujoEscritura.write(linea);
				flujoEscritura.newLine();
			}
			// Cerramos los flujos
			flujoLectura.close();
			flujoEscritura.close();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();

		}
	}
}
