package PSP.CodificadorCesar;
/**
 * @author Alejandro Escudero Sánchez 2º DAM
 * Ejercicio Codificador César de un texto.
 */
import java.util.Scanner;

public class PrincipalCodificadorCesar {

	private static final int DESPLAZAMIENTO_CESAR = 0;
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		//Variables
		String texto; //texto que se va a tratar
		int codigo; // número a indicar cuántas posiciones queremos que se desplacen los caracteres
		char opcion; //para elegir si queremos codificar o des
		//Inicio

		do {
			System.out.println("Introduce un texto:");
			texto = teclado.nextLine();
		} while (texto.charAt(0) < 0);//Si la cadena está vacía volverá a pedirlo
		
		//Pedimos el código, debe desplazarse al menos una posición
		do {
			System.out.println("¿Qué valor de desplazamiento deseas darle?: ");
			codigo = Integer.parseInt(teclado.nextLine());
		} while (codigo <= 0);
		
		//Introducimos qué queremos que haga el texto
		do {
			System.out.println("¿Deseas codificar (C) o descodificar (D)?: ");
			opcion = teclado.nextLine().charAt(0);
			opcion = Character.toUpperCase(opcion); //Convertimos a mayúsculas
			
		} while (opcion != 'C' && opcion == 'D');
		
		if(opcion == 'C') { //Si elegimos C, codifica
			System.out.println("Texto codificado: " + codifica(texto));
		}else {
			System.out.println("Texto descodificado: " + decodifica(texto));
		}
	
	}

	/**
	 * Método que codifica un texto
	 * @param texto
	 * @return cifrado.toString()
	 */
	public static String codifica (String texto) {
        StringBuilder cifrado = new StringBuilder();
        int codigo = DESPLAZAMIENTO_CESAR % 26;
        for (int i = 0; i < texto.length(); i++) {
        	if (texto.charAt(i)!=' ') {
	            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
	                if ((texto.charAt(i) + codigo) > 'z') {
	                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) + codigo));
	                }
	            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
	                if ((texto.charAt(i) + codigo) > 'Z') {
	                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) + codigo));
	                }
	            }
        	}else {
        		cifrado.append( (char) texto.charAt(i) );
        	}
        }
        return cifrado.toString();
	}
	
	/**
	 * Método que descodifica un texto
	 * @param texto
	 * @return cifrado.toString()
	 */
	public static String decodifica (String texto) {
		StringBuilder cifrado = new StringBuilder();
        int codigo = DESPLAZAMIENTO_CESAR % 26;
        for (int i = 0; i < texto.length(); i++) {
        	if (texto.charAt(i)!=' ') {
        		if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) - codigo) < 'a') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) - codigo) < 'A') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                }        		
        	}else {
        		cifrado.append( (char) texto.charAt(i) );
        	}
        }
        return cifrado.toString();
	}
}
