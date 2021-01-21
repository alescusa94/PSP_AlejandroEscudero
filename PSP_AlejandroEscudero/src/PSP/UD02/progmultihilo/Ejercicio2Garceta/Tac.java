package PSP.UD02.progmultihilo.Ejercicio2Garceta;

public class Tac extends Thread{

	public void run() {
		while(true){
			System.out.println("Tac...");
			try {

				Thread.sleep(500);

			} catch (InterruptedException e) {
				e.getMessage();

			}
		}
	}
}
