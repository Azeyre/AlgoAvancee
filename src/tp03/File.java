package tp03;

public class File {


	private int tailleMax;
	private Cellule[] contenu;
	private int queue;
	private int tete;
	private int nItems;

	public File(int taille){
		tailleMax = taille;
		contenu = new Cellule[taille];

	}
}
