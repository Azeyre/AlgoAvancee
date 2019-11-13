package tp1;

public class Counter {

	private int comp;
	private int perm;
	
	public Counter() {
		comp = 0;
		perm = 0;
	}
	
	public void incComp(int n) {
		comp += n;
	}
	
	public void incComp() {
		incComp(1);
	}
	
	public void incPerm(int n) {
		perm += n;
	}
	
	public void incPerm() {
		incPerm(1);
	}
	
	public void reset() {
		comp = 0;
		perm = 0;
	}
	
	@Override
	public String toString() {
		return "(" + comp + ", " + perm +")";
	}
	
}
