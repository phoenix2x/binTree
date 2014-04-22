package binTree;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class BTree<T extends Comparable<T>> implements IBTree<T> {
	private final static ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
	private final T value;
	private IBTree<T> left;
	private IBTree<T> right;
	private AtomicInteger counter = new AtomicInteger(1);

	/**
	 * @param value
	 * @param left
	 * @param right
	 * @param counter
	 */
	public BTree(T value) {
		super();
		this.value = value;
	}

	/**
	 * @return the left
	 */
	@Override
	public IBTree<T> getLeft() {
		return left;
	}

	/**
	 * @return the right
	 */
	@Override
	public IBTree<T> getRight() {
		return right;
	}

	/**
	 * @return the value
	 */
	@Override
	public T getValue() {
		return value;
	}

	/**
	 * @return the counter
	 */
	@Override
	public int getCounter() {
		return counter.get();
	}

	@Override
	public void add(T value) {
		if (getValue().equals(value)) {
			counter.incrementAndGet();
		} else {
			if (getValue().compareTo(value) < 0) {
				addRight(value);
			} else {
				addLeft(value);
			}
		}

	}

	private void addRight(T value) {
		if (getRight() == null) {
			setRight(new BTree<T>(value));
		} else {
			getRight().add(value);
		}
	}

	private void addLeft(T value) {
		if (getLeft() == null) {
			setLeft(new BTree<T>(value));
		} else {
			getLeft().add(value);
		}
	}

	private void setLeft(IBTree<T> left) {
		this.left = left;
	}

	private void setRight(IBTree<T> right) {
		this.right = right;
	}

	@Override
	public void forEach(final IProcess<T> process) {
		new Thread() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				process.process(getValue());
			}

		}.start();
		if (getLeft() != null) {
			getLeft().forEach(process);
		}
		if (getRight() != null) {
			getRight().forEach(process);
		}
	}
	
	@Override
	public IBTree<T> find(T value) {
		FJFind<T> root = new FJFind<T>(value, this);
		FORK_JOIN_POOL.submit(root);
		return root.join();
	}

	@Override
	public void forEachFJ(binTree.IBTree.IProcess<T> process) {
		if (process instanceof FJShowValue) {
		FJShowValue<T> fjShowValue = (FJShowValue<T>) process;
		FORK_JOIN_POOL.invoke(fjShowValue);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
