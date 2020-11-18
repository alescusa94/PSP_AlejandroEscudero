package PSP.CopiaFichero;
/**
 * Ejercicio de clase. PROSE
 * Hacer copia del fichero original.txt
 * @author Alejandro Escudero Sánchez 2º DAM
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrincipalFile {

	private static final String COPIA_TXT = "copia.txt";
	private static final String ORIGINAL_TXT = "original.txt";

	public static void main(String[] args) {

		File ficheroOriginal = null, ficheroCopia = null;

		copiarFichero(ficheroOriginal, ficheroCopia);

	}

	/**
	 * Método que copia el fichero original
	 * 
	 * @param ficheroOriginal
	 * @param ficheroCopia
	 */
	private static void copiarFichero(File ficheroOriginal, File ficheroCopia) {

		// Creamos los objetos objeto fichero original y el de copia
		ficheroOriginal = new File(ORIGINAL_TXT);
		ficheroCopia = new File(COPIA_TXT);

		// Si el fichero original existe y es fichero, entonces lo trata
		if (ficheroOriginal.exists() && ficheroOriginal.isFile()) {
			try (FileInputStream flujoLectura = new FileInputStream(ORIGINAL_TXT);
					FileOutputStream flujoEscritura = new FileOutputStream(COPIA_TXT);) {

				// Realizamos la lectura y escritura mientras existan datos en el flujo de
				// lectura

				byte[] buffer = new byte[1024];
				int cantidad;

				while ((cantidad = flujoLectura.read(buffer)) > 0) {
					flujoEscritura.write(buffer, 0, cantidad);
				}
				flujoEscritura.close();
				flujoLectura.close();
				//Se cierra el fichero y se muestra el mensaje.
				System.out.println("Fichero creado correctamente");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} else { //Si no, mensaje de error
			System.out.println("No se encuentra el fichero " + ficheroOriginal);
		}

	}
}
