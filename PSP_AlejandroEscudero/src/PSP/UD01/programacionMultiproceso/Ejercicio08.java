package PSP.UD01.programacionMultiproceso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 1) Crea una clase Java cuyo m�todo main:
 * 1.1)Cree un objeto ProcessBuilder a trav�s del cual consultar las
 * variables de entorno.
 * 1.1) Cree un segundo objeto ProcessBuilder para lanzar un proceso que
 * muestre la ayuda del sistema para el comando ls (ls --help). Antes de
 * lanzarlo, deben listarse los argumentos de la llamada
 * @author Alejandro Escudero S�nchez
 * 2� DAM
 *
 */
public class Ejercicio08 {

	public static void main(String[] args) {
		//Apartadp 1.1
		ProcessBuilder procEnvironment = new ProcessBuilder();
		Map<String, String> variables = procEnvironment.environment();
		System.out.println(variables);
		List<String> listaComandos = new ArrayList<String>();
		listaComandos.add("CMD");
		listaComandos.add("/C");
		listaComandos.add("DIRR");
		
		ProcessBuilder procesBuild = new ProcessBuilder(listaComandos);
		System.out.println(procesBuild.command());
		
		try {
			procesBuild.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
