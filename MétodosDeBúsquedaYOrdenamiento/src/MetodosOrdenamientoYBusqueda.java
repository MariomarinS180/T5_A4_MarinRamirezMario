import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
class MetodosOrdenamiento {
	long tInicio = 0;
	long comparaciones = 0;
	long intercambios = 0;
	long recorridos = 0;
	public void ordenamientoBurbuja1(int arr[]) {
		tInicio = System.nanoTime();
		for (int i = 1; i < arr.length; i++) {
			recorridos++;
			for (int j = 0; j < arr.length - i; j++) {
				recorridos++;
				comparaciones++;
				if (arr[j] > arr[j + 1]) {
					int aux = arr[j];
					intercambios++;
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}
		}
	}
	public void ordenamientoBurbuja2(int[] arr) {
		tInicio  = System.nanoTime();
		int i = 1;
		boolean ordenado = false;
		while ((i < arr.length) || (ordenado == false)) {
			i = i + 1;
			ordenado = true;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					ordenado = false;
					intercambios ++;
					int aux = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}
		}
	}
	public void ordenamientoBurbuja3(int[] arr) {
		tInicio  = System.nanoTime();
		int i = 1;
		boolean ordenado = true;
		do {
			i = i + 1;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					ordenado = false;
					intercambios ++;
					int aux = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}

		} while (i < arr.length || ordenado == true);
	}
	//SHELSORT
	public int shellSort(int arr[]) {
		tInicio  = System.nanoTime();
		int n = arr.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			recorridos++;
			for (int i = gap; i < n; i += 1) {
				recorridos++;
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
					recorridos++;
					intercambios ++;
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}
		return 0;
	}

	//INTERCALACIÓN

	public void intercalacion(int[] arregloA, int[] arregloB) {
		tInicio  = System.nanoTime();
		int i, j, k;
		int arregloC[] = new int[arregloA.length + arregloB.length];
		// Repetir minetras los arreglos A y B tengan elementos a comparar
		for (i = j = k = 0; i < arregloA.length && j < arregloB.length; k++) {
			recorridos++;
			comparaciones++;
			if (arregloA[i] < arregloB[j]) {
				intercambios++;
				arregloC[k] = arregloA[i];
				i++;

			} else {
				intercambios++;
				arregloC[k] = arregloB[j];
				j++;
			}

		}
		// Añadir sobrantes del arreglo A en caso de haberlos
		for (; i < arregloA.length; i++, k++) {
			recorridos++;
			intercambios++;
			arregloC[k] = arregloA[i];
		}
		// Añadir sobrantes del arreglo B en caso de haberlos
		for (; j < arregloB.length; j++, k++) {
			recorridos++;
			intercambios++;
			arregloC[k] = arregloA[j];
		}
	}
	//RADIX SORT
	public void radixSort(int arr[]) {
		tInicio  = System.nanoTime();
		
		int x, i, j;
		for (x = Integer.SIZE - 1; x >= 0; x--) {
			recorridos++;
			int aux[] = new int[arr.length];
			j = 0;
			for (i = 0; i < arr.length; i++) {
				recorridos++;

				boolean mover = arr[i] << x > 0;

				comparaciones++;
				if (x == 0 ? !mover : mover) {
					intercambios ++;
					aux[j] = arr[i];
					j++;

				} else {
					intercambios ++;
					arr[i - j] = arr[i];

				}

			}
			for (i = j; i < aux.length; i++) {
				recorridos++;
				intercambios ++;
				aux[i] = arr[i] - j;
			}
			arr = aux;
		}
	}
	//MEZCLA DIRECTA
	public int[] mezclaDirecta(int[] arreglo) {
		tInicio  = System.nanoTime(); 
		int i, j, k;

		comparaciones++;
		if (arreglo.length > 1) {

			int nElementosIzq = arreglo.length / 2;
			int nElementosDer = arreglo.length - nElementosIzq;
			int arregloIzq[] = new int[nElementosIzq];
			int arregloDer[] = new int[nElementosDer];

			// Cepiando los elementos al primer arreglo
			for (i = 0; i < nElementosIzq; i++) {
				intercambios++;
				recorridos++;
				arregloIzq[i] = arreglo[i];

			}
			// Copiando los elementos al segundo arreglo
			for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
				intercambios++;
				recorridos++;
				arregloDer[i - nElementosIzq] = arreglo[i];

			}
			// Recursividad
			arregloIzq = mezclaDirecta(arregloIzq);
			arregloDer = mezclaDirecta(arregloDer);

			i = 0;
			j = 0;
			k = 0;

			while (arregloIzq.length != j && arregloDer.length != k) {
				recorridos++;
				comparaciones++;
				if (arregloIzq[j] < arregloDer[k]) {
					intercambios++;
					arreglo[i] = arregloIzq[j];
					i++;
					j++;

				} else {
					arreglo[i] = arregloDer[k];
					intercambios++;
					i++;
					k++;

				}

			}
			// Arreglo final
			while (arregloIzq.length != j) {
				recorridos++;
				intercambios++;
				arreglo[i] = arregloIzq[j];
				i++;
				j++;

			}
			while (arregloDer.length != k) {
				recorridos++;
				intercambios++;
				arreglo[i] = arregloDer[k];
				i++;
				k++;

			}
		} // fin del c++; if

		return arreglo;
	}
	//QUICK SORT
	public void quickSort(int arr[], int menor, int mayor) {
		tInicio = System.nanoTime(); 
		comparaciones++;
		if (menor < mayor) {

			int pi = particion(arr, menor, mayor);

			quickSort(arr, menor, pi - 1);
			quickSort(arr, pi + 1, mayor);
		}
	}

	public int particion(int arr[], int menor, int mayor) {
		int pivot = arr[mayor];
		int i = (menor - 1);

		for (int j = menor; j < mayor; j++) {
			recorridos++;
			comparaciones++;
			if (arr[j] < pivot) {
				i++;
				intercambios ++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
		}

		int temp = arr[i + 1];
		intercambios++;
		arr[i + 1] = arr[mayor];
		arr[mayor] = temp;

		return i + 1;
	}

	//MEZCLA NATURAL
	
	public void Mezclanatural(int[] arreglo) {
		tInicio = System.nanoTime(); 
		int izquierda=0,izq=0,derecha=arreglo.length-1,der=derecha;
		boolean ordenado=false;
		do {
			ordenado=true;
			izquierda=0;
			while (izquierda<derecha){
				izq=izquierda;
				while(izq<derecha&&arreglo[izq]<=arreglo[izq+1]) {
					izq++;
				}
				der=izq+1;
				while(der==derecha-1||der<derecha&&arreglo[der]<=arreglo[der+1]) {
					der++;	
				}
				if (der<=derecha) {
					mezclaDirecta2(arreglo);
					ordenado=false;
				}
				izquierda=izq;
				
			}
		}while(!ordenado);
		
		}
	
	public void mezclaDirecta2(int[] arreglo) {
		tInicio = System.nanoTime(); 
		int i,j,k;
		if (arreglo.length>1) {
			int nElementosIzq=arreglo.length/2;
			int nElementosDer=arreglo.length-nElementosIzq;
			int arregloIzq[]=new int [nElementosIzq];
			int arregloDer[]=new int [nElementosDer];
			for (i = 0; i < nElementosIzq; i++) {
				arregloIzq[i]=arreglo[i];
			}
			for (i = nElementosIzq; i < nElementosIzq+nElementosDer; i++) {
				arregloDer[i-nElementosIzq]=arreglo[i];
			}
			arregloIzq=mezclaDirecta(arregloIzq);
			arregloDer=mezclaDirecta(arregloDer);
			i=0;
			j=0;
			k=0;
			while(arregloIzq.length!=j&&arregloDer.length!=k) {
				if(arregloIzq[j]<arregloDer[k]) {
					arreglo[i]=arregloIzq[j];
					i++;
					j++;
				}else {
					arreglo[i]=arregloDer[k];
					i++;
					k++;
				}
			}
			while(arregloIzq.length!=j) {
				arreglo[i]=arregloIzq[j];
				i++;
				j++;
			}
			while(arregloDer.length!=k) {
				arreglo[i]=arregloDer[k];
				i++;
				k++;
			}
		}
	}
	
	
}

