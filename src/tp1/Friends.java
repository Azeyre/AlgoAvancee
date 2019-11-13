package tp1;

public class Friends implements Comparable<Friends>{

	private String name;
	private int age;
	
	
	public Friends(String name, int age) {
		this.name = name;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Friends [name=" + name + ", age=" + age + "]";
	}


	@Override
	public int compareTo(Friends f) {
		return this.age - f.age;
	}
	
	
	
}
