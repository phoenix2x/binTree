package binTree;

import binTree.IBTree.Process;

public class ShowValue<T extends Comparable<T>> implements Process<T> {

	@Override
	public void process(T value) {
		System.out.println(value+"");
	}
}
