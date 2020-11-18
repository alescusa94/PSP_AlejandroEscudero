package PSP.UD01.programacionMultiproceso;

import java.io.IOException;

public class Ejercicio01 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		//Para ejecutar el proceso de cualquier programa, en este caso firefox,
		//tenemos que poner la ruta de donde esté el ejecutable.exe
		try {
			rt.exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
