package tp1;

import java.util.Random;

/**
 * SDD Seance TP 1 :
 *
 * @author <a href="mailto:Frederic.Guyomarch@univ-lille1.fr">FrÃ©dÃ©ric Guyomarch</a>
 * IUT-A, Universite de Lille, Sciences et TEchnologies
 */
public class Sort {
	
	private static Counter counter = new Counter();
	
    public static int [] generateRdmIntArray(int n, int min, int max){
		int[] tab = new int[n];
		Random r = new Random();
		for (int i = 0; i < tab.length; i++) {
			tab[i] = r.nextInt(max - min) + min;
		}
    	return tab;
    }


    public static void insertSort(int [] tab) {
    	System.out.println("-----------------\n   InsertSort\n-----------------");
    	System.out.println("Avant : ");
    	printArray(tab);
        for (int i = 1; i < tab.length; ++i) { 
            int key = tab[i]; 
            int j = i - 1; 
            while (j >= 0 && tab[j] > key) { 
                tab[j + 1] = tab[j]; 
                j = j - 1;
                counter.incPerm();
                counter.incComp();
            } 
            tab[j + 1] = key; 
        }
    	System.out.println("\nAprès : ");
    	printArray(tab);
        System.out.println("\n(Comparaison, Permutation) -> " + counter);
        counter.reset();
    }

    @SuppressWarnings("unused")
	public static int indiceMin(int[] tab, int iBeg, int iEnd) {
    	int idx = iBeg;
    	int value = tab[iBeg];
    	for (int i = iBeg+1; i < iEnd; i++) {
			if(tab[i] < tab[idx]) {
				idx = i;
				value = tab[idx];
				counter.incComp();
			}
		}
    	return idx;
    }
    
    public static void selectSort(int [] tab){
    	System.out.println("-----------------\n   SelectSort\n-----------------");
    	System.out.println("Avant : ");
    	printArray(tab);
    	for (int i = 0; i < tab.length; i++) {
			int idx = indiceMin(tab, i, tab.length);
			swap(tab, i, idx);
		}
    	System.out.println("\nAprès : ");
    	printArray(tab);
        System.out.println("\n(Comparaison, Permutation) -> " + counter);
        counter.reset();
    }

    public static void printArray(int [] tab){
    	for (int i : tab) {
			System.out.print(i + ", ");
		}
    }

    public static void swap(int [] tab, int idx, int idx2){
    	int temp = tab[idx];
    	tab[idx] = tab[idx2];
    	tab[idx2] = temp;
    	counter.incPerm();
    }

    public static void bubbleSort(int [] tab){
    	System.out.println("-----------------\n   BubbleSort\n-----------------");
    	System.out.println("Avant : ");
    	printArray(tab);
        int n = tab.length;  
        for(int i=0; i < n; i++){  
	        for(int j=1; j < (n-i); j++){
	        	counter.incComp();
		        if(tab[j-1] > tab[j]){   
		        	swap(tab, j, j-1);
		        }                   
	        }  
        }
    	System.out.println("\nAprès : ");
    	printArray(tab);
        System.out.println("\n(Comparaison, Permutation) -> " + counter);
        counter.reset();
    }


}

