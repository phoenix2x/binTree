package binTree;

public class Runner {

	public static void main(String[] args) {
		int maxElements = 100;
		final IBTree<Integer> bTree = new BTree<Integer>(5);
		bTree.add(8);
		bTree.add(3);
		bTree.add(8);
		bTree.add(10);
		for(int i=0;i<maxElements;i++){
			new Thread(){
				@Override
				public void run() {
					bTree.add(100);
				};
			}.start();
			
		}
		binTree.IBTree.Process<Integer> pr = new ShowValue<Integer>();
		bTree.forEach(pr);
		System.out.println("q");
	}

}
