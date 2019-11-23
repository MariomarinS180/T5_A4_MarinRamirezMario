class QuickSort {

	long tQuick, fQuick;
	public int particion(int arr[], int menor, int mayor) {
		tQuick = System.nanoTime();
		int pivote = arr[mayor]; 
		int i = (menor - 1); 
		for (int j = 0; j < arr.length; j++) {
			if(arr[j] < pivote) {
				i++; 
				
				int temp = arr[i]; 
				arr[i] = arr[j];
				arr[j] = temp; 
			}
			fQuick = System.nanoTime();
		}
		int temp = arr[i + 1]; 
		arr[i + 1] = arr[mayor]; 
		arr[mayor] = temp; 
		return i + 1;
	}
	void sort (int arr[], int mayor, int menor) {
		if(menor < mayor) {
			int pi = particion(arr, menor, mayor); 
			sort(arr, menor, pi -1);
			sort(arr, pi+1, mayor);
		}
	}
}