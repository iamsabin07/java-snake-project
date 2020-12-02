package snakeCodes;


import java.lang.reflect.Array;
import java.util.ArrayList;

public final class snakeBag<T> implements snakeInterface<T> {
	private ArrayList<T> bag;
	
	public snakeBag() {
		bag = new ArrayList<T>();
	}

	@Override
	public int getCurrentSize() {
		return bag.size();
	}

	@Override
	public boolean isEmpty() {
		return bag.isEmpty();
	}

	@Override
	public boolean add(T newEntry) {
		return bag.add(newEntry);
	}

	@Override
	public T remove() {
		return bag.remove(bag.size() - 1);
	}

	@Override
	public boolean remove(T anEntry) {
		return bag.remove(anEntry);
	}

	@Override
	public void clear() {
		bag.clear();
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		for(T element : bag) {
			if(element.equals(anEntry))
				count++;
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		return bag.contains(anEntry);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		if (bag.size() == 0)
	        return null;

	    T temp = bag.get(0);
	    T[] stackArray = (T[]) Array.newInstance(temp.getClass(), bag.size());
	    for (int i = 0; i < bag.size(); i++) {
	        stackArray[i] = bag.get(i);
	    }
	    return (T[]) stackArray;
    }

	@Override
	public boolean add(int testarray) {
		// TODO Auto-generated method stub
		return false;
	}
}