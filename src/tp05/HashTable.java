package tp05;

public interface HashTable<K,V> {

	public V put(K key, V value);
	public V get(K key);
	public V remove(K key);
	public boolean contains(K key);
	public int size();

}