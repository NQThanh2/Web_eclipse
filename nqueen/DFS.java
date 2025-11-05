package nqueen;

import java.util.*;

public class DFS {
	public Node dfsUsingStack(Node initial, int goal) {
		Stack<Node> st = new Stack<>();
		st.push(initial);

		while (!st.isEmpty()) {
			Node current = st.pop();

			if (current.state.size() == goal) {
				System.out.println("Found solution: " + current.state);
				return current;
			}

			List<Node> neighbours = current.getNeighbours();
			if (neighbours != null) {
				for (Node node : neighbours) {
					st.push(node);
				}
			}
		}
		return null;
	}
}
