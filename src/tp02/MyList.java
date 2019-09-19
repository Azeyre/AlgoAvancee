package tp02;

public class MyList<E> {

	Node<E> first;
	Node<E> last;
	private int size = 0;

	public boolean add(E data){
		if(first == null){
			Node<E> node = new Node<E>(data);
			first = node;
			last = node;
		} else {
			Node<E> node = new Node<E>(data);
			last.next = node;
			last = node;
		}
		size++;
		return true;
	}

	public boolean add(int index, E data){
		if(index < 0 || index >= size) return false;
		if(index == 0){
			Node<E> node = new Node<E>(data);
			node.next = first;
			first = node;
			return true;
		}
		int i = 0;
		Node<E> actuel = first;
		Node<E> avant = null;
		while(i < index){
			avant = actuel;
			actuel = actuel.next;
			i++;
		}
		Node<E> node = new Node<E>(data);
		avant.next = node;
		node.next = actuel;
		size++;
		return true;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public String toString(){
		String res = "[";
		Node<E> actuel = first;
		while(actuel != null){
			res += actuel.value;
			actuel = actuel.next;
		}
		return res + "]";
	}

	public void clear() {
		/*Node<E> actuel = first;
		Node<E> temp = first;
		while(actuel != null){
			temp = actuel.next;
			actuel.next = null;
			actuel = temp;
		}*/
		first = null;
		last = null;
	}

	public int size() {
		return size;
	}

	public boolean remove(int i) {
		if(i < 0 || i >= size) throw new IndexOutOfBoundsException();
		if(i == 0){
			first = first.next;
			size--;
		} else {
			Node<E> avant = first;
			Node<E> actuel = first.next;
			for(int j = 1 ; j < i ; j++){
				avant = actuel;
				actuel = actuel.next;
			}
			avant.next = actuel.next;
			size--;
		}
		return true;
	}

	public boolean remove(E e) {
		Node<E> actuel = first;
		Node<E> avant = null;
		while(actuel != null){
			if(actuel.value == e){
				avant.next = actuel.next;
				return true;
			}
			avant = actuel;
			actuel = actuel.next;
		}
		return false;
	}

	public E get(int i) {
		if(i == 0) return first.value;
		else {
			Node<E> actuel = first.next;
			for(int j = 1 ; j < i ; j++){
				actuel = actuel.next;
			}
			return actuel.value;
		}
	}

	public int indexOf(E e) {
		int index = -1;
		int i = 0;
		Node<E> actuel = first;
		while(actuel != null && index == -1){
			if(e.equals(actuel.value)) index = i;
			actuel = actuel.next;
			i++;
		}
		return index;
	}

	public int lastIndexOf(E e) {
		int index = -1;
		int i = 0;
		Node<E> actuel = first;
		while(actuel != null){
			if(e.equals(actuel.value)) index = i;
			actuel = actuel.next;
			i++;
		}
		return index;
	}

	public boolean contains(E e) {
		Node<E> actuel = first;
		while(actuel != null){
			if(e.equals(actuel.value)) return true;
			actuel = actuel.next;
		}
		return false;
	}
}