package tp05;

public class Adressage<K,V> implements HashTable<K,V> {

	HashCouple[] table;
	private static final int DEFAULT_SIZE = 16;
	private int size;

	public Adressage(){
		this(DEFAULT_SIZE);
	}

	public Adressage(int taille){
		table = new HashCouple[taille];
		size = 0;
	}

	@Override
	public V put(K key, V value) {
		if(size == table.length) throw new IllegalStateException();
		HashCouple hc = new HashCouple(key, value);
		int index = hc.hashCode() % table.length;
		boolean ok = false;
		while(!ok){
			if(index == table.length) index = 0;
			if(table[index] == null){
				table[index] = hc;
				size++;
			}
			index++;
		}
		return value;
	}

	@Override
	public V get(K key) {
		for(int i = 0 ; i < table.length ; i++){
			if(table[i] != null && table[i].getKey().equals(key)) return (V) table[i].getValue();
		}
		return null;
	}

	@Override
	public V remove(K key) {
		for(int i = 0 ; i < table.length ; i++){
			if(table[i] != null && table[i].getKey().equals(key)) {
				V tmp = (V) table[i].getValue();
				table[i] = null;
				size--;
				return tmp;
			}
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public int size() {
		return size;
	}

}