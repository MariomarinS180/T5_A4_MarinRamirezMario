import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class PruebaMetodosOrdenamiento {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		byte opc = e.nextByte(); 
		System.out.println("Elija el metodo de ordenamiento a probar:\n1)ShellSort\n2)QuickSort\n3)Radix");
		opc = e.nextByte(); 
		int mil [] = new int[1000];
		for (int i = 0; i < mil.length; i++) {
		mil[i] = new Random().nextInt(); 
		}
		int diezmil [] = new int[10000];
		for (int i = 0; i < diezmil.length; i++) {
		diezmil[i] = new Random().nextInt(); 
		}
		int cienmil [] = new int[100000];
		for (int i = 0; i < cienmil.length; i++) {
		diezmil[i] = new Random().nextInt(); 
		}
		int millon [] = new int[1000000];
		for (int i = 0; i < millon.length; i++) {
		diezmil[i] = new Random().nextInt(); 
		}
		int milCopia[] = mil.clone(); 
		int diezMilCopia[] = diezmil.clone(); 
		int cienmilCopia [] = cienmil.clone(); 
		int millonCopia [] = millon.clone(); 
		switch (opc) {
		case 1:
			Prueba_ShellSort ob = new Prueba_ShellSort(); 
			ob.sort(mil); 
			System.out.println("Vector de Mil"); 
			ob.printArray(mil);
			System.out.println("Tiempo de Ejecucion --> " + (ob.tInicioShell - ob.tFinShell) + " Nanosegundos");
			System.out.println("======================");
			ob.sort(diezmil); 
			System.out.println("Vector de Diez mil"); 
			ob.printArray(diezmil);
			System.out.println("Tiempo de Ejecucion --> " + (ob.tInicioShell - ob.tFinShell) + " Nanosegundos");
			System.out.println("======================");
			ob.sort(cienmil); 
			System.out.println("Vector de Cien mil"); 
			ob.printArray(cienmil);
			System.out.println("Tiempo de Ejecucion --> " + (ob.tInicioShell - ob.tFinShell)+ " Nanosegundos");
			System.out.println("======================");
			System.out.println("Vector de 1 millon"); 
			ob.printArray(millon);
			System.out.println("Tiempo de Ejecucion --> " + (ob.tInicioShell - ob.tFinShell) + " Nanosegundos");
			System.out.println("======================");			
			break;
		case 2: 
			QuickSort qs = new QuickSort();
			int n = milCopia.length; 
			qs.particion(milCopia, 0, n -1);
			System.out.println("Arreglo de 1000");
			System.out.println(Arrays.toString(milCopia));
			System.out.println("Tiempo de Ejecución --> " + (qs.tQuick - qs.fQuick)+ " Nanosegundos");
			System.out.println("===============================================");
			int n1 = diezMilCopia.length; 
			qs.particion(diezMilCopia, 0, n1 -1);
			System.out.println("Arreglo de 10000");
			System.out.println(Arrays.toString(diezMilCopia));
			System.out.println("Tiempo de Ejecución --> " + (qs.tQuick - qs.fQuick)+ " Nanosegundos");
			System.out.println("===============================================");
			int n2 = cienmilCopia.length; 
			qs.particion(cienmilCopia, 0, n2 -1);
			System.out.println("Arreglo de 100000");
			System.out.println(Arrays.toString(cienmilCopia));
			System.out.println("Tiempo de Ejecución --> " + (qs.tQuick - qs.fQuick)+ " Nanosegundos");
			System.out.println("===============================================");
			int n3 = millonCopia.length; 
			qs.particion(millonCopia, 0, n1 -1);
			System.out.println("Arreglo de 100000");
			System.out.println(Arrays.toString(millonCopia));
			System.out.println("Tiempo de Ejecución --> " + (qs.tQuick - qs.fQuick)+ " Nanosegundos");
			System.out.println("===============================================");
			break; 
		case 3: 
			RADIX r1 = new RADIX(); 
			r1.radix(milCopia);
			System.out.println("Vector de Mil");
			r1.mostrarArreglo(milCopia);
			System.out.println("Tiempo de Ejecucion --> " + (r1.t - r1.f));
			System.out.println("===========================================");
			r1.radix(diezMilCopia);
			System.out.println("Vector de diez mil");
			r1.mostrarArreglo(diezMilCopia);
			System.out.println("Tiempo de Ejecucion --> " + (r1.t - r1.f));
			System.out.println("===========================================");
			r1.radix(cienmilCopia);
			System.out.println("Vector de cien Mil");
			r1.mostrarArreglo(cienmilCopia);
			System.out.println("Tiempo de Ejecucion --> " + (r1.t - r1.f));
			System.out.println("===========================================");
			r1.radix(millonCopia);
			System.out.println("Vector de 1 Millon");
			r1.mostrarArreglo(millonCopia);
			System.out.println("Tiempo de Ejecucion --> " + (r1.t - r1.f));
			System.out.println("===========================================");
			break;
		default: System.out.println("No está en la Lista...");
			break;
		}
		e.close();	
	}
}