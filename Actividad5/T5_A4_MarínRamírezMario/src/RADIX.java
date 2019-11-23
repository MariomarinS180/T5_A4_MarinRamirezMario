public class RADIX {
	long t, f; 
	public void radix(int[] arreglo) {
		int x, i, j;
		for (x = Integer.SIZE - 1; x >= 0; x--) {
			int auxiliar[] = new int[arreglo.length];
			j = 0;
			for (i = 0; i < arreglo.length; i++) {
				boolean mover = arreglo[i] << x >= 0;
				if (x == 0 ? !mover : mover) {
					auxiliar[j] = arreglo[i];
					j++;
				} else {
					arreglo[i - j] = arreglo[i];
				}
			}
			for (i = j; i < auxiliar.length; i++) {
				auxiliar[i] = arreglo[i - j];
			}
			arreglo = auxiliar;
		}
		System.out.println("El arreglo Ordenado es:");
		mostrarArreglo(arreglo);
	}

	public void mostrarArreglo(int[] arreglo) {
		int k = 0;
		for (k = 0; k < arreglo.length; k++) {
			System.out.print("[ " + arreglo[k] + "]");
		}
		System.out.println();
	}
}