package PSP.UD01.programacionMultiproceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Crea una clase Java cuyo m�todo main lance un comando que provoque
 * errores y genere un fichero con la descripci�n del error.
 * @author Alejandro Escudero S�nchez
 * 2� DAM
 *
 */
public class Ejercicio06 {

	/**
	 * Crea una clase Java cuyo m�todo main lance un comando que provoque errores y genere un fichero con la descripci�n del error.
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "lsss -help";
		String comandoWindows = "CMD /C DIRRRR";
		String comando = comandoWindows;
		Process p = null;
		try {
			p = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int status;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);	
			System.out.println("Consulte los fichero de logs para m�s informaci�n.");
			
			InputStream errStream = p.getErrorStream();
			br = new BufferedReader(new InputStreamReader(errStream));
			
			bw = new BufferedWriter(
					new FileWriter(
							Ejercicio03.getCadenaFichero("log_err_ejercicio6.txt")));
			
			String linea;
			while ((linea = br.readLine())!=null) {
				bw.write(linea);
				bw.newLine();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}

