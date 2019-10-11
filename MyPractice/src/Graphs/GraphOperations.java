package Graphs;

import java.util.*;

public class GraphOperations {
	/*
	 * There are N elephants and M relationships of their heights like E1 > E2 i.e. height of E1 is greater than height of E2.
	 * Is it possible to sort elephants in ascending order with given relationships.
	 * What is the sorted order ?
	 */
	/*
	 * For less height use -1, greater than equal use 1 and 0 represents no relationship.
	 */
	public static void SortElephantsByHeight(boolean[][] lessThan) {
		boolean[] visited = new boolean[lessThan[0].length];
		
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		
		int count=0;
		Stack<Integer> sortedOrder = new Stack<Integer>();
		for(int i=0; i<visited.length; i++) {
			if(!visited[i]) {
				count++;
				SortElephantsByHeightHelper(lessThan, visited, i, sortedOrder);
			}
		}
		
		if(count == 1) {
			System.out.println("Yes, given relationships are sufficient enough to sort elephants.");
		} else {
			System.out.println("No, given relationships are not sufficient enough to sort elephants.");
		}
		
		System.out.print("Sorted order > ");
		while(!sortedOrder.isEmpty()) {
			System.out.print(sortedOrder.pop() + " ");
		}
	}
	
	private static void SortElephantsByHeightHelper(boolean[][] lessThan, boolean[] visited, int index, Stack<Integer> sortedOrder) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(index);
		
		while(!stack.isEmpty()) {
			Integer temp = stack.pop();
			visited[temp] = true;
			
			for(int i=0; i<lessThan[temp].length; i++) {
				if(i != temp && !visited[i] && lessThan[temp][i]) {
					stack.push(i);
				}
			}
			
			sortedOrder.push(temp);
		}
		
	}
	
	/*
	 * Breadth First Traversal
	 */
	public static void BreadthFirstTraversal(Graph graph) {
		System.out.print("Breadth First Traversal > ");
		
		boolean[] visited = new boolean[graph.VerticesCount()];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int index = queue.remove();
			System.out.print(graph.Vertex(index) + " ");
			
			for(int adjacentIndex : graph.AdjacentVerticesIndex(index)) {
				if(!visited[adjacentIndex]) {
					queue.add(adjacentIndex);
					visited[adjacentIndex] = true;
				}
			}
		}
		
		System.out.println();
	}
	
	
	/*
	 * Depth First Traversal
	 */
	public static void DepthFirstTraversal(Graph graph) {
		System.out.print("Depth First Traversal > ");
		
		boolean[] visited = new boolean[graph.VerticesCount()];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		visited[0] = true;
		
		while(!stack.isEmpty()) {
			int index = stack.pop();
			System.out.print(graph.Vertex(index) + " ");
			
			for(int adjacentIndex : graph.AdjacentVerticesIndex(index)) {
				if(!visited[adjacentIndex]) {
					stack.push(adjacentIndex);
					visited[adjacentIndex] = true;
				}
			}
		}
		
		System.out.println();
	}
	
	
	/*
	 * Topological Sort using BFS
	 */
	public static void TopologicalSortBFS(Graph graph) {
		System.out.print("Topological Sort using BFS > ");
		
		int[] indegree = graph.Indegree();
		boolean[] visited = new boolean[graph.VerticesCount()];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
			if(indegree[i] == 0) {
				visited[i] = true;
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int index = queue.remove();
			System.out.print(graph.Vertex(index) + " ");
			
			for(int adjacentIndex : graph.AdjacentVerticesIndex(index)) {
				if(!visited[adjacentIndex]) {
					indegree[adjacentIndex]--;
					
					if(indegree[adjacentIndex] == 0) {
						queue.add(adjacentIndex);
						visited[adjacentIndex] = true;
					}
				}
			}
		}
		
		System.out.println();
	}
	
	
	/*
	 * Topological Sort using DFS
	 */
	public static void TopologicalSortDFS(Graph graph) {
		System.out.print("Topological Sort using DFS > ");
		
		boolean[] visited = new boolean[graph.VerticesCount()];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		visited[0] = true;
		
		while(!stack.isEmpty()) {
			int index = stack.pop();
			System.out.print(graph.Vertex(index) + " ");
			
			for(int adjacentIndex : graph.AdjacentVerticesIndex(index)) {
				if(!visited[adjacentIndex]) {
					stack.push(adjacentIndex);
					visited[adjacentIndex] = true;
				}
			}
		}
		
		System.out.println();
	}
	
	
