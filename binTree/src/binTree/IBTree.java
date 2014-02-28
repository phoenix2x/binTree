package binTree;

public interface IBTree<T extends Comparable<T>> {

	public IBTree<T> getLeft() ;

	public IBTree<T> getRight() ;

	public T getValue() ;
	public int getCounter();
	public void add(T value);
	public void forEach(IProcess<T> process);
	public interface IProcess<T>{
		public void process(T value);
	}

}
