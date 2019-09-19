package td02;

public class ListeChaine<E> {

	private Maillon<E> premier = null;

	public ListeChaine(E data){
		premier = new Maillon<E>(data);
	}

	public void ajout(E e){
		Maillon<E> m = new Maillon<E>(e);
		m.setSuivant(premier);
		premier = m;
	}

	public boolean estVide(){
		return premier == null;
	}

	public E supprimePremier(){
		if(estVide()) return null;
		E temp = premier.getDonnees();
		premier = premier.getSuivant();
		return temp;
	}

	public Maillon<E> getPremier(){
		return premier;
	}

	public String toString(){
		Maillon<E> actuel = premier;
		String s = "[";
		while(actuel != null){
			s += actuel.getDonnees().toString() + ", ";
			actuel = actuel.getSuivant();
		}
		return s + "]";
	}

}