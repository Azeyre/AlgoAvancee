package tp03;

import java.util.NoSuchElementException;

public class Pile {

	private int tailleMax;
	private Cellule[] contenu;
	private int sommet;

	public Pile(int tailleMax){
		this.tailleMax = tailleMax;
		contenu = new Cellule[tailleMax];
		sommet = -1;
	}

	public boolean isEmpty(){
		return sommet == -1;
	}

	public boolean isFull(){
		return sommet == tailleMax;
	}

	public void push(Cellule t){
		if(!isFull()){
			sommet++;
			contenu[sommet] = t;
		} else throw new IllegalStateException();
	}

	public Cellule peek(){
		if(isEmpty()) throw new NoSuchElementException();
		return contenu[sommet];
	}

	public Cellule pop(){
		if(isEmpty()) throw new NoSuchElementException();
		Cellule temp = contenu[sommet];
		contenu[sommet--] = null;
		return temp;
	}
}
