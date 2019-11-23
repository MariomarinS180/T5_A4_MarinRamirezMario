
class Prueba_ShellSort{ 

	//Metodo que imprime una matriz
	static void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	//Metodo de ordenamiento
	long tInicioShell, tFinShell;
	int sort(int arr[]) { 
		tInicioShell = System.nanoTime();
		int n = arr.length; 
		for (int gap = n/2; gap > 0; gap /= 2){ 
			for (int i = gap; i < n; i += 1){ 
				int temp = arr[i];
				int j; 
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
					arr[j] = arr[j - gap];
					arr[j] = temp; 
			} 
		} 
		return (int) (tFinShell = System.nanoTime());
	}
	public static void main(String args[]) 
	{ 

	}  
} 