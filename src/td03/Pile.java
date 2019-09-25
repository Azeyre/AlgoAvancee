package td03;

import java.util.NoSuchElementException;

public class Pile {

	private int tailleMax;
	private Truc[] contenu;
	private int sommet;

	public Pile(int tailleMax){
		this.tailleMax = tailleMax;
		contenu = new Truc[tailleMax];
		sommet = -1;
	}

	public boolean isEmpty(){
		return sommet == -1;
	}

	public boolean isFull(){
		return sommet == tailleMax;
	}

	public void push(Truc t){
		if(!isFull()){
			sommet++;
			contenu[sommet] = t;
		} else throw new IllegalStateException();
	}

	public Truc peek(){
		if(isEmpty()) throw new NoSuchElementException();
		return contenu[sommet];
	}

	public Truc pop(){
		if(isEmpty()) throw new NoSuchElementException();
		Truc temp = contenu[sommet];
		contenu[sommet--] = null;
		return temp;
	}
}
