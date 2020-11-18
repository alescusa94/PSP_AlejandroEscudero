package PSP.PracticandoSingleton;


public class Impresora {
	//Atributos
	private static Impresora instancia;
	


	public Impresora() {
	super();
}

	public static Impresora getImpresora() {
		if (instancia == null) {
			System.out.println("Primera llamada, creo la impresora.");
			instancia = new Impresora();
		}else {
			System.out.println("La impresora ya existe, por tanto, devuelvo la instancia ya creada");
		}
		return instancia;
	}

	public static void setImpresora(Impresora instancia) {
		Impresora.instancia = instancia;
	}
	



	
	
	
}
