
class Prueba_ShellSort{ 

	//Metodo que imprime una matriz
	static void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	//Metodo de ordenamiento

	int sort(int arr[]) { 
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
		return 0; 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = {30,200,6,10,65,70,150,4,200,1}; 
		System.out.println("Array Desordenado"); 
		printArray(arr); 

		Prueba_ShellSort ob = new Prueba_ShellSort(); 
		ob.sort(arr); 

		System.out.println("Array Ordenado"); 
		printArray(arr); 
	}  
} 