package PSP.UD01.programacionMultiproceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Crea una clase Java cuyo método main liste los ficheros del directorio actual
 * y los guarde en un fichero de texto.
 * @author Alejandro Escudero Sánchez
 * 2º DAM
 *
 */
public class Ejercicio03 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process proceso = null;
		String comandoLinux = "ls -help";
		String comandoWindows ="CMD /C DIR";
		String comando = comandoWindows;

		try {
			proceso = rt.exec(comando); //comando Windows para ejecutar el proceso
			
			InputStream is = proceso.getInputStream(); //flujo de entrada de bytes del proceso
			//Creamos el flujo para poder leer ese proceso como texto
			BufferedReader flujoReader = new BufferedReader(new InputStreamReader(is));
			//Crea el fichero "salida_comando_" + el comando y guarda en él lo que devuelve la ejecución del proceso
			BufferedWriter flujoWriter = new BufferedWriter(new FileWriter(getCadenaFichero("salida_comando_" + comando.replace('/', '_'))));
			String linea;
			//Mientras se lea una línea, las irá mostrando
			while ((linea = flujoReader.readLine()) != null) {
				flujoWriter.write(linea);//Escribe la línea
				flujoWriter.newLine(); //Pasa a escribir otra línea
			}
			//Cerramos los flujos
			flujoReader.close();
			flujoWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getCadenaFichero(String nombreFichero) {
		String ruta = "ficheros" + "/" + nombreFichero;
		return ruta;
	}

}
