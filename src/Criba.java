import java.util.Scanner;

/**
 * 
 * @author Juan Gurrea Usó
 * @version 1.0.1
 * Realiza la criba de Erastótenes para hasta el número introducido por el usuario
 */
public class Criba
{
	/**
	 * Constante entera con el 2, el primer número primo
	 */
	private static final int PRIMER_NUMERO_PRIMO = 2;
	
	/**
	 * Variable entera que recibe el tamaño del array
	 */
	private static int tamanioArray;
	
	/**
	 * Array booleano para cribar los números primos
	 */
	private static boolean[] numerosPrimos;
	
	/**
	 * Recibe el número hasta el cuál realizaremos la criba, llamando a los métodos internos necesarios
	 * @param numeroMaximo Número hasta el cuál se realizará la criba
	 * @return Si el número introducido es mayor al primer número primo (2), llama al método rellenarVectorPrimos(). Si es menor, llama al método arrayVacío().
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
	 * Llama al método eliminarNoPrimos();
	 */
	private static void inicializarArray() { 
		
		for (int i = 0; i < tamanioArray; i++) {
			numerosPrimos[i] = true;
		}
		
		eliminarNoPrimos();
	}
	
	/**
	 * Elimima los primeros números no primos
	 */
	private static void eliminarNoPrimos() {
		numerosPrimos[0] = numerosPrimos[1] = false;
	}
	
	/**
	 * Genera un array vacío
	 * @return Devuelve un array vacío
	 */
	private static int[] arrayVacio() {
		return new int[0];
	}
	
	/**
	 * Hace la criba de los números llamando al método interno eliminarMultiplosNumero()
	 */
	private static void cribarNumerosPrimos() {
	
		for (int i = PRIMER_NUMERO_PRIMO; i < Math.sqrt(tamanioArray) + 1; i++) {
			if (numerosPrimos[i]) {
				eliminarMultiplosNumero(i);
			}
		}
	}
	
	/**
	 * Elimina los múltiplos no primos del número introducido
	 * @param numero Número cuyos múltiplos se eliminarán
	 */
	private static void eliminarMultiplosNumero(int numero) {
		for (int i = PRIMER_NUMERO_PRIMO * numero; i < tamanioArray; i += numero)
			numerosPrimos[i] = false;
	}
	
	/**
	 * Cuenta el total de números primos
	 * @return Devuelve un entero con el número total de números primos
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
	 * Rellena un vector con los números primos
	 * @return Devuelve el vector de números primos
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
	 * Imprime el vector de números primos cribados 
	 * @param vector Introduce el vector de números primos a imprimir por pantalla
	 */
	public static void imprimeVectorPrimos(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0) System.out.println();
			System.out.print(vector[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * Ejecutamos el programa desde la clase Main. Se muestra el vector inicial y se llama al método generarPrimos() que realizará la criba. Por último, imprime el vector de primos cribados
	 * @param args Introducimos por consola el número para realizar la criba
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce el número para la criba de Erastótenes:");
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		
		System.out.println("\nVector inicial hasta: " + dato);
		imprimeVectorInicial(vector);
		
		vector=generarPrimos(dato);
		System.out.println("\nVector de primos hasta: " + dato);
		imprimeVectorPrimos(vector);			
	}
}