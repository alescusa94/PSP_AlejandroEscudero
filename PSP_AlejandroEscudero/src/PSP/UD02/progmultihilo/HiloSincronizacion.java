/**
 * 
 */
package PSP.UD02.progmultihilo;

/**
 * @author JESUS
 *
 */
public class HiloSincronizacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();

		try {
			//Con el join forzamos a que esperen a que termine el hilo invocado, A y B, respectivamente
			a.join();
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Una vez termine el hilo se muestra el valor del contador
		System.out.println("Al final: " + cont.getValor());
	}

	static class Contador {
		private int contador = 0; // atributo contador

		Contador(int c) {
			this.contador = c;
		}

		public void incrementa() {
			contador = contador + 1;
		}

		public void decrementa() {
			contador = contador - 1;
		}

		public int getValor() {
			return contador;
		}
	}

	static class HiloA extends Thread {
		private Contador contador;

		public HiloA(String n, Contador c) {
			setName(n);
			contador = c;
		}

		public void run() {
			synchronized (contador) {
				for (int j = 0; j < 100; j++) {
					contador.incrementa(); // incrementa el contador
					try {
						sleep(100);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(getName() + " contador vale " + contador.getValor());

			}

		}
	}

	static class HiloB extends Thread {
		private Contador contador;

		public HiloB(String n, Contador c) {
			setName(n);
			contador = c;
		}

		public void run() {
			synchronized (contador) {
				for (int j = 0; j < 100; j++) {
					contador.decrementa(); // decrementa el contador
					try {
						sleep(100);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(getName() + " contador vale " + contador.getValor());

			}

		}
	}
}
