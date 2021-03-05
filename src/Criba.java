import java.util.Scanner;

public class Criba
{
	
	private static final int PRIMER_NUMERO_PRIMO = 2;
	private static int tamanioArray;
	private static boolean[] numerosPrimos;
	
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
	
	private static void inicializarArray() { 
		
		for (int i = 0; i < tamanioArray; i++) {
			numerosPrimos[i] = true;
		}
		
		eliminarNoPrimos();
	}
	
	private static void eliminarNoPrimos() {
		numerosPrimos[0] = numerosPrimos[1] = false;
	}
	
	
	private static int[] arrayVacio() {
		return new int[0];
	}
	
	private static void cribarNumerosPrimos() {
	
		for (int i = PRIMER_NUMERO_PRIMO; i < Math.sqrt(tamanioArray) + 1; i++) {
			if (numerosPrimos[i]) {
				eliminarMultiplosNumero(i);
			}
		}
	}
	

	private static void eliminarMultiplosNumero(int numero) {
		for (int i = PRIMER_NUMERO_PRIMO * numero; i < tamanioArray; i += numero)
			numerosPrimos[i] = false;
	}
	
	private static int contarNumerosPrimos() {
		int cuenta = 0;
		for (int i = 0; i < tamanioArray; i++) {
			if (numerosPrimos[i])
				cuenta++;
		}
		return cuenta;
	}
	
	private static int[] rellenarVectorPrimos() {
		
		int[] primos = new int[contarNumerosPrimos()];
		int indice = 0;
		
		for (int i = 0; i < tamanioArray; i++) {
				if (numerosPrimos[i])
					primos[indice++] = i;
		}
		return primos;
	}
	
	public static void imprimeVectorInicial(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0) System.out.println();
			System.out.print(i + 1 + "\t");
		}
		System.out.println();
	}
	
	public static void imprimeVectorPrimos(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0) System.out.println();
			System.out.print(vector[i] + "\t");
		}
		System.out.println();
	}
	
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