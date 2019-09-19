package td02;

import java.util.Iterator;

public class ListeChaineeIterator<T> implements Iterator<Maillon<T>> {

	private ListeChaine<T> liste;
	private Maillon<T> actuel;

	public ListeChaineeIterator(ListeChaine<T> l) {
		liste = l;
		actuel = liste.getPremier();
	}

	@Override
	public boolean hasNext() {
		return actuel.getSuivant() != null;
	}

	@Override
	public Maillon<T> next() {
		Maillon<T> temp = actuel;
		actuel = actuel.getSuivant();
		return temp;
	}

}
