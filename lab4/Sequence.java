package lab4;
import java.util.*;

public class Sequence<E> {
	private ArrayList<E> list;
	public Sequence() {
		list = new ArrayList<E>();
	}
	
	public Iterator<E> getItems() { 
		return new Iterator<E>() { 
			private int current = 0;
			public boolean hasNext() { 
				return current < list.size(); 
				}
			public E next() { 
				return list.get(current++); 
			}
		};
	}
}
