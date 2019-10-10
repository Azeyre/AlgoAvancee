package tp05;

import java.util.Iterator;
import java.util.LinkedList;

public class Chainage<K,V> implements HashTable<K,V> {

	public static final int DEFAULT_SIZE = 16;
	LinkedList<HashCouple>[] table;
	private int size = 0;

	public Chainage(){
		this(DEFAULT_SIZE);
	}

	public Chainage(int taille){
		table = (LinkedList<HashCouple>[]) new LinkedList[taille];
		for(int i = 0 ; i < taille ; i++){
			table[i] = new LinkedList<HashCouple>();
		}
	}

	@Override
	public V put(K key, V value) {
		HashCouple hc = new HashCouple(key, value);
		table[hc.hashCode() % table.length].add(hc);
		size++;
		return value;
	}

	@Override
	public V get(K key) {
		for(int i = 0 ; i < table.length ; i++){
			Iterator<HashCouple> it = table[i].iterator();
			while(it.hasNext()){
				HashCouple hc = it.next();
				if(hc.getKey().equals(key)) return (V) hc.getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int index;
		for(int i = 0 ; i < table.length ; i++){
			index = 0;
			for(HashCouple hc: table[i]){
				if(hc.getKey().equals(key)){
					V tmp = (V) hc.getValue();
					table[i].remove(index);
					size--;
					return tmp;
				}
				index++;
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

	public String toString(){
		String s = "[";
		for(int i = 0 ; i < table.length ; i++){
			for(HashCouple hc: table[i]){
				s += hc.toString() + ", ";
			}
		}
		return s + "]";
	}
}