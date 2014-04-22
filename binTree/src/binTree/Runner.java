package binTree;

import java.util.Collections;
import java.util.LinkedList;

import binTree.IBTree.IProcess;

public class Runner {

	public static void main(String[] args) {
		int maxElements = 100;
		final IBTree<Integer> bTree = new BTree<Integer>(maxElements / 2);
		final LinkedList<Integer> data = new LinkedList<>();
		for (int i = 1; i <= maxElements; i++) {
			data.add(i);
		}
		Collections.shuffle(data);
		for (int i = 0; i < maxElements; i++) {
			new Thread() {
				@Override
				public void run() {
					bTree.add(data.poll());
				};
			}.start();

		}
		int searchingValue = 80;
		IBTree<Integer> resultTree = bTree.find(new Integer(searchingValue));
		if (resultTree != null) {
			System.out.println("Found: counter=" + resultTree.getCounter() + ", value=" + resultTree.getValue());
		} else {
			System.out.println("Not found.");
		}
		IProcess<Integer> pr = new ShowValue<Integer>();
		bTree.forEach(pr);
		IProcess<Integer> fjProcess = new FJShowValue<Integer>(bTree);
		bTree.forEachFJ(fjProcess);
	}
}
