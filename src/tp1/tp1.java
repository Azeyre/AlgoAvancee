package tp1;

import java.util.Arrays;

public class tp1 {

	public static void main(String[] args) {
		Friends f1 = new Friends("Pierre", 43);
		Friends f2 = new Friends("Paul", 20);
		Friends f3 = new Friends("Jacques", 12);
		Friends f4 = new Friends("Remy", 89);
		
		Friends[] tab = {f1, f2, f3, f4};
		System.out.println(Arrays.toString(tab));
		Arrays.sort(tab);
		System.out.println(Arrays.toString(tab));
		
	}
	
	public static int partition(int [] tab, int debut, int fin, int pivot) {
		
		return 0;
	}
	
}
