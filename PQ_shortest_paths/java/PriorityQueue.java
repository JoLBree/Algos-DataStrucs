import java.util.ArrayList;

//
// PRIORITYQUEUE.JAVA
// A priority queue class supporting sundry operations needed for
// Dijkstra's algorithm.
//
@SuppressWarnings("unchecked")
class PriorityQueue<T> {
	ArrayList<Element> heap; //Elements are my "nodes"

	// constructor
	//
	public PriorityQueue()
	{
		heap = new ArrayList<Element>();
	}

	// Return true iff the queue is empty.
	//
	public boolean isEmpty()
	{
		if (heap.isEmpty())	return true;
		else return false;
	}

	// Insert a pair (key, value) into the queue, and return
	// a Handle to this pair so that we can find it later in
	// constant time.
	//
	Handle insert(int key, T value)
	{
		int index = heap.size(); // the last unfilled index.
		Handle h = new Handle(key, index);
		Element ele = new Element(value, key, h);
		heap.add(ele);
		bubbleUp(index);   	
		return h;
	}

	// Return the smallest key in the queue.
	//
	public int min()
	{
		return heap.get(0).key;
	}

	public void swap(int index1, int index2){

		// update handles
		heap.get(index1).handle.index = index2;
		heap.get(index2).handle.index = index1;

		// swap contents of elements
		Object record1 = heap.get(index1).record;
		int key1 = heap.get(index1).key;
		Handle h1 = heap.get(index1).handle;
		heap.get(index1).record = heap.get(index2).record;
		heap.get(index1).key = heap.get(index2).key;
		heap.get(index1).handle = heap.get(index2).handle;
		heap.get(index2).record = record1;
		heap.get(index2).key = key1;
		heap.get(index2).handle = h1;
	}

	public void bubbleUp(int index){ 
		int parentIndex = (int)(Math.ceil((index*1.0)/2.0)-1);
		while (parentIndex >=0 && index >=0 && heap.get(index).key < heap.get(parentIndex).key){//while key is less than node's parent
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = (int)(Math.ceil((index*1.0)/2.0)-1);
		}
	}

	public void bubbleDown(int index){ // aka heapify
		int maxIndex = heap.size()-1;
		int leftChildIndex = index*2+1;
		int rightChildIndex = index*2+2;
		int smallerChildIndex;		
		if (leftChildIndex <= maxIndex && rightChildIndex <= maxIndex && heap.get(leftChildIndex).key > heap.get(rightChildIndex).key) {
			smallerChildIndex = rightChildIndex;
		}
		else if (leftChildIndex <= maxIndex) {
			smallerChildIndex = leftChildIndex;
		}
		else return;
		while (heap.get(index).key > heap.get(smallerChildIndex).key){
			swap(index, smallerChildIndex);
			index = smallerChildIndex;
			leftChildIndex = index*2+1;
			rightChildIndex = index*2+2;
			if (leftChildIndex <= maxIndex && rightChildIndex <= maxIndex && heap.get(leftChildIndex).key > heap.get(rightChildIndex).key) {
				smallerChildIndex = rightChildIndex;
			}
			else if (leftChildIndex <= maxIndex){
				smallerChildIndex = leftChildIndex;
			}
			else return;
		}		
	}
	
	// Extract the (key, value) pair associated with the smallest
	// key in the queue and return its "value" object.
	//
	public T extractMin()
	{
		if (heap.isEmpty()) return null;
		T value = (T) heap.get(0).record;
		int lastIndex = heap.size()-1;
		swap(0, lastIndex);
		heap.get(lastIndex).handle.invalidated = true;
		heap.remove(lastIndex);
		bubbleDown(0);		
		return value;
	}

	// Look at the (key, value) pair referenced by Handle h.
	// If that pair is no longer in the queue, or its key
	// is <= newkey, do nothing and return false.  Otherwise,
	// replace "key" by "newkey", fixup the queue, and return
	// true.
	//
	public boolean decreaseKey(Handle h, int newkey)
	{
		if (h.invalidated || h.key <= newkey) return false;
		else{
			int index = h.index;
			h.key = newkey;
			heap.get(index).key = newkey;
			bubbleUp(index); // only need to consider bubbleUp, since key value has decreased
			return true;
		}		
	}


	// Get the key of the (key, value) pair associated with a 
	// given Handle. (This result is undefined if the handle no longer
	// refers to a pair in the queue.)
	//
	public int handleGetKey(Handle h)
	{
		return h.key;
	}

	// Get the value object of the (key, value) pair associated with a 
	// given Handle. (This result is undefined if the handle no longer
	// refers to a pair in the queue.)
	//
	public T handleGetValue(Handle h)
	{
		return (T) heap.get(h.index).record;
	}
	
	public Handle getHandle(int index){
		return heap.get(index).handle;
	}

	// Print every element of the queue in the order in which it appears
	// in the implementation (i.e. the array representing the heap).
	public String toString()
	{
		String a = "{";
		for (int i = 0; i < heap.size(); i++){
			a = a + heap.get(i).key + " ";
		}
		a = a + "}";
		return a;
	}
	
	
	public static void main(String[] args) {

	}

	
	
	
	
	
	
	
	
	
	
	
}
