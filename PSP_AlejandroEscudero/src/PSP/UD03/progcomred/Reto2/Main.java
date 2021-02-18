package PSP.UD03.progcomred.Reto2;

import java.io.IOException;
import java.net.MalformedURLException;


public class Main {

	public static void main(String[] args) throws MalformedURLException, IOException {

		ManagerCalculadora mc = new ManagerCalculadora();
			mc.sumar(7, 6);
			mc.restar(8, 4);
			mc.multiplicar(8, 4);
	}

}
