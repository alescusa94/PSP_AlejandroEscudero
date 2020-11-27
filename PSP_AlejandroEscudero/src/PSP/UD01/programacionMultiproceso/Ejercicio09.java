package PSP.UD01.programacionMultiproceso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Realizar una clase Java cuyo m�todo main cree un ProcessBuilder con un List
 * de String realizando un listado del directorio src. Las salidas est�ndar y de
 * error deben ser redirigidas a un fichero cuyo nombre sea
 * salida_ejercicio9.txt y log_ejercicio9.txt respectivamente. Adem�s, por
 * pantalla debe indicarnos un mensaje sobre qu� fichero consultar en funci�n de
 * si la ejecuci�n del proceso ha sido o no err�nea
 * 
 * @author Alejandro Escudero S�nchez 2� DAM
 *
 */
public class Ejercicio09 {

	public static void main(String[] args) {
		Process proceso = null;
		int estado = -1;
		String comandoLinux = "ls -help";
		String comandoWindows = "CMD /C DIR C:\\\\Users\\\\aleja\\\\git\\\\PSP_AlejandroEscudero\\\\PSP_AlejandroEscudero\\\\ficheros";
		String comando = comandoWindows;
		List<String> listaComandos = new ArrayList<String>();
		listaComandos.add("CMD");
		listaComandos.add("DIR");
		listaComandos.add("/C");
		listaComandos.add("C:\\Users\\aleja\\git\\PSP_AlejandroEscudero\\PSP_AlejandroEscudero\\ficheros");

		// Creamos el procesBuilder de la lista de comandos
		ProcessBuilder procesBuild = new ProcessBuilder(listaComandos);

		// Indicamos los respectivos ficheros de salida
		File ficheroSalida = new File(Ejercicio03.getCadenaFichero("salida_ejercicio9.txt"));
		File ficheroSalidaError = new File(Ejercicio03.getCadenaFichero("log_ejercicio9.txt"));
		procesBuild.redirectOutput(ficheroSalidaError);
		procesBuild.redirectError(ficheroSalida);

		try {

			proceso = procesBuild.start(); // iniciamos el proceso
			estado = proceso.waitFor();// El estado espera hasta que termine el proceso por completo
			System.out.println("El comando " + comando + " ha resultado " + estado);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		if (estado == 0) {
			// Ha ido ok, se muestra el ficheroSalida
			System.out.println("Consultar salida en: " + ficheroSalida);

		} else {
			// Se muestra el fichero log
			System.out.println("Consultar log en: " + ficheroSalidaError);

		}

	}

}
