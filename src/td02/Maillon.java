package td02;

public class Maillon<E> {

	private E donnees;
	private Maillon<E> suivant;

	public Maillon(E donnees){
		this.donnees = donnees;
	}

	public void setSuivant(Maillon<E> m){
		suivant = m;
	}

	public Maillon<E> getSuivant(){
		return suivant;
	}

	public E getDonnees(){
		return donnees;
	}

}
