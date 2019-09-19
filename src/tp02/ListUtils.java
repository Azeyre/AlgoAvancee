package tp02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListUtils {

	List<Integer> genereRdmIntList(){
		List<Integer> list = new ArrayList<>();
		int max = (int) (Math.random() * 30) + 1;
		for(int i = 0 ; i < max ; i++){
			list.add((int) (Math.random() * 100) + 1);
		}
		return list;
	}

	void affiche(List<Integer> l){
		Iterator<Integer> it = l.iterator();
		System.out.print(it.next());
		while(it.hasNext()){
			System.out.print(" -> " + it.next());
		}
		System.out.println();
	}

	void afficheInverse(List<Integer> l){
		ListIterator<Integer> lIt = l.listIterator();
		while(lIt.hasNext()){
			lIt.next();
		}
		System.out.print(lIt.previous());
		while(lIt.hasPrevious()){
			System.out.print(" -> " + lIt.previous());
		}
		System.out.println();
	}

	int somme(List<Integer> l){
		int somme = 0;
		for(Integer i: l){
			somme += i;
		}
		return somme;
	}

	int moyenne(List<Integer> l){
		return somme(l) / l.size();
	}

	int max(List<Integer> l){
		int max = l.get(0);
		for(Integer i: l){
			if(i > max) max = i;
		}
		return max;
	}

	int min(List<Integer> l){
		int min = l.get(0);
		for(Integer i: l){
			if(i < min) min = i;
		}
		return min;
	}

	List<Integer> positions(List<Integer> l, int n){
		if(l.indexOf(n) == -1) return null;

		List<Integer> pos = new ArrayList<>();
		for(int i = 0 ; i < l.size() ; i++){
			if(l.get(i) == n) pos.add(i);
		}
		return pos;
	}

	List<Integer> paire(List<Integer> l){
		List<Integer> paire = new ArrayList<>();
		for(Integer i: l){
			if(i % 2 == 0) paire.add(i);
		}
		return paire;
	}

	boolean estTrie(List<Integer> l){
		for(int i = 0 ; i < l.size() - 1 ; i++){
			if(l.get(i) > l.get(i + 1)) return false;
		}
		return true;
	}

	List<Integer> trie(List<Integer> l){
		int min = 0;
		for(int i = l.size() ; i > 0 ; i--){
			affiche(l);
			min = min(l.subList(0, i));
			l.remove(Integer.valueOf(min));
			l.add(min);
		}
		affiche(l);
		return l;
	}
}