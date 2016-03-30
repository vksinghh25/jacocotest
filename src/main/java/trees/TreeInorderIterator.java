package trees;

import java.util.Iterator;
import java.util.Stack;

public class TreeInorderIterator implements Iterator<Node> {

	private Stack<Node> stack;

	public TreeInorderIterator(Node node) {
		stack = new Stack<Node>();
		addToStack(node);
	}

	private void addToStack(Node node) {
		while (node != null) {
			stack.push(node);
			node = node.getLeft();
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Node next() {
		Node next = stack.pop();
		if (next.getRight() != null) {
			addToStack(next.getRight());
		}
		return next;
	}
}