class MetodosBusqueda{
	//BUSQUEDA BINARIA 
	long tInicio1 = 0; 
	long comparaciones1 = 0;
	long intercambios1 = 0;
	long recorridos1 = 0;
	int busquedaBinaria(int vector[], int posicionIzq, int posicionDer, int elementoA_Buscar) { 
		tInicio1 = System.nanoTime();     
		for (int i = 0; i < vector.length; i++) {
			comparaciones1++;
		}
		for (int i = 0; i < vector.length; i++) {
		recorridos1++;
		if (posicionDer >= posicionIzq) { 
			intercambios1++;
	            int mitad = posicionIzq + (posicionDer - posicionIzq) / 2; 
	            // Si el elemento está presente en el
	            // medio en sí
	            if (vector[mitad] == elementoA_Buscar) 
	                return mitad; 
	            // Si el elemento es más pequeño que el medio, entonces 
	            // solo puede estar presente en el subconjunto izquierdo
	            if (vector[mitad] > elementoA_Buscar) 
	                return busquedaBinaria(vector, posicionIzq, mitad - 1, elementoA_Buscar); 
	            //De lo contrario, el elemento solo puede 
	            //estar presente en la submatriz derecha
	            return busquedaBinaria(vector, mitad + 1, posicionDer, elementoA_Buscar); 
	        }
	}//fin del for
	        //Llegamos aquí cuando el elemento no está presente en la matriz
	        return -1;
	
	        
	   }
	//BUSQUEDA SECUENCIAL
	public  int busquedaSecuencial(int []arreglo,int dato){
		tInicio1 = System.nanoTime(); 
		for (int i = 0; i < arreglo.length; i++) {
			comparaciones1++;
		}
		
		int posicion = -1;
		  for(int i = 0; i < arreglo.length; i++){
		      if(arreglo[i] == dato){
		    posicion = i;
		    break;//
		   }
		      intercambios1++;
		 }recorridos1++;
		return posicion;
	}
}//class

