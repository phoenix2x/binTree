package binTree;

import java.util.concurrent.RecursiveTask;

public class FJFind<T extends Comparable<T>> extends RecursiveTask<IBTree<T>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final T value;
	private final IBTree<T> ibTree;

	/**
	 * @param value
	 */
	public FJFind(T value, IBTree<T> ibTree) {
		super();
		this.value = value;
		this.ibTree = ibTree;
	}

	@Override
	protected IBTree<T> compute() {
		if (value.equals(ibTree.getValue())) {
			return ibTree;
		}
		if (value.compareTo(ibTree.getValue()) < 0) {
			return nextFind(ibTree.getLeft());
		} else {
			return nextFind(ibTree.getRight());
		}
	}

	private IBTree<T> nextFind(IBTree<T> node) {
		if (node != null) {
			FJFind<T> fjFind = new FJFind<T>(value, node);
			fjFind.fork();
			return fjFind.join();
		}
		return null;
	}
}
