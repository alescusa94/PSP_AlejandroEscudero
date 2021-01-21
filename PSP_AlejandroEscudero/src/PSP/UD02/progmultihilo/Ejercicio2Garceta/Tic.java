package PSP.UD02.progmultihilo.Ejercicio2Garceta;

public class Tic extends Thread {

	public void run() {
		while(true) {
			System.out.println("Tic...");
			try {

				Thread.sleep(500);

			} catch (InterruptedException e) {
				e.getMessage();

			}
		}
	}

}
