/**
 * 
 */
package binTree.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import binTree.BTree;

/**
 * @author phoenix
 *
 */
public class TestBTree {

	private static final Integer FIRST_VALUE = 100;
	private static final Integer LEFT_VALUE = 50;
	private static final Integer RIGHT_VALUE = 150;

	@Test
	public void addTest() {
	
		BTree<Integer> bTree = new BTree<Integer>(FIRST_VALUE);
		bTree.add(LEFT_VALUE);
		bTree.add(RIGHT_VALUE);
		assertEquals("wrong first value",FIRST_VALUE, bTree.getValue());
		assertEquals("wrong left value",LEFT_VALUE, bTree.getLeft().getValue());
		assertEquals("wrong right value",RIGHT_VALUE, bTree.getRight().getValue());
	}
	@Test
	public void counterTest(){
		
		final int count=100;
		BTree<Integer> bTree = new BTree<Integer>(FIRST_VALUE);
		for(int i=0;i<count;i++){
		bTree.add(FIRST_VALUE);	
		bTree.add(LEFT_VALUE);
		bTree.add(RIGHT_VALUE);
		}
		assertEquals("wrong first value count",count+1, bTree.getCounter());
		assertEquals("wrong left value count",count, bTree.getLeft().getCounter());
		assertEquals("wrong right value count",count, bTree.getRight().getCounter());
	}
}
