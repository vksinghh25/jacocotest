package trees;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TreeInorderIteratorTests extends TestCase {

	public TreeInorderIteratorTests(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(TreeInorderIteratorTests.class);
	}

	public void testInorder1() {
		Node n23 = new Node(23);
		Node n10 = new Node(10);
		n23.setLeft(n10);

		List<Node> results = new ArrayList<Node>();

		TreeInorderIterator it = new TreeInorderIterator(n23);
		while(it.hasNext()) {
			results.add(it.next());
		}

		assertEquals(results.get(0).getData(), 10);
		assertEquals(results.get(1).getData(), 23);
	}

	public void testException() {
		Node n = null;
		TreeInorderIterator it = new TreeInorderIterator(n);

		try {
			it.next();
		}
		catch(Exception ex) {
			if(ex instanceof UnsupportedOperationException) {
				assertTrue(true);
			}
			else {
				assertTrue(false);      // fail the test
			}
		}
	}
}
