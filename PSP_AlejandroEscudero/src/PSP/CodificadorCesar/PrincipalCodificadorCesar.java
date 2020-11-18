package PSP.CodificadorCesar;
/**
 * @author Alejandro Escudero S�nchez 2� DAM
 * Ejercicio Codificador C�sar de un texto.
 */
import java.util.Scanner;

public class PrincipalCodificadorCesar {

	private static final int DESPLAZAMIENTO_CESAR = 0;
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		//Variables
		String texto; //texto que se va a tratar
		int codigo; // n�mero a indicar cu�ntas posiciones queremos que se desplacen los caracteres
		char opcion; //para elegir si queremos codificar o des
		//Inicio

		do {
			System.out.println("Introduce un texto:");
			texto = teclado.nextLine();
		} while (texto.charAt(0) < 0);//Si la cadena est� vac�a volver� a pedirlo
		
		//Pedimos el c�digo, debe desplazarse al menos una posici�n
		do {
			System.out.println("�Qu� valor de desplazamiento deseas darle?: ");
			codigo = Integer.parseInt(teclado.nextLine());
		} while (codigo <= 0);
		
		//Introducimos qu� queremos que haga el texto
		do {
			System.out.println("�Deseas codificar (C) o descodificar (D)?: ");
			opcion = teclado.nextLine().charAt(0);
			opcion = Character.toUpperCase(opcion); //Convertimos a may�sculas
			
		} while (opcion != 'C' && opcion == 'D');
		
		if(opcion == 'C') { //Si elegimos C, codifica
			System.out.println("Texto codificado: " + codifica(texto));
		}else {
			System.out.println("Texto descodificado: " + decodifica(texto));
		}
	
	}

	/**
	 * M�todo que codifica un texto
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
	 * M�todo que descodifica un texto
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