//	/*
//	 * Breadth First Traversal
//	 */
//	public static void BreadthFirstTraversal(Graph graph) {
//		System.out.println("Breadth First Traversal");
//		boolean[] visited = new boolean[graph.Nodes.size()];
//		
//		for(int i=0; i<graph.Nodes.size(); i++) {
//			visited[i] = false;
//		}
//		
//		for(int i=0; i<graph.Nodes.size(); i++) {
//			if(!visited[i]) {
//				BreadthFirstTraversalUtil(graph, visited, graph.Nodes.get(i));
//			}
//		}
//		System.out.println();
//	}
//	
//	private static void BreadthFirstTraversalUtil(Graph graph, boolean[] visited, GraphNode nodeToProcess) {
//		Queue<GraphNode> queue = new LinkedList<GraphNode>();
//		
//		queue.add(nodeToProcess);
//		while(!queue.isEmpty()) {
//			GraphNode node = queue.remove();
//			visited[graph.Nodes.indexOf(node)] = true;
//			System.out.print(node.Data + " ");
//			
//			for(int i=0; i<node.AdjacentNodes.size(); i++) {
//				GraphNode adjacentNode = node.AdjacentNodes.get(i);
//				if(!visited[graph.Nodes.indexOf(adjacentNode)]) {
//					queue.add(adjacentNode);
//				}
//			}
//		}
//	}
//	
//	
//	/*
//	 * Depth First Traversal
//	 */
//	public static void DepthFirstTraversal(Graph graph) {
//		System.out.println("Depth First Traversal");
//		boolean[] visited = new boolean[graph.Nodes.size()];
//		
//		for(int i=0; i<graph.Nodes.size(); i++) {
//			visited[i] = false;
//		}
//		
//		for(int i=0; i<graph.Nodes.size(); i++) {
//			if(!visited[i]) {
//				DepthFirstTraversalUtil(graph, visited, graph.Nodes.get(i));
//			}
//		}
//		
//		System.out.println();
//	}
//	
//	private static void DepthFirstTraversalUtil(Graph graph, boolean[] visited, GraphNode nodeToProcess) {
//
//		Stack<GraphNode> stack = new Stack<GraphNode>();
//		stack.add(nodeToProcess);
//		while(!stack.isEmpty()) {
//			GraphNode node = stack.pop();
//			visited[graph.Nodes.indexOf(node)] = true;
//			System.out.print(node.Data + " ");
//			
//			for(int i=0; i<node.AdjacentNodes.size(); i++) {
//				GraphNode adjacentNode = node.AdjacentNodes.get(i);
//				if(!visited[graph.Nodes.indexOf(adjacentNode)]) {
//					stack.push(adjacentNode);
//				}
//			}
//		}
//	}
//	
//	
//	/*
//	 * Topological sort
//	 */
//	public static void TopologicalSort(Graph graph) {
//		System.out.println("Topological Sort");
//		boolean[] visited = new boolean[graph.Nodes.size()];
//		int[] indegree = graph.GetIndegrees();
//		
//		Queue<GraphNode> queue = new LinkedList<GraphNode>();
//		for(int i=0; i<visited.length; i++) {
//			visited[i] = false;
//			
//			if(indegree[i] == 0) {
//				queue.add(graph.Nodes.get(i));
//				visited[i] = true;
//			}
//		}
//		
//		while(!queue.isEmpty()) {
//			GraphNode node = queue.remove();
//			System.out.print(node.Data + " ");
//			for(GraphNode adjacentNode : node.AdjacentNodes) {
//				int index = graph.Nodes.indexOf(adjacentNode);
//				
//				if(!visited[index]) {
//					indegree[index]--;
//					if(indegree[index] == 0) {
//						visited[index] = true;
//						queue.add(adjacentNode);
//					}
//				}
//			}
//		}
//		
//		System.out.println();
//	}
//	
//	private static void TopologicalSortUtil(Graph graph, int[]indegree, boolean[] visited, int index) {
//	}

}
