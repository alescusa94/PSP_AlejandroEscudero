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

	public static void main(String[] args) {
		URL url = null;
		URLConnection conexion = null;
		try {
			url = new URL("https://psp2021site.000webhostapp.com/suma_parametros.php");
			conexion = url.openConnection();
			conexion.setDoInput(true);
			// Le pasamos los parámetros por cadena
			String cadena = "PARAM_A=5&PARAM_B=6";
			PrintWriter output = new PrintWriter(conexion.getOutputStream());
			output.write(cadena);
			output.close();
			BufferedReader bReader;
			InputStream inputStream = conexion.getInputStream();
			bReader = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = bReader.readLine()) != null) {
				// Eliminamos la etiqueta HTML con el replaceAll

				System.out.println(inputLine.replaceAll("\\<[^>]*>", ""));
				bReader.close();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
