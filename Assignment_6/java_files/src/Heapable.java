import java.util.ArrayList;

/**
 * @author hillebrandj3779
 * This Interface is meant to outline the class Heap,
 * which can be used to implement a functioning Heap 
 * datastructure
 */

public interface Heapable {
	ArrayList<Integer> list = new ArrayList<Integer>();

	//Enqueue and Dequeue Methods
	public abstract void enqueue(int entry);
	public abstract int dequeue();
	public abstract int size();
	public abstract void heapSort(ArrayList<Integer> data);
}
