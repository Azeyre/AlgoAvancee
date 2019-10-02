package tp04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExoSet {

	public static void main(String[] args){
		Set<Integer> ens1 = new HashSet<>();
		Set<Integer> ens2 = new HashSet<>();

		for(int i = 0 ; i < 10 ; i++){
			ens1.add(rand(0, 10));
			ens2.add(rand(0, 10));
		}
		affichage(ens1);
		affichage(ens2);
		affichage(inter(ens1, ens2));
	}

	private static int rand(int min, int max){
		return (int) (Math.random() * (max - min) + min);
	}

	public static void affichage(Set<Integer> s){
		System.out.print("[" + s.size() + "]{");
		Iterator<Integer> it = s.iterator();
		System.out.print(it.next());
		while(it.hasNext()){
			System.out.print(", " + it.next());
		}
		System.out.print("}\n");
	}

	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
		Set<Integer> s = new HashSet<Integer>();
		s.addAll(set1);
		s.addAll(set2);
		return s;
	}

	public static Set<Integer> inter(Set<Integer> set1, Set<Integer> set2){
		Set<Integer> s = new HashSet<>();
		for(Integer i: set1){
			if(set2.contains(i)) s.add(i);
		}
		return s;
	}

	public static boolean isIn(Set<Integer> set1, Set<Integer> set2){
		if(set1.size() > set2.size()) return false;
		for(Integer i: set1){
			if(!set2.contains(i)) return false;
		}
		return true;
	}

}