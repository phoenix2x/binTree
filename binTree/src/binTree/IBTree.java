package binTree;

public interface IBTree<T extends Comparable<T>> {

	IBTree<T> getLeft() ;

	IBTree<T> getRight() ;

	T getValue() ;
	
	int getCounter();
	
	void add(T value);
	
	void forEach(IProcess<T> process);
	void forEachFJ(IProcess<T> process);
	IBTree<T> find(T value);
	
	interface IProcess<T>{
		public void process(T value);
	}
}
