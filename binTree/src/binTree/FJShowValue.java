package binTree;

import java.util.concurrent.RecursiveAction;

import binTree.IBTree.IProcess;

public class FJShowValue<T extends Comparable<T>> extends RecursiveAction implements IProcess<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final IBTree<T> ibTree;

	/**
	 * @param ibTree
	 */
	public FJShowValue(IBTree<T> ibTree) {
		super();
		this.ibTree = ibTree;
	}

	@Override
	protected void compute() {
		if (ibTree != null) {
			process(ibTree.getValue());
			invokeAll(new FJShowValue<>(ibTree.getLeft()), new FJShowValue<>(ibTree.getRight()));
		}
	}

	@Override
	public void process(T value) {
		 System.out.println("FJPrint " + value);
	}
}
