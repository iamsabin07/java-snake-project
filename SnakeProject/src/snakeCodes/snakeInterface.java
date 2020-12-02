package snakeCodes;

public interface snakeInterface <T>{
		
		//Gets the current number of entries in this bag.
		public int getCurrentSize();

		// Sees whether this bag is empty.
		public boolean isEmpty();

		// Adds a new entry to this bag.
		public boolean add(int testarray);

		public boolean add(T newEntry);

		//Removes one unspecified entry from this bag
		public T remove();

		// Removes one occurrence of a given entry from this bag
		public boolean remove(T anEntry);

		// Removes all entries from this bag. 
		public void clear();

		//Counts the number of times a given entry appears in this bag. 
		public int getFrequencyOf(T anEntry);

		//Tests whether this bag contains a given entry.
		public boolean contains(T anEntry);

		// Retrieves all entries that are in this bag.
		public T[] toArray(); 

		} 

