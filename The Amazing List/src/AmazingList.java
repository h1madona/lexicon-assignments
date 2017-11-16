import java.util.Arrays;

public class AmazingList<T> {
	private Object[] elements = new Object[0];
	private int numOfElements = 0;
	
	
	public Object[] getElements() {
		return elements;
	}
	public int size() {
		return numOfElements;
	}

	public void add(T element) {
		numOfElements++;
		elements = Arrays.copyOf(elements, numOfElements);
		elements[numOfElements-1] = element;
		
	}

	public void remove(int index) {
		numOfElements--;
		Object[] before = Arrays.copyOfRange(elements, 0, index);
		Object[] after = Arrays.copyOfRange(elements, index+1, elements.length);
		elements = new Object[numOfElements];
		System.arraycopy(before, 0, elements, 0, before.length);
		System.arraycopy(after, 0, elements, before.length, after.length);
	}
	
	
	public boolean contains(T element) {
		for(int i=0; i<elements.length; i++) {
			if(elements[i].equals(element))
				return true;
		}
		return false;
	}
	
	public int indexOf(T element) {
		for(int i=0; i<elements.length; i++) {
			if(elements[i].equals(element))
				return i;
		}
		return -1;
	}
	public T get(int index) {
		
		for(int i=0; i<elements.length; i++) {
			if(i == index)
				return (T) elements[i];
		}
		
		return null;
	}
	
	
	
}
