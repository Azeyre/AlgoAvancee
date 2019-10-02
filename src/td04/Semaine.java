package td04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Semaine {

	public static void main(String[] args){
		Set<Jours> joursOuvert = new HashSet<>();
		for(Jours j: Jours.values()){
			if(j.getJourOuvert()) joursOuvert.add(j);
		}
		afficher(joursOuvert);
	}

	public static void afficher(Set<Jours> s){
		Iterator<Jours> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
}
