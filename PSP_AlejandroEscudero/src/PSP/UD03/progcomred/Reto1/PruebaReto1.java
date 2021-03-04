package PSP.UD03.progcomred.Reto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PruebaReto1 {
/**
 * Se ha definido el endpoint https://psp2021site.000webhostapp.com/ que contiene un recurso llamado suma_parametros.php.
 * Esta aplicación recibe dos parámetros llamados PARAM_A y PARAM_B los suma y muestra el resultado.
 * Crea una clase java que conecte con este servicio, realice la suma y muestra por pantalla su resultado.
 * @param args
 */
	public static void main(String[] args) {
		URL url = null;
		URLConnection conexion = null;

		try {
			//Introducimos la URL
			url = new URL("https://psp2021site.000webhostapp.com/suma_parametros.php");
			//Abrimos la conexion
			conexion = url.openConnection();
			//Permitimos el envío datos si el parámetro es true
			conexion.setDoOutput(true);
			// Le pasamos los parámetros por cadena
			String cadena = "PARAM_A=5&PARAM_B=6";
			//Escribimos en la URL
			PrintWriter output = new PrintWriter(conexion.getOutputStream());
			output.write(cadena);
			output.close();
			BufferedReader bReader;
			InputStream inputStream = conexion.getInputStream();
			//Leemos la URL
			bReader = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = bReader.readLine()) != null) {
				// Eliminamos la etiqueta HTML con el replaceAll

				System.out.println(inputLine.replaceAll("\\<[^>]*>", ""));
			}
			//Cerramos el flujo
			bReader.close();


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
