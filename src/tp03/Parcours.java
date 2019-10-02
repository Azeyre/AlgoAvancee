package tp03;

import java.util.LinkedList;

public class Parcours {

	public static void main(String[] args){
		int tours = 0;
		boolean fini = false;
		Labyrinthe l = new Labyrinthe();
		//Pile stack = new Pile(l.n() * l.n());
		LinkedList<Cellule> stack = new LinkedList<>();
		Cellule debut = new Cellule(0,1);
		Cellule fin = new Cellule(40, 39);
		//System.out.println(fin.toString());
		stack.offer(debut);
		l.poserMarque(debut.getX(), debut.getY());

		while(!stack.isEmpty() && !fini){
			//System.out.println(stack.peek().toString());
			if(stack.peek().equals(fin)){
				System.out.println("Sortie trouvée.");
				fini = true;
			} else {
				Cellule temp = voisine(stack.peek(), l);
				if(temp != null){
					stack.offer(temp);
					l.poserMarque(temp.getX(), temp.getY());
				}  else {
					l.poserMarqueRetour(stack.peek().getX(), stack.peek().getY());
					stack.poll();
				}
			}
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {}
		}
		System.out.println(tours);
	}

	private static Cellule voisine(Cellule courante, Labyrinthe l){
		if(courante.getX() + 1 <= l.n() && !l.estMarque(courante.getX() + 1, courante.getY()) &&
				!l.estMur(courante.getX() + 1, courante.getY())){
			return new Cellule(courante.getX() + 1, courante.getY());
		}

		if(courante.getX() - 1 >= 0 && !l.estMarque(courante.getX() - 1, courante.getY()) &&
				!l.estMur(courante.getX() - 1, courante.getY())){
			return new Cellule(courante.getX() - 1, courante.getY());
		}

		if(courante.getY() + 1 <= l.n() && !l.estMarque(courante.getX(), courante.getY() + 1) &&
				!l.estMur(courante.getX(), courante.getY() + 1)){
			return new Cellule(courante.getX(), courante.getY() + 1);
		}

		if(courante.getY() - 1 >= 0 && !l.estMarque(courante.getX(), courante.getY() - 1) &&
				!l.estMur(courante.getX(), courante.getY() - 1)){
			return new Cellule(courante.getX(), courante.getY() - 1);
		}
		return null;
	}

}
