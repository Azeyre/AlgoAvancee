package td03;

import java.util.NoSuchElementException;

public class Verification {

	public static void main(String[] args){
		String s = "{a(b(c[d)]))e}";
		System.out.println(verifDelimStack(s));
	}

	public static boolean verifDelim(String s){
		int ouvert = 0, ferme = 0;
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == '(') ouvert++;
			if(s.charAt(i) == ')') ferme++;
			if(ferme > ouvert) return false;
		}
		if(ouvert != ferme) return false;
		return true;
	}

	public static boolean verifDelimStack(String s){
		Pile p = new Pile(s.length());
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
				p.push(new Truc(s.charAt(i)));
			} else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']'){
				try {
					if(p.peek().getC() == '{' && s.charAt(i) != '}') {
						System.err.println("Erreur à l'indice : " + (i+1) + ", \"}\" manquant.");
						return false;
					}
					if(p.peek().getC() == '(' && s.charAt(i) != ')'){
						System.err.println("Erreur à l'indice : " + (i+1) + ", \")\" manquant.");
						return false;
					}
					if(p.peek().getC() == '[' && s.charAt(i) != ']'){
						System.err.println("Erreur à l'indice : " + (i+1) + ", \"]\" manquant.");
						return false;
					}
					p.pop();
				} catch (NoSuchElementException e){
					System.err.println("Erreur à l'indice : " + (i+1) + ".");
					return false;
				}
			}
		}
		return p.isEmpty();
	}
}
