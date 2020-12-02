package PSP.UD01.programacionMultiproceso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ejercicio10 {

	public static void main(String[] args) {
		List <String> listaComandosWindows = new ArrayList<String>();
		listaComandosWindows.add("CMD");
		listaComandosWindows.add("/C");
		listaComandosWindows.add("echo");
		listaComandosWindows.add("%MI_NOMBRE%");
		
		List <String> listaComandosLinux = new ArrayList<String>();
		listaComandosWindows.add("/bin/bash");
		listaComandosWindows.add("-c");
		listaComandosWindows.add("echo $MI_NOMBRE");


		List <String> listaComandos = null;
		
		//Si el nombre del sistema operativo es Windows...
		if (System.getProperty("os.name").contains("Windows")){
			listaComandos = listaComandosWindows; //Se muestra
		}else {
			listaComandos = listaComandosLinux;
		}
		//Creamos el proceso
		ProcessBuilder procesBuild = new ProcessBuilder(listaComandos);
		//Devuelve las variables de entorno en un Map
		Map<String, String> variableEntorno = procesBuild.environment();
		variableEntorno.put("MI_NOMBRE", "ALEJANDRO");
		/**
		 * Este método permite asociar los flujos de entrada y salida a los flujos
		 * actuales de tu programa, de manera que podrás escribir y leer al programa
		 * de manera interactiva como si lo hubieras corrido directamente .
		 */
		procesBuild.inheritIO();
		//Lanzamos el proceso
		try {
			procesBuild.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

}
