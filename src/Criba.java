import java.util.Scanner;

/**
 * 
 * @author Juan Gurrea Us�
 * @version 1.0.1
 * Realiza la criba de Erast�tenes para hasta el n�mero introducido por el usuario
 */
public class Criba
{
	/**
	 * Constante entera con el 2, el primer n�mero primo
	 */
	private static final int PRIMER_NUMERO_PRIMO = 2;
	
	/**
	 * Variable entera que recibe el tama�o del array
	 */
	private static int tamanioArray;
	
	/**
	 * Array booleano para cribar los n�meros primos
	 */
	private static boolean[] numerosPrimos;
	
	/**
	 * Recibe el n�mero hasta el cu�l realizaremos la criba, llamando a los m�todos internos necesarios
	 * @param numeroMaximo N�mero hasta el cu�l se realizar� la criba
	 * @return Si el n�mero introducido es mayor al primer n�mero primo (2), llama al m�todo rellenarVectorPrimos(). Si es menor, llama al m�todo arrayVac�o().
	 * 
	 */
	public static int[] generarPrimos (int numeroMaximo)
	{
		if (numeroMaximo >= PRIMER_NUMERO_PRIMO) {
			
			tamanioArray = numeroMaximo + 1;
			numerosPrimos = new boolean[tamanioArray];
			
			inicializarArray();
			cribarNumerosPrimos();

			return rellenarVectorPrimos();
		} else { // max < 2
			return arrayVacio();
		}		
	}
	
	/**
	 * Inicializa el array
	 * Llama al m�todo eliminarNoPrimos();
	 */
	private static void inicializarArray() { 
		
		for (int i = 0; i < tamanioArray; i++) {
			numerosPrimos[i] = true;
		}
		
		eliminarNoPrimos();
	}
	
	/**
	 * Elimima los primeros n�meros no primos
	 */
	private static void eliminarNoPrimos() {
		numerosPrimos[0] = numerosPrimos[1] = false;
	}
	
	/**
	 * Genera un array vac�o
	 * @return Devuelve un array vac�o
	 */
	private static int[] arrayVacio() {
		return new int[0];
	}
	
	/**
	 * Hace la criba de los n�meros llamando al m�todo interno eliminarMultiplosNumero()
	 */
	private static void cribarNumerosPrimos() {
	
		for (int i = PRIMER_NUMERO_PRIMO; i < Math.sqrt(tamanioArray) + 1; i++) {
			if (numerosPrimos[i]) {
				eliminarMultiplosNumero(i);
			}
		}
	}
	
	/**
	 * Elimina los m�ltiplos no primos del n�mero introducido
	 * @param numero N�mero cuyos m�ltiplos se eliminar�n
	 */
	private static void eliminarMultiplosNumero(int numero) {
		for (int i = PRIMER_NUMERO_PRIMO * numero; i < tamanioArray; i += numero)
			numerosPrimos[i] = false;
	}
	
	/**
	 * Cuenta el total de n�meros primos
	 * @return Devuelve un entero con el n�mero total de n�meros primos
	 */
	private static int contarNumerosPrimos() {
		int cuenta = 0;
		for (int i = 0; i < tamanioArray; i++) {
			if (numerosPrimos[i])
				cuenta++;
		}
		return cuenta;
	}
	
	/**
	 * Rellena un vector con los n�meros primos
	 * @return Devuelve el vector de n�meros primos
	 */
	private static int[] rellenarVectorPrimos() {
		
		int[] primos = new int[contarNumerosPrimos()];
		int indice = 0;
		
		for (int i = 0; i < tamanioArray; i++) {
				if (numerosPrimos[i])
					primos[indice++] = i;
		}
		return primos;
	}
	
	/**
	 * Imprime el vector inicial
	 * @param vector Introduce el vector inicial a imprimir por pantalla
	 */
	public static void imprimeVectorInicial(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0) System.out.println();
			System.out.print(i + 1 + "\t");
		}
		System.out.println();
	}
	
	/**
	 * Imprime el vector de n�meros primos cribados 
	 * @param vector Introduce el vector de n�meros primos a imprimir por pantalla
	 */
	public static void imprimeVectorPrimos(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0) System.out.println();
			System.out.print(vector[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * Ejecutamos el programa desde la clase Main. Se muestra el vector inicial y se llama al m�todo generarPrimos() que realizar� la criba. Por �ltimo, imprime el vector de primos cribados
	 * @param args Introducimos por consola el n�mero para realizar la criba
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce el n�mero para la criba de Erast�tenes:");
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		
		System.out.println("\nVector inicial hasta: " + dato);
		imprimeVectorInicial(vector);
		
		vector=generarPrimos(dato);
		System.out.println("\nVector de primos hasta: " + dato);
		imprimeVectorPrimos(vector);			
	}
}