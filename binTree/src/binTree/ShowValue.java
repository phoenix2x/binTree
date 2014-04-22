package binTree;

import binTree.IBTree.IProcess;


public class ShowValue<T extends Comparable<T>> implements IProcess<T> {

	@Override
	public void process(T value) {
		System.out.println("Basic print " + value);
	}
}
