package binTree;

public interface IBTree<T extends Comparable<T>> {

	public IBTree<T> getLeft() ;

	public IBTree<T> getRight() ;

	public T getValue() ;
	public int getCounter();
	public void add(T value);
	public void forEach(Process<T> process);
	public interface Process<T>{
		public void process(T value);
	}

}
