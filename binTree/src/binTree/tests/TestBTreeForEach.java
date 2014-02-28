package binTree.tests;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import binTree.BTree;
import binTree.ShowValue;

public class TestBTreeForEach {
	private static final Integer FIRST_VALUE = 100;
	private static final Integer LEFT_VALUE = 50;
	private static final Integer RIGHT_VALUE = 150;
	private static final ByteArrayOutputStream OUT = new ByteArrayOutputStream();
	private static final String NEW_LINE = "\r\n";
	
	@Before
	public void setOutStream() {
		System.setOut(new PrintStream(OUT));

	}
	@After
	public void cleanUpOutStream(){
		System.setOut(null);
	}
	@Test
	public void forEachTest() {
		
		BTree<Integer> bTree = new BTree<>(FIRST_VALUE);
		bTree.add(LEFT_VALUE);
		bTree.add(RIGHT_VALUE);

		bTree.forEach(new ShowValue<Integer>());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected1 = String.valueOf(FIRST_VALUE)+NEW_LINE+String.valueOf(LEFT_VALUE)+NEW_LINE+String.valueOf(RIGHT_VALUE);
		String expected2 = String.valueOf(FIRST_VALUE)+NEW_LINE+String.valueOf(RIGHT_VALUE)+NEW_LINE+String.valueOf(LEFT_VALUE);
		String actual = OUT.toString().trim();
		boolean result = expected1.equals(actual)||expected2.equals(actual);
		assertTrue(result);
		
	}
}
