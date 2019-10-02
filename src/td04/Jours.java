package td04;

public enum Jours {

	LUNDI(true),
	MARDI(true),
	MERCREDI(true),
	JEUDI(true),
	VENDREDI(true),
	SAMEDI(false),
	DIMANCHE(false);

	private boolean jourOuvert;
	private String s;

	private Jours(boolean jourOuvert){
		this.jourOuvert = jourOuvert;
		s = this.name();
	}

	public boolean getJourOuvert(){
		return jourOuvert;
	}

	public String toString(){
		return s;
	}

}
