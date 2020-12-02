package PSP.UD01.programacionMultiproceso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 11:
 * Realiza una clase Java cuyo método main lance un proceso ejecutando la
 * clase del Ejercicio10.
 * @author Alejandro Escudero Sánchez
 * 2º DAM
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		List<String>listaComandos = new ArrayList<String>();
		listaComandos.add("java");
		listaComandos.add("PSP.UD01.programacionMultiproceso.Ejercicio10");
		ProcessBuilder procesBuild = new ProcessBuilder(listaComandos);
		//El classpath será la ruta del proyecto
		String classpath = "C:\\Users\\aleja\\git\\PSP_AlejandroEscudero\\PSP_AlejandroEscudero\\bin";
		//Obtenemos las variables de entorno
		procesBuild.environment().put("CLASSPATH", classpath);
		//asociamos los flujos de entrada y salida
		procesBuild.inheritIO();
		
		try {
			procesBuild.start();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
