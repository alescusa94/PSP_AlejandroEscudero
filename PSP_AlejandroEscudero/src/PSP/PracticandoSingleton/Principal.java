package PSP.PracticandoSingleton;


public class Principal {

	public static void main(String[] args) {
		Impresora impresora1 = Impresora.getImpresora();
		Impresora impresora2 = Impresora.getImpresora();
		
		
		System.out.println("Referencia de la primera impresora: " + impresora1);
		System.out.println("Referencia de la segunda impresora: " + impresora2);

	}

}
 