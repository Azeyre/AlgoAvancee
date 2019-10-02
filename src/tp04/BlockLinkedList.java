package tp04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BlockLinkedList<E> implements List<E> {

	public static void main(String[] args){
		BlockLinkedList<String> list = new BlockLinkedList<>(4);
		List<String> ret = new ArrayList<>();
		ret.add("B");
		ret.add("C");
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add(0, "Z");
		list.set(0, "H");
		list.add("B");
		System.out.println(list.toString());
		System.out.println(list.contains("A"));
		System.out.println(list.lastIndexOf("B"));
		list.retainAll(ret);
		System.out.println(list.toString());
	}

	public class ArrayNode<E> {
		ArrayNode<E> next;
		ArrayList<E> list;
		int max;

		public ArrayNode(int n){
			max = n;
			list = new ArrayList<>(n);
		}
	}

	private final static int ARRAY_DEFAULT_SIZE = 4;
	private ArrayNode<E> first;

	public BlockLinkedList(){
		this(ARRAY_DEFAULT_SIZE);
	}

	public BlockLinkedList(int n){
		if(n % 2 == 1) throw new IllegalArgumentException();
		first = new ArrayNode<E>(n);
	}

	@Override
	public boolean add(E e) {
		ArrayNode<E> actuel = first;
		while(actuel.next != null)
			actuel = actuel.next;

		if(actuel.list.size() == actuel.max){
			ArrayNode<E> node = new ArrayNode<>(actuel.max);
			ArrayNode<E> tmp = actuel.next;
			for(int k = actuel.max / 2 ; k < actuel.list.size() ; k++){
				node.list.add(actuel.list.get(k));
			}
			for(int k = actuel.list.size() - 1 ; k >= actuel.max / 2  ; k--){
				actuel.list.remove(k);
			}
			node.list.add(e);
			actuel.next = node;
			node.next = tmp;
		} else {
			actuel.list.add(e);
		}
		return false;
	}

	@Override
	public void add(int i, E e) {
		if(i < 0 || i >= size()) throw new IndexOutOfBoundsException();
		int index = 0;
		ArrayNode<E> actuel = first;
		while(actuel != null){
			for(E e1: actuel.list){
				if(index == i){
					if(actuel.list.size() == actuel.max){
						ArrayNode<E> node = new ArrayNode<E>(actuel.max);
						ArrayNode<E> tmp = actuel.next;
						for(int k = actuel.max / 2 ; k < actuel.list.size() ; k++){
							node.list.add(actuel.list.get(k));
						}
						for(int k = actuel.list.size() - 1 ; k >= actuel.max / 2  ; k--){
							actuel.list.remove(k);
						}
						actuel.list.add(i % actuel.max, e);
						actuel.next = node;
						node.next = tmp;
					} else {
						actuel.list.add(i % actuel.max, e);
					}
					return;
				}
				index++;
			}
			actuel = actuel.next;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(E e: c)	add(e);
		return true;
	}

	@Override
	public boolean addAll(int idx, Collection<? extends E> c) {
		for(E e: c){
			add(idx, e);
			idx++;
		}
		return true;
	}

	@Override
	public void clear() {
		first = null;
	}

	@Override
	public boolean contains(Object o) {
		return localisation((E) o) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Iterator<?> it = c.iterator();
		while(it.hasNext()){
			if(!contains(it.next())) return false;
		}
		return true;
	}

	@Override
	public E get(int i) {
		if(i < 0 || i >= size()) return null;
		int index = 0;
		ArrayNode<E> actuel = first;
		while(actuel != null){
			for(E e: actuel.list){
				if(index == i) return e;
				index++;
			}
			actuel = actuel.next;
		}
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return localisation((E) o);
	}

	@Override
	public boolean isEmpty() {
		if(first == null) return true;
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = 0;
		ArrayNode<E> actuel = first;
		int indexTmp = -1;
		while(actuel != null){
			for(E e1: actuel.list){
				if(e1.equals((E) o)){
					indexTmp = index;
				}
				index++;
			}
			actuel = actuel.next;
		}
		return indexTmp;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		ArrayNode<E> actuel = first;
		while(actuel != null) {
			for(int k = 0 ; k < actuel.list.size() ; k++){
				if(actuel.list.get(k).equals((E) o)) {
					actuel.list.remove(k);
					if(actuel.next != null && actuel.next.list.size() + actuel.list.size() <= actuel.max) {
						actuel.list.addAll(actuel.next.list);
						actuel.next = actuel.next.next;
					}
				}
			}
			actuel = actuel.next;
		}
		return false;
	}

	@Override
	public E remove(int idx) {
		int index = 0;
		ArrayNode<E> actuel = first;
		while(actuel != null) {
			for(int k = 0 ; k < actuel.list.size() ; k++){
				if(index == idx) {
					E tmp = actuel.list.get(k);
					actuel.list.remove(k);
					if(actuel.next != null && actuel.next.list.size() + actuel.list.size() <= actuel.max) {
						actuel.list.addAll(actuel.next.list);
						actuel.next = actuel.next.next;
					}
					return tmp;
				}
				index++;
			}
			actuel = actuel.next;
		}
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object o: c) remove(o);
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		ArrayNode<E> actuel = first;
		boolean modif = false, m = false;
		for(Object o: c){
			actuel = first;
			m = false;
			while(actuel != null && !m) {
				for(int k = 0 ; k < actuel.list.size() ; k++){
					if(!actuel.list.get(k).equals((E) o)) {
						actuel.list.remove(k);
						if(actuel.next != null && actuel.next.list.size() + actuel.list.size() <= actuel.max) {
							actuel.list.addAll(actuel.next.list);
							actuel.next = actuel.next.next;
						}
						modif = true;
						m = true;
					}
				}
				actuel = actuel.next;
			}
		}
		return modif;
	}

	@Override
	public E set(int i, E e1) {
		if(i < 0 || i >= size()) return null;
		int index = 0;
		ArrayNode<E> actuel = first;
		while(actuel != null){
			for(int k = 0 ; k < actuel.list.size() ; k++){
				if(index == i){
					actuel.list.set(k, e1);
					return e1;
				}
				index++;
			}
			actuel = actuel.next;
		}
		return null;
	}

	@Override
	public int size() {
		int size = 0;
		ArrayNode<E> actuel = first;
		while(actuel != null){
			for(E e: actuel.list){
				size++;
			}
			actuel = actuel.next;
		}
		return size;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString(){
		String s = "[";
		ArrayNode<E> actuel = first;
		for(int i = 0 ; i < actuel.list.size() ; i++){
			if(i != 0) s += ", ";
			s += actuel.list.get(i);
		}
		actuel = actuel.next;
		while(actuel != null){
			for(int i = 0 ; i < actuel.list.size() ; i++){
				s += ", " + actuel.list.get(i);
			}
			actuel = actuel.next;
		}
		return s + "]";
	}

	private int localisation(E e){
		int index = 0;
		ArrayNode<E> actuel = first;
		while(actuel != null){
			for(E e1: actuel.list){
				if(e1.equals(e)) return index;
				index++;
			}
			actuel = actuel.next;
		}
		return -1;
	}

}