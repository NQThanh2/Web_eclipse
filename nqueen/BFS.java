package nqueen;

import java.util.*;

public class BFS {
	public Node bfsUsingQueue(Node initial, int goal) {
		Queue<Node> st = new LinkedList<>();
		st.add(initial);

		while (!st.isEmpty()) {
			Node current = st.poll();

			if (current.state.size() == goal) {
				System.out.println("Found solution: " + current.state);
				return current;
			}

			List<Node> neighbours = current.getNeighbours();
			if (neighbours != null) {
				for (Node node : neighbours) {
					st.add(node);
				}
			}
		}
		return null;
		
	}
}