public class MetodosOrdenamientoYBusqueda {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		boolean verdad = true;
		MetodosOrdenamiento ob = new MetodosOrdenamiento();
		MetodosBusqueda mb = new MetodosBusqueda();
		System.out.println("Ingrese la Cantidad de Valores.\nEjemplos:\n1,000\n10,000\n100,000\n1,000,000");
		int num = e.nextInt();
		int vector[] = new int[num];
		Random r = new Random();
		Random b = new Random(); 
		for (int i = 0; i < vector.length; i++) {
			vector[i] = r.nextInt(100);
		}
		int n = vector.length;
		int vectorCopia[] = Arrays.copyOf(vector, vector.length);	
		do {
			ob.comparaciones = 0;
			ob.intercambios = 0;
			ob.recorridos = 0;
			ob.tInicio = 0;
			//Busqueda
			mb.comparaciones1 = 0; 
			mb.intercambios1 = 0; 
			mb.recorridos1 = 0; 
			mb.tInicio1 = 0;
			
			vector = Arrays.copyOf(vectorCopia, vectorCopia.length);
			System.out.println("Seleccione un Método de Ordenamiento o Búsqueda");
			System.out.println("1.- Metodo Burbuja");
			System.out.println("2.- Metodo QuickSort");
			System.out.println("3.- Metodo ShellSort");
			System.out.println("4.- Metodo RadixSort");
			System.out.println("5.- Metodo Intercalación");
			System.out.println("6.- Metodo Mezcla Directa");
			System.out.println("7.- Metodo Mezcla Natural");
			System.out.println("8.- Metodo Busqueda Binaria");
			System.out.println("9.- Búsqueda Secuencial");
			System.out.println("10.- Metodo Busqueda por Funciones Hash\n11.- Salir");
			byte op = e.nextByte();
			switch (op) {
			case 1:
				System.out.println(" === Ordenación por los Métodos de Burbuja");
				System.out.println(" === METODO BURBUJA 1 === ");
				System.out.println("Vector " + Arrays.toString(vector));
				ob.ordenamientoBurbuja1(vector);
				System.out.println("Tiempo de Ejecución: " + (System.nanoTime() - ob.tInicio)+" Nanosegundos");
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Vector ordenado " + Arrays.toString(vector));
				System.out.println("==========================");
				System.out.println(" === METODO BURBUJA 2 === ");
				System.out.println("Vector " + Arrays.toString(vectorCopia));
				ob.ordenamientoBurbuja2(vectorCopia);
				System.out.println("Tiempo de Ejecución: " + (System.nanoTime() - ob.tInicio)+ "Nanosegundos");
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Vector ordenado " + Arrays.toString(vectorCopia));
				System.out.println("==========================");
				break;
			case 2:
				System.out.println("Método QuickSort");
				ob.tInicio = System.nanoTime();
				System.out.println("Veector " + Arrays.toString(vectorCopia));
				ob.quickSort(vectorCopia, 0, n - 1);
				System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.tInicio)+" Nanosegundos");
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Vector Ordenado: " + Arrays.toString(vectorCopia));
				break;
			case 3:
				System.out.println("Método ShellSort");
				System.out.println("Vector " + Arrays.toString(vectorCopia));
				ob.shellSort(vectorCopia);
				System.out.println("Tiempo de ejecución: " + (System.nanoTime() - ob.tInicio)+" Nanosegundos");
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Vector Ordenado: " + Arrays.toString(vectorCopia));
				break;
			case 4:
				System.out.println("Método Radix");
				System.out.println("Vector " + Arrays.toString(vectorCopia));
				ob.radixSort(vectorCopia);
				System.out.println("Tiempo de Ejecución: " + (System.nanoTime() - ob.tInicio)+ " Nanosegundos");
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Vector Ordenado: " + Arrays.toString(vectorCopia));
				break;
			case 5:
				System.out.println("Método Intercalacion");
				System.out.println("Vector " + Arrays.toString(vectorCopia) );
				ob.intercalacion(vectorCopia, vectorCopia);
				System.out.println("Tiempo de Ejecución " + (System.nanoTime() - ob.tInicio)+ " Nanosegundos");
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Vector Ordenado: " +Arrays.toString(vectorCopia));
				break;
			case 6:
				System.out.println("Método Mezcla Directa");
				ob.tInicio = System.nanoTime();
				System.out.println("Vector " + Arrays.toString(vectorCopia) );
				ob.mezclaDirecta(vectorCopia);
				System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.tInicio));
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Arreglo Ordenado: " + Arrays.toString(vectorCopia));
				break;
			case 7:
				System.out.println("Método Mezcla Natural");
				System.out.println("Vector " + Arrays.toString(vectorCopia) );
				ob.Mezclanatural(vectorCopia);
				System.out.println("Arreglo ordenado");
				System.out.println("Comparaciones: " + ob.comparaciones);
				System.out.println("Recorridos: " + ob.recorridos);
				System.out.println("Intercambios: " + ob.intercambios);
				System.out.println("Vector Ordenado " + Arrays.toString(vectorCopia) );
				break;
			case 8:
				int buscar = 0;
				System.out.println("Ordenando por el metodo Busqueda Binaria");
				System.out.println("Cargando vector con 100 Números.");
				int vector_BB[] = new int [10]; 
				for (int i = 0; i < vector_BB.length; i++) {
					vector_BB[i] = r.nextInt(100);
				}
				
				System.out.println("Vector cargado...");
				System.out.println("Ingrese un numero para verificar si está en el arreglo: ");
				buscar = e.nextInt();
				int n1 = vector_BB.length; 
				int resultado = mb.busquedaBinaria(vector_BB, 0, n, buscar);
				if(resultado == -1) {
					System.out.println("El número " +buscar+" no está en el vector.");
				}else {
					System.out.println("Numero encontrado en la posición " +resultado+" del vector");
				}
				System.out.println("Le mostramos el Vector " +Arrays.toString(vector_BB));
				System.out.println("Tiempo de ejecución: " + (System.nanoTime() - mb.tInicio1)+ " Nanosegundos");
				System.out.println("Comparaciones: " + mb.comparaciones1);
				System.out.println("Recorridos: " + mb.recorridos1);
				System.out.println("Intercambios: " + mb.intercambios1);
				break;
			case 9:
				System.out.println("Busqueda Secuencial");
				int buscar1 = 0;
				System.out.println("Ordenando por el metodo Busqueda Secuencial");
				System.out.println("Cargando vector con 100 Números.");
				int vector_BB1[] = new int [10]; 
				for (int i = 0; i < vector_BB1.length; i++) {
					vector_BB1[i] = r.nextInt(100);
				}
				System.out.println("Vector cargado...");
				System.out.println("Ingrese un numero para verificar si está en el arreglo: ");
				buscar1 = e.nextInt();
				int res = mb.busquedaSecuencial(vector_BB1, buscar1); 
				if(res == -1) {
					System.out.println("El número " +buscar1+" no se encontró en el arreglo");
				}else {
					System.out.println("Numero encontrado en la posición "+res+" del vector.");
				}
				System.out.println("Le mostramos el Vector " +Arrays.toString(vector_BB1));
				System.out.println("Tiempo de ejecución: " + (System.nanoTime() - mb.tInicio1)+ " Nanosegundos");
				System.out.println("Comparaciones: " + mb.comparaciones1);
				System.out.println("Recorridos: " + mb.recorridos1);
				System.out.println("Intercambios: " + mb.intercambios1);				
				break;
			case 10: System.out.println("Método de Busca por Funciones Hash");
				break;
			case 11:
				System.out.println("Salió...");
				verdad = false;
				break;
			default:System.out.println("No está en la lista");
				break;
			}
			System.out.println();
		} while (verdad);
		e.close();
	}
}